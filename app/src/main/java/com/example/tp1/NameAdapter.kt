package com.example.tp1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NameAdapter(private val names: List<String>) :
    RecyclerView.Adapter<NameAdapter.NameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_name, parent, false)
        return NameViewHolder(view)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        val element = names[position]
        holder.txtName.text = element
        holder.itemView.setOnClickListener {
            // Invoking itemClickListener and passing it the position and name
            itemClickListener?.invoke(position, element)
        }
    }

    override fun getItemCount(): Int {
        return names.size
    }

    //first step
    var itemClickListener: ((position: Int, name: String) -> Unit)? = null


    class NameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName = itemView.findViewById(R.id.txtName) as TextView
    }
}
