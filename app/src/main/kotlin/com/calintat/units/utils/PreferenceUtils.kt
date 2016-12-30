package com.calintat.units.utils

import android.content.Context
import android.preference.PreferenceManager

object PreferenceUtils {

    fun getBoolean(context: Context, key: String, defValue: Boolean = true): Boolean {

        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(key, defValue)
    }

    fun getInt(context: Context, key: String, defValue: Int): Int {

        return PreferenceManager.getDefaultSharedPreferences(context).getInt(key, defValue)
    }

    fun putInt(context: Context, key: String, value: Int) {

        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(key, value).apply()
    }
}
