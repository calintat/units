package com.calintat.units.recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.calintat.units.R
import com.calintat.units.utils.Converter

class Adapter(val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    var units: Array<Converter.Unit> = emptyArray()

    var input: Double = Double.NaN // in base unit

        set(value) {

            field = value

            notifyDataSetChanged()
        }

    lateinit var onClick: (Int) -> Unit

    lateinit var onLongClick: (String) -> Unit

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val unit = units[position]

        val output = unit.baseToSelf(input)

        holder.num.text = "${output.toFloat()}"

        holder.str.setText(unit.name)

        holder.sym.setText(unit.symbol)

        holder.itemView.setOnClickListener { onClick(position) }

        holder.itemView.setOnLongClickListener { onLongClick(output.toString()); true }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(context)

        val layoutResource = R.layout.converter_list_item

        return ViewHolder(layoutInflater.inflate(layoutResource, parent, false))
    }

    override fun getItemCount(): Int {

        return units.size
    }
}
