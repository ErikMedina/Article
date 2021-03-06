package com.erikmedina.article.presentation.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.erikmedina.article.R
import com.erikmedina.article.data.local.model.Item

class ItemAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(item: Item)
    }

    private var itemViews = emptyList<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = itemViews.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = itemViews[position].title
        holder.subtitle.text = itemViews[position].subtitle
        holder.date.text = itemViews[position].date
        holder.bind(itemViews[position], listener)
    }

    fun setItemViews(items: List<Item>) {
        this.itemViews = items
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView = itemView.findViewById(R.id.title)
        var subtitle: TextView = itemView.findViewById(R.id.tvSubtitle)
        var date: TextView = itemView.findViewById(R.id.tvDate)

        fun bind(item: Item, listener: OnItemClickListener) {
            itemView.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }
}
