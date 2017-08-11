package com.calintat.units.utils

import android.os.Build
import android.widget.TextView
import org.jetbrains.anko.internals.AnkoInternals

object AnkoProperties {

    var TextView.textAppearance: Int

        @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()

        @Suppress("DEPRECATION") set(value) = if (Build.VERSION.SDK_INT >= 23) setTextAppearance(value) else setTextAppearance(context, value)
}