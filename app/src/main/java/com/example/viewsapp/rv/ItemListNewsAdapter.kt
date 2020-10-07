package com.example.viewsapp.rv

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.viewsapp.databinding.ItemListNewsBinding
import com.example.viewsapp.detail.DetailActivity
import com.example.viewsapp.remote.pojo.ArticlesItem

class ItemListNewsAdapter : RecyclerView.Adapter<ItemListNewsViewHolder>() {
    private val listNews = ArrayList<ArticlesItem>()

    fun addData(data: List<ArticlesItem>) {
        listNews.clear()
        listNews.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListNewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListNewsBinding.inflate(layoutInflater, parent, false)
        return ItemListNewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listNews.size
    }

    override fun onBindViewHolder(holder: ItemListNewsViewHolder, position: Int) {
        val data = listNews[position]
        holder.bind(data)

        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.itemView.context, data.title, Toast.LENGTH_SHORT).show()
            val intent = Intent(it.context, DetailActivity::class.java).apply {
                putExtra("BERITA_ITEM", data)
            }
            it.context.startActivity(intent)


        }
    }
}
