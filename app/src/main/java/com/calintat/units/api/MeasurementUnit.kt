package com.calintat.units.api

import android.content.Context

interface MeasurementUnit {

    /**
     * String resource for this unit's full name.
     */
    val label: Int

    /**
     * String resource for this unit's symbol or short name.
     */
    val shortLabel: Int

    /**
     * Converts [x] from this unit to the corresponding base unit.
     */
    fun selfToBase(context: Context, x: Double): Double

    /**
     * Converts [y] from the corresponding base unit to this unit.
     */
    fun baseToSelf(context: Context, y: Double): Double
}