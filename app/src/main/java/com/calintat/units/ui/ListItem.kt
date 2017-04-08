package com.calintat.units.ui

import android.os.Build
import android.text.TextUtils
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.calintat.units.R
import org.jetbrains.anko.*

object ListItem : AnkoComponent<ViewGroup> {

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

    internal var TextView.textAppearance: Int

        get() = throw PropertyWithoutGetterException("textAppearance")

        set(value) {

            val sdk = Build.VERSION.SDK_INT

            if (sdk >= 23) setTextAppearance(value) else setTextAppearance(context, value)
        }
}