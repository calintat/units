package com.calintat.units.ui

import com.calintat.units.R
import com.calintat.units.activities.SettingsActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.appcompat.v7.navigationIconResource
import org.jetbrains.anko.appcompat.v7.titleResource
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.verticalLayout

class SettingsUI : AnkoComponent<SettingsActivity> {

    override fun createView(ui: AnkoContext<SettingsActivity>) = with(ui) {

        verticalLayout {

            appBarLayout {

                toolbar {

                    navigationIconResource = R.drawable.ic_action_back

                    setNavigationOnClickListener { owner.finish() }

                    titleResource = R.string.navigation_settings
                }
            }

            frameLayout { id = R.id.container }
        }
    }
}