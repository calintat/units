package com.calintat.units.recycler

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.calintat.units.R
import org.jetbrains.anko.find

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    internal val num = itemView.find<TextView>(R.id.list_item_num)

    internal val str = itemView.find<TextView>(R.id.list_item_str)

    internal val sym = itemView.find<TextView>(R.id.list_item_sym)
}