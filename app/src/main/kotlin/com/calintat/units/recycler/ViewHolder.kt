package com.calintat.units.recycler

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

import com.calintat.units.R

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val num = itemView.findViewById(R.id.list_item_num) as TextView

    val str = itemView.findViewById(R.id.list_item_str) as TextView

    val sym = itemView.findViewById(R.id.list_item_sym) as TextView
}
