package com.calintat.units.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.calintat.units.R
import com.github.calintat.Alps.populateWithPreferences
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        toolbar.setTitle(R.string.navigation_settings)

        toolbar.setNavigationIcon(R.drawable.ic_action_back)

        toolbar.setNavigationOnClickListener { finish() }

        populateWithPreferences(R.id.fragment, R.xml.preferences)
    }
}