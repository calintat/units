package com.calintat.units.ui

import android.graphics.Color
import android.view.View
import android.widget.Toolbar
import com.calintat.units.activities.SettingsActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout

object SettingsUI : AnkoComponent<SettingsActivity> {

    internal val FRAGMENT by lazy { View.generateViewId() }

    internal lateinit var toolbar: Toolbar

    override fun createView(ui: AnkoContext<SettingsActivity>) = with(ui) {

        coordinatorLayout {

            fitsSystemWindows = true

            verticalLayout {

                appBarLayout {

                    toolbar = toolbar {

                        setTitleTextColor(Color.WHITE)
                    }
                }

                frameLayout {

                    id = FRAGMENT
                }
            }
        }
    }
}