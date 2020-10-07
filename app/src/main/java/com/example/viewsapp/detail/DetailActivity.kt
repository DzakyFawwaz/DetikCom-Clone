package com.example.viewsapp.detail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.bumptech.glide.Glide
import com.example.viewsapp.R
import com.example.viewsapp.databinding.ActivityDetailBinding
import com.example.viewsapp.remote.pojo.ArticlesItem

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding
    private lateinit var dataIntent: ArticlesItem


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = layoutInflater
        binding = ActivityDetailBinding.inflate(inflater)

        setContentView(binding.root)
        // Set Action Bar
        setSupportActionBar(binding.homeToolbar)
        // Tampilkan tombol back pada ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Dapatkan Data dari intent
//        dataIntent = intent.getParcelableExtra("BERITA_ITEM") as ArticlesItem
        dataIntent = intent.getParcelableExtra("BERITA_ITEM") as ArticlesItem
        // Set Judul pada ActionBar
        supportActionBar?.setDisplayShowTitleEnabled(false)
        Glide.with(this).load(R.drawable.logo).into(binding.imgToolbar)

        binding.webview.run {
            // Isi webview client
            webChromeClient = MyWebChromeClient()
            webViewClient = MyWebViewClient()
            // aktifkan javascript pada webview client
            @SuppressLint("SetJavaScriptEnabled")
            settings.javaScriptEnabled = true
            // load url
            loadUrl(dataIntent.url)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    // buat WebChromeClient
    internal class MyWebChromeClient : WebChromeClient()

    // buat WebViewClient
    internal class MyWebViewClient : WebViewClient()
}

