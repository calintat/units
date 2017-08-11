package com.calintat.units.api

import android.content.Context

/**
 * Implementation of [MeasurementUnit] for units such as metres.
 *
 * To convert from this unit to the base unit, apply f(x) = [a] x^[n] + [b].
 */
data class MeasurementUnitImpl1(override val label: Int, override val shortLabel: Int,

                                val a: Double, val b: Double, val n: Double) : MeasurementUnit {

    /**
     * Converts [x] from this unit to the corresponding base unit.
     */
    override fun selfToBase(context: Context, x: Double) = a * Math.pow(x, n) + b

    /**
     * Converts [y] from the corresponding base unit to this unit.
     */
    override fun baseToSelf(context: Context, y: Double) = Math.pow((y - b) / a, 1 / n)
}