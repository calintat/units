package com.calintat.units.activities

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.widget.EditText
import com.calintat.units.R
import com.calintat.units.recycler.Adapter
import com.calintat.units.ui.MainUI
import com.calintat.units.ui.MainUI.drawerLayout
import com.calintat.units.ui.MainUI.editText
import com.calintat.units.ui.MainUI.navigationView
import com.calintat.units.ui.MainUI.recyclerView
import com.calintat.units.ui.MainUI.textView1
import com.calintat.units.ui.MainUI.textView2
import com.calintat.units.ui.MainUI.toolbar
import com.calintat.units.utils.Converter
import com.calintat.units.utils.ShortcutUtils
import com.github.calintat.getBoolean
import com.github.calintat.getInt
import com.github.calintat.putInt
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    private val KEY_ID = "com.calintat.units.KEY_ID"

    private val adapter by lazy { Adapter(this) }

    private var id: Int? = null

    private var position: Int? = null

    private var favourites = emptySet<Int>()

    //----------------------------------------------------------------------------------------------

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        MainUI.setContentView(this)

        setTheme()

        setToolbar()

        setMainContent()

        setNavigationView()

        init(savedInstanceState)
    }

    override fun onResume() {

        super.onResume()

        refreshRecyclerView()

        refreshNavigationView()
    }

    override fun onPause() {

        super.onPause()

        updateShortcuts()
    }

    override fun onBackPressed() {

        when (drawerLayout.isDrawerOpen(navigationView)) {

            true -> drawerLayout.closeDrawers()

            else -> super.onBackPressed()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {

        id?.let { outState.putInt(KEY_ID, it) }

        super.onSaveInstanceState(outState)
    }

    //----------------------------------------------------------------------------------------------

    private fun init(savedInstanceState: Bundle?) {

        configuration(fromSdk = 25) { favourites = ShortcutUtils.getShortcuts(this) }

        val defaultId = getInt(KEY_ID, R.id.navigation_length)

        if (savedInstanceState == null) { /* opened from launcher or app shortcut */

            selectId(ShortcutUtils.retrieveId(intent.action) ?: defaultId)
        }
        else { /* orientation change, activity resumed, etc */

            selectId(savedInstanceState.getInt(KEY_ID, defaultId))
        }
    }

    private fun selectId(@IdRes id: Int) {

        this.id = id

        putInt(KEY_ID, id)

        refreshActionMenu()

        val item = Converter.get(id)

        adapter.units = item.units

        toolbar.setBackgroundResource(item.color)

        drawerLayout.setStatusBarBackground(item.colorDark)

        selectPosition(0)
    }

    private fun selectPosition(position: Int) {

        this.position = position

        refreshRecyclerView()

        textView1.setText(adapter.units[position].name)

        textView2.setText(adapter.units[position].symbol)
    }

    private fun setTheme() {

        when (getBoolean("pref_dark_theme")) {

            true -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun setToolbar() {

        toolbar.inflateMenu(R.menu.action)

        toolbar.setOnMenuItemClickListener {

            when (it.itemId) {

                R.id.action_remove_from_favourites -> { removeFromFavourites(); true }

                R.id.action_add_to_favourites -> { addToFavourites(); true }

                R.id.action_clear_input -> { clearInput(); true }

                else -> false
            }
        }

        toolbar.setNavigationIcon(R.drawable.ic_action_menu)

        toolbar.setNavigationOnClickListener { drawerLayout.openDrawer(navigationView) }

        toolbar.overflowIcon = ContextCompat.getDrawable(this, R.drawable.ic_action_overflow)
    }

    private fun setMainContent() {

        editText.afterTextChanged { refreshActionMenu(); refreshRecyclerView() }

        adapter.onClick = { selectPosition(it) }

        adapter.onLongClick = { copyToClipboard(it) }

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    private fun setNavigationView() {

        navigationView.inflateMenu(R.menu.navigation)

        navigationView.setNavigationItemSelectedListener {

            drawerLayout.closeDrawers()

            when (it.itemId) {

                R.id.navigation_settings -> startActivity<SettingsActivity>()

                R.id.navigation_feedback -> gotoFeedback()

                else -> selectId(it.itemId)
            }

            true
        }
    }

    private fun clearInput() = editText.text.clear()

    private fun addToFavourites() = id?.let {

        if (favourites.size < 4) { /* can add to favourites */

            favourites += it

            refreshActionMenu()

            toast(R.string.msg_add_to_favourites)
        }
        else { /* error: cannot have more than 4 favourites */

            toast(R.string.err_add_to_favourites)
        }
    }

    private fun removeFromFavourites() = id?.let {

        favourites -= it

        refreshActionMenu()

        toast(R.string.msg_remove_from_favourites)
    }

    private fun refreshActionMenu() {

        val api25 = Build.VERSION.SDK_INT >= 25

        val contained = favourites.contains(id)

        toolbar.menu.findItem(R.id.action_clear_input).isVisible = editText.text.isNotEmpty()

        toolbar.menu.findItem(R.id.action_add_to_favourites).isVisible = api25 && !contained

        toolbar.menu.findItem(R.id.action_remove_from_favourites).isVisible = api25 && contained
    }

    private fun refreshRecyclerView() {

        val num = editText.text.toString().toDoubleOrNull() ?: Double.NaN

        position?.let { adapter.input = adapter.units[it].selfToBase(num) }
    }

    private fun refreshNavigationView() {

        navigationView.menu.setGroupVisible(R.id.advanced, getBoolean("pref_advanced", true))
    }

    private fun gotoFeedback() {

        val builder = CustomTabsIntent.Builder()

        id?.let { builder.setToolbarColor(ContextCompat.getColor(this, Converter.get(it).color)) }

        builder.build().launchUrl(this, Uri.parse("https://github.com/calintat/units/issues"))
    }

    private fun copyToClipboard(text: String) {

        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        clipboardManager.primaryClip = ClipData.newPlainText("conversion output", text)

        toast(R.string.msg_clipboard)
    }

    private fun updateShortcuts() = configuration(fromSdk = 25) {

        ShortcutUtils.setShortcuts(this, favourites)
    }

    private fun EditText.afterTextChanged(listener: (Editable?) -> Unit) {

        textChangedListener { afterTextChanged(listener) }
    }
}