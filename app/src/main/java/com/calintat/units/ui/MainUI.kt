package com.calintat.units.ui

import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.calintat.units.R
import com.calintat.units.activities.MainActivity
import com.calintat.units.ui.ListItem.textAppearance
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.design._CoordinatorLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.recyclerview.v7.recyclerView

object MainUI : AnkoComponent<MainActivity> {

    internal lateinit var drawerLayout: DrawerLayout

    internal lateinit var toolbar: Toolbar

    internal lateinit var editText: EditText

    internal lateinit var textView1: TextView

    internal lateinit var textView2: TextView

    internal lateinit var recyclerView: RecyclerView

    internal lateinit var navigationView: NavigationView

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

        include<DrawerLayout>(R.layout.drawer_layout) {

            drawerLayout = this

            coordinatorLayout { createToolbar(); createConverterLayout() }

            navigationView = navigationView {

                layoutParams = DrawerLayout.LayoutParams(wrapContent, matchParent, Gravity.START)
            }
        }
    }

    private fun _CoordinatorLayout.createToolbar() {

        toolbar = toolbar().lparams(width = matchParent, height = dimen(R.dimen.app_bar_height))
    }

    private fun _CoordinatorLayout.createConverterLayout() {

        cardView {

            cardElevation = dip(4).toFloat()

            verticalLayout { createInputField(); createDivider(); createConverterList() }

        }.lparams(width = matchParent, height = matchParent) {

            topMargin = dimen(R.dimen.card_view_margin_top)

            bottomMargin = dimen(R.dimen.card_view_margin_bottom)

            horizontalMargin = dimen(R.dimen.card_view_margin_horizontal)
        }
    }

    private fun _LinearLayout.createDivider() {

        view {

            backgroundResource = android.R.color.darker_gray

        }.lparams(width = matchParent, height = dip(1))
    }

    private fun _LinearLayout.createInputField() {

        linearLayout {

            gravity = Gravity.CENTER_VERTICAL

            minimumHeight = dip(72)

            orientation = LinearLayout.HORIZONTAL

            editText = editText {

                backgroundResource = android.R.color.transparent

                hintResource = R.string.msg_input

                inputType = 12290 // i.e. signed decimal numbers

                padding = dip(16)

                textAppearance = R.style.TextAppearance_AppCompat_Title

            }.lparams(width = 0, height = matchParent, weight = 1f)

            verticalLayout {

                gravity = Gravity.END

                padding = dip(16)

                textView1 = textView {

                    textAppearance = R.style.TextAppearance_AppCompat_Body2

                }.lparams(width = wrapContent, height = dip(0), weight = 1f)

                textView2 = textView {

                    textAppearance = R.style.TextAppearance_AppCompat_Body1

                }.lparams(width = wrapContent, height = dip(0), weight = 1f)

            }.lparams(width = wrapContent, height = matchParent)

        }.lparams(width = matchParent, height = wrapContent)
    }

    private fun _LinearLayout.createConverterList() {

        recyclerView = recyclerView().lparams(width = matchParent, height = matchParent)
    }
}