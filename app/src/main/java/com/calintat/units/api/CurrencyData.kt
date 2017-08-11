package com.calintat.units.api

import android.content.Context
import com.calintat.alps.putFloat
import com.calintat.alps.putString

data class CurrencyData(val date: String, val rates: Map<String, Float>) {

    fun persist(context: Context) {

        context.putString("pref_currency_date", date)

        for ((key, value) in rates) context.putFloat("pref_currency_$key", value)
    }
}