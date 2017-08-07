package com.calintat.units.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.calintat.alps.populateWithPreferences
import com.calintat.units.R
import com.calintat.units.ui.SettingsUI
import com.calintat.units.ui.SettingsUI.toolbar
import org.jetbrains.anko.setContentView

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        SettingsUI.setContentView(this)

        toolbar.setTitle(R.string.navigation_settings)

        toolbar.setNavigationIcon(R.drawable.ic_action_back)

        toolbar.setNavigationOnClickListener { finish() }

        populateWithPreferences(R.id.container, R.xml.preferences)
    }
}