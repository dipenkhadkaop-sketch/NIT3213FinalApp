package com.example.nit3213finalapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nit3213finalapp.network.Entity

class EntityAdapter(
    private val items: List<Entity>,
    private val onItemClick: (Entity) -> Unit
) : RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    inner class EntityViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_entity, parent, false)
    ) {
        private val tvProperty1: TextView = itemView.findViewById(R.id.tvProperty1)
        private val tvProperty2: TextView = itemView.findViewById(R.id.tvProperty2)

        fun bind(entity: Entity) {
            tvProperty1.text = entity.property1
            tvProperty2.text = entity.property2

            itemView.setOnClickListener {
                onItemClick(entity)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        return EntityViewHolder(parent)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}