package com.calintat.units.api

import android.content.Context
import com.calintat.alps.getFloat

/**
 * Implementation of [MeasurementUnit] for currencies.
 *
 * The conversion coefficient is retrieved from preferences using [key].
 */
data class MeasurementUnitImpl2(override val label: Int, override val shortLabel: Int,

                                val key: String, val defValue: Float) : MeasurementUnit {

    /**
     * Convert [x] from this unit to the base unit.
     */
    override fun selfToBase(context: Context, x: Double) = x / context.getFloat(key, defValue)

    /**
     * Convert [y] from the base unit to this unit.
     */
    override fun baseToSelf(context: Context, y: Double) = y * context.getFloat(key, defValue)
}
