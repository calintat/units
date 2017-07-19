package com.calintat.units.utils

import android.os.Build
import android.widget.TextView

object AnkoUtils {

    @Suppress("DEPRECATION")
    internal var TextView.textAppearance: Int

        get() = throw Exception("textAppearance has no getter")

        set(value) = if (Build.VERSION.SDK_INT >= 23) setTextAppearance(value) else setTextAppearance(context, value)
}