package com.calintat.units.recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.calintat.units.api.MeasurementUnit
import com.calintat.units.ui.ListItem
import org.jetbrains.anko.AnkoContext

class Adapter(private val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    internal var units = emptyList<MeasurementUnit>()

    internal var input = Double.NaN // in base unit

        set(value) { field = value; notifyDataSetChanged() }

    internal lateinit var onClick: (Int) -> Unit

    internal lateinit var onLongClick: (String) -> Unit

    override fun getItemCount() = units.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val unit = units[position]

        val output = unit.baseToSelf(context, input)

        holder.num.text = "${output.toFloat()}"

        holder.str.setText(unit.label)

        holder.sym.setText(unit.shortLabel)

        holder.itemView.setOnClickListener { onClick(position) }

        holder.itemView.setOnLongClickListener { onLongClick(output.toString()); true }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ListItem.createView(AnkoContext.create(parent.context, parent)))
    }
}