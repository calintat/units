package com.calintat.units.ui

import android.text.TextUtils
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import com.calintat.units.R
import com.calintat.units.utils.AnkoProperties.textAppearance
import org.jetbrains.anko.*

class ListItem() : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {

        linearLayout {

            lparams(width = matchParent, height = wrapContent)

            backgroundResource = attr(R.attr.selectableItemBackground)

            gravity = Gravity.CENTER_VERTICAL

            minimumHeight = dip(72)

            orientation = LinearLayout.HORIZONTAL

            textView {

                id = R.id.list_item_num

                ellipsize = TextUtils.TruncateAt.MARQUEE

                marqueeRepeatLimit = -1 // repeat indefinitely

                maxLines = 1

                padding = dip(16)

                textAppearance = R.style.TextAppearance_AppCompat_Subhead

            }.lparams(width = 0, height = wrapContent, weight = 1f)

            verticalLayout {

                gravity = Gravity.END

                padding = dip(16)

                textView {

                    id = R.id.list_item_str

                    maxLines = 1

                    textAppearance = R.style.TextAppearance_AppCompat_Body2

                }.lparams(width = wrapContent, height = wrapContent)

                textView {

                    id = R.id.list_item_sym

                    maxLines = 1

                    textAppearance = R.style.TextAppearance_AppCompat_Body1

                }.lparams(width = wrapContent, height = wrapContent)
            }
        }
    }

    internal fun AnkoContext<*>.attr(value: Int): Int {

        return TypedValue().let { ctx.theme.resolveAttribute(value, it, true); it.resourceId }
    }
}