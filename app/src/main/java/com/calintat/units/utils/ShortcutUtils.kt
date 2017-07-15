package com.calintat.units.utils

import android.annotation.TargetApi
import android.content.Context
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.support.annotation.IdRes
import com.calintat.units.R
import com.calintat.units.activities.MainActivity
import org.jetbrains.anko.intentFor

@TargetApi(25)
object ShortcutUtils {

    /**
     * Retrieve navigation identifier from a shortcut identifier.
     */
    internal fun retrieveId(shortcutId: String): Int? {

        return Converter.shortcuts.firstOrNull { it.second == shortcutId }?.first
    }

    /**
     * Retrieve shortcut identifier from a navigation identifier.
     */
    internal fun retrieveShortcutId(id: Int): String? {

        return Converter.shortcuts.firstOrNull { it.first == id }?.second
    }

    /**
     * Return the set of identifiers of the dynamic shortcuts from the caller app.
     */
    internal fun getShortcuts(context: Context) = with(context) {

        val shortcutManager = getSystemService(Context.SHORTCUT_SERVICE) as ShortcutManager

        shortcutManager.dynamicShortcuts.mapNotNull { retrieveId(it.id) }.toSet()
    }

    /**
     * Build and set dynamic shortcuts from a set of identifiers.
     */
    internal fun setShortcuts(context: Context, ids: Set<Int>) = with(context) {

        val shortcutManager = getSystemService(Context.SHORTCUT_SERVICE) as ShortcutManager

        shortcutManager.dynamicShortcuts = ids.mapNotNull { buildShortcut(this, it) }
    }

    /**
     * Build a shortcut from an identifier inside the given context.
     */
    internal fun buildShortcut(context: Context, id: Int) = retrieveShortcutId(id)?.let {

        val item = Converter.get(id)

        ShortcutInfo.Builder(context, it)

                .setShortLabel(context.resources.getString(item.shortLabel))

                .setIcon(Icon.createWithResource(context, item.shortcutIcon))

                .setIntent(context.intentFor<MainActivity>().setAction(it))

                .setRank(item.rank)

                .build()
    }
}