package com.example.viewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.viewsapp.data.News
import com.example.viewsapp.data.NewsModel
import com.example.viewsapp.databinding.ActivityNewsBinding
import com.example.viewsapp.rv.ItemHeadlineAdapter
import com.example.viewsapp.rv.ItemListNewsAdapter

class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding
    private lateinit var adapter: ItemListNewsAdapter
    private lateinit var adapterHorizontal : ItemHeadlineAdapter
    private lateinit var data: List<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // deklarasi binding
        val inflater = layoutInflater
        binding = ActivityNewsBinding.inflate(inflater)

        setContentView(binding.root)
        setSupportActionBar(binding.homeToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        Glide.with(this).load(R.drawable.logo).into(binding.imgToolbar)

        // Data
        data = NewsModel.newslist // data berita
        val beritaHeadline = data[0]  // data pertama atau index 0
        val beritaLainnya = data.drop(1) // menghilangkan satu data di awal

        // Recyclerview vertical
        adapter = ItemListNewsAdapter()
        binding.rvNews.setHasFixedSize(true)
        binding.rvNews.layoutManager = LinearLayoutManager(this)
        binding.rvNews.adapter = adapter
        // menambahkan data pada adapter recycler
        // adapter.addData(beritaLainnya)

        // Recyclerview Horizontal
        adapterHorizontal = ItemHeadlineAdapter()
        binding.rvHorizontal.run{
            layoutManager = LinearLayoutManager(this@NewsActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = adapterHorizontal
        }

        // menambahkan data pada adapter recycler
        adapterHorizontal.addData(beritaLainnya)

        // Mengisi data pada i  nclude id item_headline
        binding.itemHeadline.run {
            textTitle.text = beritaHeadline.title
            textDate.text = beritaHeadline.desc
            Glide.with(this@NewsActivity).load(beritaHeadline.photo).into(imgHeadline)
        }
    }
}
