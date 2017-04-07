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

        return shortcuts.firstOrNull { it.shortcutId == shortcutId }?.id
    }

    /**
     * Retrieve shortcut identifier from a navigation identifier.
     */
    internal fun retrieveShortcutId(id: Int): String? {

        return shortcuts.firstOrNull { it.id == id }?.shortcutId
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

    /**
     * Custom pair structure for the entries of the mapping below.
     */
    private data class Shortcut(@IdRes val id: Int, val shortcutId: String)

    /**
     * Invertible mapping between navigation identifiers and shortcut identifiers.
     */
    private val shortcuts = hashSetOf(

            Shortcut(R.id.navigation_length, "com.calintat.units.SHORTCUT_LENGTH"),

            Shortcut(R.id.navigation_area, "com.calintat.units.SHORTCUT_AREA"),

            Shortcut(R.id.navigation_volume, "com.calintat.units.SHORTCUT_VOLUME"),

            Shortcut(R.id.navigation_mass, "com.calintat.units.SHORTCUT_MASS"),

            Shortcut(R.id.navigation_time, "com.calintat.units.SHORTCUT_TIME"),

            Shortcut(R.id.navigation_speed, "com.calintat.units.SHORTCUT_SPEED"),

            Shortcut(R.id.navigation_temperature, "com.calintat.units.SHORTCUT_TEMPERATURE"),

            Shortcut(R.id.navigation_currency, "com.calintat.units.SHORTCUT_CURRENCY"),

            Shortcut(R.id.navigation_fuel, "com.calintat.units.SHORTCUT_FUEL"),

            Shortcut(R.id.navigation_storage, "com.calintat.units.SHORTCUT_STORAGE"),

            Shortcut(R.id.navigation_bitrate, "com.calintat.units.SHORTCUT_BITRATE"),

            Shortcut(R.id.navigation_angle, "com.calintat.units.SHORTCUT_ANGLE"),

            Shortcut(R.id.navigation_density, "com.calintat.units.SHORTCUT_DENSITY"),

            Shortcut(R.id.navigation_frequency, "com.calintat.units.SHORTCUT_FREQUENCY"),

            Shortcut(R.id.navigation_flow, "com.calintat.units.SHORTCUT_FLOW"),

            Shortcut(R.id.navigation_acceleration, "com.calintat.units.SHORTCUT_ACCELERATION"),

            Shortcut(R.id.navigation_force, "com.calintat.units.SHORTCUT_FORCE"),

            Shortcut(R.id.navigation_pressure, "com.calintat.units.SHORTCUT_PRESSURE"),

            Shortcut(R.id.navigation_torque, "com.calintat.units.SHORTCUT_TORQUE"),

            Shortcut(R.id.navigation_energy, "com.calintat.units.SHORTCUT_ENERGY"),

            Shortcut(R.id.navigation_power, "com.calintat.units.SHORTCUT_POWER"),

            Shortcut(R.id.navigation_current, "com.calintat.units.SHORTCUT_CURRENT"),

            Shortcut(R.id.navigation_charge, "com.calintat.units.SHORTCUT_CHARGE"),

            Shortcut(R.id.navigation_voltage, "com.calintat.units.SHORTCUT_VOLTAGE"),

            Shortcut(R.id.navigation_luminance, "com.calintat.units.SHORTCUT_LUMINANCE"),

            Shortcut(R.id.navigation_illuminance, "com.calintat.units.SHORTCUT_ILLUMINANCE"),

            Shortcut(R.id.navigation_radiation, "com.calintat.units.SHORTCUT_RADIATION"),

            Shortcut(R.id.navigation_radioactivity, "com.calintat.units.SHORTCUT_RADIOACTIVITY")
    )
}