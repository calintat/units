package com.calintat.units.recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.calintat.units.R
import com.calintat.units.utils.Converter
import org.jetbrains.anko.layoutInflater

class Adapter(private val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    internal var units = emptyArray<Converter.Unit>()

    internal var input = Double.NaN // in base unit

        set(value) { field = value; notifyDataSetChanged() }

    internal lateinit var onClick: (Int) -> Unit

    internal lateinit var onLongClick: (String) -> Unit

    override fun getItemCount() = units.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val unit = units[position]

        val output = unit.baseToSelf(input)

        holder.num.text = "${output.toFloat()}"

        holder.str.setText(unit.name)

        holder.sym.setText(unit.symbol)

        holder.itemView.setOnClickListener { onClick(position) }

        holder.itemView.setOnLongClickListener { onLongClick(output.toString()); true }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = with(context) {

        ViewHolder(layoutInflater.inflate(R.layout.recycler_list_item, parent, false))
    }
}