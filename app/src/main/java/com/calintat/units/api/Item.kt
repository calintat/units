package com.calintat.units.api

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.graphics.drawable.Icon
import com.calintat.units.R
import com.calintat.units.activities.MainActivity
import org.jetbrains.anko.intentFor

enum class Item(val id: Int, val label: Int, val color: Int, val colorDark: Int, val shortcutId: String, val shortcutIcon: Int) {

    LENGTH(
        id = R.id.navigation_length,
        label = R.string.navigation_length,
        color = R.color.blue_500,
        colorDark = R.color.blue_700,
        shortcutId = "shortcut_length",
        shortcutIcon = R.drawable.ic_shortcut_length
    ),

    AREA(
        id = R.id.navigation_area,
        label = R.string.navigation_area,
        color = R.color.green_500,
        colorDark = R.color.green_700,
        shortcutId = "shortcut_area",
        shortcutIcon = R.drawable.ic_shortcut_area
    ),

    VOLUME(
        id = R.id.navigation_volume,
        label = R.string.navigation_volume,
        color = R.color.light_blue_500,
        colorDark = R.color.light_blue_700,
        shortcutId = "shortcut_volume",
        shortcutIcon = R.drawable.ic_shortcut_volume
    ),

    MASS(
        id = R.id.navigation_mass,
        label = R.string.navigation_mass,
        color = R.color.red_500,
        colorDark = R.color.red_700,
        shortcutId = "shortcut_mass",
        shortcutIcon = R.drawable.ic_shortcut_mass
    ),

    TIME(
        id = R.id.navigation_time,
        label = R.string.navigation_time,
        color = R.color.amber_500,
        colorDark = R.color.amber_700,
        shortcutId = "shortcut_time",
        shortcutIcon = R.drawable.ic_shortcut_time
    ),

    SPEED(
        id = R.id.navigation_speed,
        label = R.string.navigation_speed,
        color = R.color.deep_orange_500,
        colorDark = R.color.deep_orange_700,
        shortcutId = "shortcut_speed",
        shortcutIcon = R.drawable.ic_shortcut_speed
    ),

    TEMPERATURE(
        id = R.id.navigation_temperature,
        label = R.string.navigation_temperature,
        color = R.color.cyan_500,
        colorDark = R.color.cyan_700,
        shortcutId = "shortcut_temperature",
        shortcutIcon = R.drawable.ic_shortcut_temperature
    ),

    CURRENCY(
        id = R.id.navigation_currency,
        label = R.string.navigation_currency,
        color = R.color.green_500,
        colorDark = R.color.green_700,
        shortcutId = "shortcut_currency",
        shortcutIcon = R.drawable.ic_shortcut_currency
    ),

    FUEL(
        id = R.id.navigation_fuel,
        label = R.string.navigation_fuel,
        color = R.color.lime_500,
        colorDark = R.color.lime_700,
        shortcutId = "shortcut_fuel",
        shortcutIcon = R.drawable.ic_shortcut_fuel
    ),

    STORAGE(
        id = R.id.navigation_storage,
        label = R.string.navigation_storage,
        color = R.color.teal_500,
        colorDark = R.color.teal_700,
        shortcutId = "shortcut_storage",
        shortcutIcon = R.drawable.ic_shortcut_storage
    ),

    BITRATE(
        id = R.id.navigation_bitrate,
        label = R.string.navigation_bitrate,
        color = R.color.amber_500,
        colorDark = R.color.amber_700,
        shortcutId = "shortcut_bitrate",
        shortcutIcon = R.drawable.ic_shortcut_bitrate
    ),

    ANGLE(
        id = R.id.navigation_angle,
        label = R.string.navigation_angle,
        color = R.color.red_500,
        colorDark = R.color.red_700,
        shortcutId = "shortcut_angle",
        shortcutIcon = R.drawable.ic_shortcut_angle
    ),

    DENSITY(
        id = R.id.navigation_density,
        label = R.string.navigation_density,
        color = R.color.blue_500,
        colorDark = R.color.blue_700,
        shortcutId = "shortcut_density",
        shortcutIcon = R.drawable.ic_shortcut_density
    ),

    FREQUENCY(
        id = R.id.navigation_frequency,
        label = R.string.navigation_frequency,
        color = R.color.green_500,
        colorDark = R.color.green_700,
        shortcutId = "shortcut_frequency",
        shortcutIcon = R.drawable.ic_shortcut_frequency
    ),

    FLOW(
        id = R.id.navigation_flow,
        label = R.string.navigation_flow,
        color = R.color.light_blue_500,
        colorDark = R.color.light_blue_700,
        shortcutId = "shortcut_flow",
        shortcutIcon = R.drawable.ic_shortcut_flow
    ),

    ACCELERATION(
        id = R.id.navigation_acceleration,
        label = R.string.navigation_acceleration,
        color = R.color.orange_500,
        colorDark = R.color.orange_700,
        shortcutId = "shortcut_acceleration",
        shortcutIcon = R.drawable.ic_shortcut_acceleration
    ),

    FORCE(
        id = R.id.navigation_force,
        label = R.string.navigation_force,
        color = R.color.teal_500,
        colorDark = R.color.teal_700,
        shortcutId = "shortcut_force",
        shortcutIcon = R.drawable.ic_shortcut_force
    ),

    PRESSURE(
        id = R.id.navigation_pressure,
        label = R.string.navigation_pressure,
        color = R.color.cyan_500,
        colorDark = R.color.cyan_700,
        shortcutId = "shortcut_pressure",
        shortcutIcon = R.drawable.ic_shortcut_pressure
    ),

    TORQUE(
        id = R.id.navigation_torque,
        label = R.string.navigation_torque,
        color = R.color.yellow_500,
        colorDark = R.color.yellow_700,
        shortcutId = "shortcut_torque",
        shortcutIcon = R.drawable.ic_shortcut_torque
    ),

    ENERGY(
        id = R.id.navigation_energy,
        label = R.string.navigation_energy,
        color = R.color.green_500,
        colorDark = R.color.green_700,
        shortcutId = "shortcut_energy",
        shortcutIcon = R.drawable.ic_shortcut_energy
    ),

    POWER(
        id = R.id.navigation_power,
        label = R.string.navigation_power,
        color = R.color.red_500,
        colorDark = R.color.red_700,
        shortcutId = "shortcut_power",
        shortcutIcon = R.drawable.ic_shortcut_power
    ),

    CURRENT(
        id = R.id.navigation_current,
        label = R.string.navigation_current,
        color = R.color.yellow_500,
        colorDark = R.color.yellow_700,
        shortcutId = "shortcut_current",
        shortcutIcon = R.drawable.ic_shortcut_current
    ),

    CHARGE(
        id = R.id.navigation_charge,
        label = R.string.navigation_charge,
        color = R.color.light_green_500,
        colorDark = R.color.light_green_700,
        shortcutId = "shortcut_charge",
        shortcutIcon = R.drawable.ic_shortcut_charge
    ),

    VOLTAGE(
        id = R.id.navigation_voltage,
        label = R.string.navigation_voltage,
        color = R.color.orange_500,
        colorDark = R.color.orange_700,
        shortcutId = "shortcut_voltage",
        shortcutIcon = R.drawable.ic_shortcut_voltage
    ),

    LUMINANCE(
        id = R.id.navigation_luminance,
        label = R.string.navigation_luminance,
        color = R.color.amber_500,
        colorDark = R.color.amber_700,
        shortcutId = "shortcut_luminance",
        shortcutIcon = R.drawable.ic_shortcut_luminance
    ),

    ILLUMINANCE(
        id = R.id.navigation_illuminance,
        label = R.string.navigation_illuminance,
        color = R.color.lime_500,
        colorDark = R.color.lime_700,
        shortcutId = "shortcut_illuminance",
        shortcutIcon = R.drawable.ic_shortcut_illuminance
    ),

    RADIATION(
        id = R.id.navigation_radiation,
        label = R.string.navigation_radiation,
        color = R.color.deep_orange_500,
        colorDark = R.color.deep_orange_700,
        shortcutId = "shortcut_radiation",
        shortcutIcon = R.drawable.ic_shortcut_radiation
    ),

    RADIOACTIVITY(
        id = R.id.navigation_radioactivity,
        label = R.string.navigation_radioactivity,
        color = R.color.yellow_500,
        colorDark = R.color.yellow_700,
        shortcutId = "shortcut_radioactivity",
        shortcutIcon = R.drawable.ic_shortcut_radioactivity
    );

    companion object Utils {

        private const val SHORTCUT_ID = "com.calintat.units.api.SHORTCUT_ID"

        fun isIdSafe(id: Int) = get(id) != null

        fun get(id: Int?) = values().firstOrNull { it.id == id }

        fun get(intent: Intent) = intent.getStringExtra(SHORTCUT_ID)?.let { get(it) }

        fun get(shortcutId: String?) = values().firstOrNull { it.shortcutId == shortcutId }

        @TargetApi(25) fun buildShortcut(ctx: Context, shortcutId: String): ShortcutInfo? {

            return get(shortcutId)?.run {

                val intent = ctx.intentFor<MainActivity>(SHORTCUT_ID to shortcutId)

                ShortcutInfo.Builder(ctx, shortcutId)
                        .setRank(ordinal)
                        .setShortLabel(ctx.getString(label))
                        .setIntent(intent.setAction(Intent.ACTION_MAIN))
                        .setIcon(Icon.createWithResource(ctx, shortcutIcon)).build()
            }
        }
    }
}