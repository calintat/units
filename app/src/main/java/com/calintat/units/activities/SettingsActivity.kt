package com.calintat.units.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.calintat.alps.*
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

        populateWithPreferences(containerViewId = R.id.container) {

            switchPreference("pref_advanced") {

                defaultValue = true

                titleResource = R.string.pref_advanced
            }

            switchPreference("pref_dark_theme") {

                defaultValue = false

                titleResource = R.string.pref_dark_theme
            }

            preferenceCategory("pref_about") {

                titleResource = R.string.pref_about

                preference {

                    titleResource = R.string.pref_version

                    summaryResource = R.string.app_version

                    setUrl("market://details?id=com.calintat.units")
                }

                preference {

                    titleResource = R.string.pref_developer

                    summaryResource = R.string.app_developer

                    setUrl("https://play.google.com/store/apps/dev?id=5526451977947367946")
                }
            }
        }
    }
}