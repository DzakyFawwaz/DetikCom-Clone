package com.example.viewsapp.rv

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viewsapp.data.News
import com.example.viewsapp.databinding.ItemHeadlineBinding

/**
 * Created by Imam Fahrur Rofi on 17/07/2020.
 */
class ItemHeadlineVH(binding: ItemHeadlineBinding) : RecyclerView.ViewHolder(binding.root) {
    private val image = binding.imgHeadline
    private val title = binding.textTitle
    private val date = binding.textDate
    private val root = binding.root

    fun bind(berita: News) {
        title.text = berita.title
        date.text = berita.desc
        Glide.with(root.context).load(berita.photo).into(image)
    }
}
