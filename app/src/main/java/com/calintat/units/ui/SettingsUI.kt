package com.calintat.units.ui

import android.widget.Toolbar
import com.calintat.units.R
import com.calintat.units.activities.SettingsActivity
import com.github.calintat.Colorful
import org.jetbrains.anko.*
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout

object SettingsUI : AnkoComponent<SettingsActivity> {

    internal lateinit var toolbar: Toolbar

    override fun createView(ui: AnkoContext<SettingsActivity>) = with(ui) {

        coordinatorLayout {

            fitsSystemWindows = true

            verticalLayout {

                appBarLayout {

                    toolbar = toolbar {

                        setTitleTextColor(Colorful.white)
                    }
                }

                frameLayout {

                    id = R.id.fragment
                }
            }
        }
    }
}