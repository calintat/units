package com.calintat.units.activities

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.calintat.units.R
import com.calintat.units.recycler.Adapter
import com.calintat.units.utils.Converter
import com.calintat.units.utils.PreferenceUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private val KEY_QUANTITY = "com.calintat.units.KEY_QUANTITY"

    private val KEY_POSITION = "com.calintat.units.KEY_POSITION"

    private val QUICK_ACCESS = "com.calintat.units.QUICK_ACCESS"

    var adapter = Adapter(this)

    var position by Delegates.notNull<Int>()

    var quantity by Delegates.notNull<Converter.Quantity>()

    //----------------------------------------------------------------------------------------------

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setTheme()

        setToolbar()

        setConverter()

        setRecyclerView()

        setNavigationView()

        restore(savedInstanceState)
    }

    override fun onResume() {

        super.onResume()

        updateRecyclerView()

        updateNavigationView()
    }

    override fun onBackPressed() {

        when {

            drawerLayout.isDrawerOpen(navigationView) -> drawerLayout.closeDrawers()

            else -> super.onBackPressed()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {

        outState.putInt(KEY_QUANTITY, quantity.id)

        outState.putInt(KEY_POSITION, position)

        super.onSaveInstanceState(outState)
    }

    //----------------------------------------------------------------------------------------------

    private fun setTheme() {

        when (PreferenceUtils.getBoolean(this, "pref_dark_theme", false)) {

            true -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun setToolbar() {

        toolbar.inflateMenu(R.menu.action)

        toolbar.setOnMenuItemClickListener { editText.text.clear(); true }

        toolbar.setNavigationIcon(R.drawable.ic_action_menu)

        toolbar.setNavigationOnClickListener { drawerLayout.openDrawer(navigationView) }
    }

    private fun setConverter() {

        editText.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                // do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                // do nothing
            }

            override fun afterTextChanged(s: Editable?) {

                updateRecyclerView()
            }
        })
    }

    private fun setRecyclerView() {

        adapter.onClick = { updateSelection(it) }

        adapter.onLongClick = { copyToClipboard(it) }

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }

    private fun setNavigationView() {

        navigationView.inflateMenu(R.menu.navigation)

        navigationView.setNavigationItemSelectedListener {

            drawerLayout.closeDrawers()

            when (it.itemId) {

                R.id.navigation_settings -> gotoSettings()

                R.id.navigation_feedback -> gotoFeedback()

                else -> updateSelection(Converter.get(it.itemId))
            }

            true
        }
    }

    //----------------------------------------------------------------------------------------------

    fun restore(savedInstanceState: Bundle?) {

        if (savedInstanceState == null) { // opened from launcher or app shortcut

            val defId = PreferenceUtils.getInt(this, QUICK_ACCESS, R.id.navigation_length)

            val quantity = Converter.getShortcut(intent.action, defId)

            updateSelection(quantity)
        } else { // orientation change, etc

            val quantity = Converter.get(savedInstanceState.getInt(KEY_QUANTITY))

            val position = savedInstanceState.getInt(KEY_POSITION)

            updateSelection(quantity, position)
        }
    }

    //----------------------------------------------------------------------------------------------

    fun updateRecyclerView() {

        val num = editText.text.toString().safeToDouble()

        adapter.input = quantity.units[position].selfToBase(num)
    }

    fun updateNavigationView() {

        val preference = PreferenceUtils.getBoolean(this, "pref_advanced")

        navigationView.menu.setGroupVisible(R.id.advanced, preference)
    }

    fun updateSelection(position: Int) {

        this.position = position

        updateRecyclerView()

        textView1.setText(quantity.units[position].name)

        textView2.setText(quantity.units[position].symbol)
    }

    fun updateSelection(quantity: Converter.Quantity, position: Int = 0) {

        this.quantity = quantity

        adapter.units = quantity.units

        updateSelection(position)

        toolbar.setBackgroundResource(quantity.color)

        drawerLayout.setStatusBarBackground(quantity.colorDark)

        PreferenceUtils.putInt(this, QUICK_ACCESS, quantity.id)
    }

    //----------------------------------------------------------------------------------------------

    fun gotoSettings() = startActivity(Intent(this, SettingsActivity::class.java))

    fun gotoFeedback() {

        val builder = CustomTabsIntent.Builder()

        builder.setToolbarColor(ContextCompat.getColor(this, quantity.color))

        builder.build().launchUrl(this, Uri.parse("https://github.com/calintat/Units/issues"))
    }

    fun copyToClipboard(str: String) {

        val c = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        c.primaryClip = ClipData.newPlainText("conversion output", str)

        Toast.makeText(this, R.string.clipboard, Toast.LENGTH_SHORT).show()
    }

    fun String.safeToDouble() = try { toDouble() } catch (e: NumberFormatException) { Double.NaN }
}