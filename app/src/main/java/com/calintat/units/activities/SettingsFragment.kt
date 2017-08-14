package com.calintat.units.activities

import android.content.Context
import android.content.pm.ShortcutManager
import android.os.Build
import android.os.Bundle
import android.preference.MultiSelectListPreference
import android.preference.PreferenceFragment
import android.support.annotation.RequiresApi
import android.support.design.widget.Snackbar
import com.calintat.units.R
import com.calintat.units.api.Item
import org.jetbrains.anko.ctx
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class SettingsFragment : PreferenceFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        addPreferencesFromResource(R.xml.preferences)

        findPreference("pref_theme").setOnPreferenceChangeListener { _, _ ->

            Snackbar.make(view, R.string.msg_app_restart_required, Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.action_restart) { System.exit(0) }.show()

            true
        }

        if (Build.VERSION.SDK_INT >= 25) {

            val shortcutsPref = findPreference("pref_shortcuts") as MultiSelectListPreference

            val items = Item.values()

            shortcutsPref.entries = items.map { ctx.getString(it.label) }.toTypedArray()

            shortcutsPref.entryValues = items.map { item -> item.shortcutId }.toTypedArray()

            shortcutsPref.setOnPreferenceChangeListener { _, newValue ->

                @Suppress("UNCHECKED_CAST") val shortcutIds = newValue as Set<String>

                if (shortcutIds.size <= 4) { updateShortcuts(shortcutIds); true }

                else { toast(R.string.err_shortcuts); false /* error: maximum 4 shortcuts */ }
            }
        }
    }

    @RequiresApi(25) fun updateShortcuts(shortcutIds: Set<String>) {

        val shortcutManager = ctx.getSystemService(Context.SHORTCUT_SERVICE) as ShortcutManager

        shortcutManager.dynamicShortcuts = shortcutIds.mapNotNull { Item.buildShortcut(ctx, it) }
    }
}