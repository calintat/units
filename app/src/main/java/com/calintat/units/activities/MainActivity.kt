package com.calintat.units.activities

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.view.Gravity
import android.widget.EditText
import com.calintat.alps.getBoolean
import com.calintat.alps.getInt
import com.calintat.alps.putInt
import com.calintat.units.R
import com.calintat.units.api.Converter
import com.calintat.units.api.Item
import com.calintat.units.recycler.Adapter
import com.calintat.units.ui.MainUI
import com.calintat.units.ui.MainUI.drawerLayout
import com.calintat.units.ui.MainUI.editText
import com.calintat.units.ui.MainUI.navigationView
import com.calintat.units.ui.MainUI.recyclerView
import com.calintat.units.ui.MainUI.textView1
import com.calintat.units.ui.MainUI.textView2
import com.calintat.units.ui.MainUI.toolbar
import com.calintat.units.utils.BillingHelper
import org.jetbrains.anko.sdk21.listeners.textChangedListener
import org.jetbrains.anko.selector
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private val KEY_ID = "com.calintat.units.KEY_ID"

    private val adapter by lazy { Adapter(this) }

    private var id: Int? = null

    private var position: Int? = null

    private var billingHelper: BillingHelper? = null

    //----------------------------------------------------------------------------------------------

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        MainUI.setContentView(this)

        setTheme()

        setToolbar()

        setMainContent()

        setNavigationView()

        init(savedInstanceState)

        billingHelper = BillingHelper(this)
    }

    override fun onDestroy() {

        super.onDestroy()

        billingHelper?.destroy()
    }

    override fun onResume() {

        super.onResume()

        refreshRecyclerView()

        refreshNavigationView()
    }

    override fun onBackPressed() {

        when {

            drawerLayout.isDrawerOpen(Gravity.START) -> drawerLayout.closeDrawers()

            else -> super.onBackPressed()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {

        id?.let { outState.putInt(KEY_ID, it) }

        super.onSaveInstanceState(outState)
    }

    //----------------------------------------------------------------------------------------------

    private fun init(savedInstanceState: Bundle?) {

        val defaultId = getInt(KEY_ID).takeIf { Item.isIdSafe(it) } ?: R.id.navigation_length

        if (savedInstanceState == null) { /* opened from launcher or app shortcut */

            selectId(Item.get(intent)?.id ?: defaultId)
        }
        else { /* orientation change, activity resumed, etc */

            selectId(savedInstanceState.getInt(KEY_ID, defaultId))
        }
    }

    private fun selectId(@IdRes id: Int) {

        this.id = id

        putInt(KEY_ID, id)

        refreshActionMenu()

        val item = Item.get(id) ?: return

        adapter.units = Converter.retrieveUnits(item)

        selectPosition(0)

        toolbar.setBackgroundResource(item.color)

        drawerLayout.setStatusBarBackground(item.colorDark)
    }

    private fun selectPosition(position: Int) {

        this.position = position

        refreshRecyclerView()

        textView1.setText(adapter.units[position].label)

        textView2.setText(adapter.units[position].shortLabel)
    }

    private fun setTheme() {

        AppCompatDelegate.setDefaultNightMode(getInt("pref_theme"))
    }

    private fun setToolbar() {

        toolbar.inflateMenu(R.menu.action)

        toolbar.setOnMenuItemClickListener {

            when (it.itemId) {

                R.id.action_clear_input -> { clearInput(); true }

                else -> false
            }
        }

        toolbar.setNavigationIcon(R.drawable.ic_action_menu)

        toolbar.setNavigationOnClickListener { drawerLayout.openDrawer(Gravity.START) }

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

                R.id.navigation_donation -> makeDonation()

                else -> selectId(it.itemId)
            }

            true
        }
    }

    private fun clearInput() = editText.text.clear()

    private fun refreshActionMenu() {

        toolbar.menu.findItem(R.id.action_clear_input).isVisible = editText.text.isNotEmpty()
    }

    private fun refreshRecyclerView() {

        val num = editText.text.toString().toDoubleOrNull() ?: Double.NaN

        position?.let { adapter.input = adapter.units[it].selfToBase(this, num) }
    }

    private fun refreshNavigationView() {

        navigationView.menu.setGroupVisible(R.id.advanced, getBoolean("pref_advanced", true))
    }

    private fun gotoFeedback() {

        val builder = CustomTabsIntent.Builder()

        Item.get(id)?.let { builder.setToolbarColor(ContextCompat.getColor(this, it.color)) }

        builder.build().launchUrl(this, Uri.parse("https://github.com/calintat/units/issues"))
    }

    private fun makeDonation() {

        val title = getString(R.string.navigation_donation)

        val items = listOf("£0.99", "£1.99", "£2.99", "£3.99", "£4.99", "£9.99")

        selector(title, items) { _, index -> billingHelper?.makeDonation("donation$index") }
    }

    private fun copyToClipboard(text: String) {

        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        clipboardManager.primaryClip = ClipData.newPlainText("conversion output", text)

        toast(R.string.msg_clipboard)
    }

    private fun EditText.afterTextChanged(listener: (Editable?) -> Unit) {

        textChangedListener { afterTextChanged(listener) }
    }
}