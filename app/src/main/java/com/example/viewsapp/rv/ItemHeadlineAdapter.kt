package com.example.viewsapp.rv

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewsapp.data.News
import com.example.viewsapp.databinding.ItemHeadlineBinding

/**
 * Created by Imam Fahrur Rofi on 17/07/2020.
 */
class ItemHeadlineAdapter : RecyclerView.Adapter<ItemHeadlineVH>() {
    private val dataBerita = ArrayList<News>()

    fun addData(data : List<News>) {
        dataBerita.clear()
        dataBerita.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHeadlineVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHeadlineBinding.inflate(inflater, parent, false)
        return ItemHeadlineVH(binding)
    }

    override fun getItemCount(): Int {
        return dataBerita.size
    }

    override fun onBindViewHolder(holder: ItemHeadlineVH, position: Int) {
        val data = dataBerita[position]
        holder.bind(data)
    }
}