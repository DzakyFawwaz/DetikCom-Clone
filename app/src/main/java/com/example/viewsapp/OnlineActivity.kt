package com.example.viewsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.viewsapp.databinding.ActivityOnlineBinding
import com.example.viewsapp.detail.DetailActivity
import com.example.viewsapp.remote.RetrofitInterface
import com.example.viewsapp.remote.RetrofitService
import com.example.viewsapp.remote.pojo.ArticlesItem
import com.example.viewsapp.rv.ItemListNewsAdapter
import com.example.viewsapp.rv.ItemListNewsViewHolder
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.coroutines.launch

class OnlineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnlineBinding

    //deklarasikan adapter yang ada di recycler view
    private lateinit var adapterRV: ItemListNewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val inflater = layoutInflater
        binding = ActivityOnlineBinding.inflate(inflater)

        setContentView(binding.root)

        setSupportActionBar(binding.homeToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        Glide.with(this).load(R.drawable.logo).into(binding.imgToolbar)

        adapterRV = ItemListNewsAdapter()

        binding.rvNews.setHasFixedSize(true)
        binding.rvNews.layoutManager = LinearLayoutManager(this)
        binding.rvNews.adapter = adapterRV

            val retrofitService = RetrofitService.buildService(RetrofitInterface::class.java)
            lifecycleScope.launch {
                val request = retrofitService.topheadlines("id")
                if (request.isSuccessful) {
                    Toast.makeText(
                        this@OnlineActivity,
                        request.body()?.totalResults.toString(),
                        Toast.LENGTH_SHORT
                    ).show()

                    request.body()?.articles?.let { data ->
                        val dataResult = arrayListOf<ArticlesItem>()
                        data.forEach { item ->
                            item?.let {
                                dataResult.add(it)
                            }
                        }
                        adapterRV.addData(dataResult)

                        val beritaPertama = data[0]
                        binding.itemHeadline.run {
                            textTitle.text = beritaPertama?.title
                            textDate.text = beritaPertama?.publishedAt
                            beritaPertama?.let {
                                Glide.with(this@OnlineActivity)
                                    .load(it.urlToImage)
                                    .into(imgHeadline)

                            }

                        }

                    }
                } else {
                    Log.e("Online Activity", request.message())
                }
            }

        }
    }
