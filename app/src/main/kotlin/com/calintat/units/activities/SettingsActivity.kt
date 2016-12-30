package com.calintat.units.activities

import android.os.Bundle
import android.preference.PreferenceFragment
import android.support.v7.app.AppCompatActivity
import com.calintat.units.R
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        toolbar.setTitle(R.string.navigation_settings)

        toolbar.setNavigationIcon(R.drawable.ic_action_back)

        toolbar.setNavigationOnClickListener { finish() }

        fragmentManager.beginTransaction().replace(R.id.fragment, SettingsFragment()).commit()
    }

    class SettingsFragment : PreferenceFragment() {

        override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)

            addPreferencesFromResource(R.xml.prefs)
        }
    }
}
