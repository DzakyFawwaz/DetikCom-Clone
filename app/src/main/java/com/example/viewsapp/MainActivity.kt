package com.example.viewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide
import com.example.viewsapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.homeToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        Glide.with(this).load(R.drawable.logo).into(binding.imgToolbar)

        binding.btnSend.setOnClickListener {
            val data =binding.editText.text
            saveData(data.toString())


        }
    }
    private fun saveData(data: String) {
        binding.textView.text = data
    }
    // kode untuk menampikan m enu pada activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_refresh) {
            Toast.makeText(this, "Menu Refresh ditekan", Toast.LENGTH_SHORT).show()
            binding.textView.text = "masukkan text"
            binding.editText.text.clear()
        }
        return super.onOptionsItemSelected(item)
    }
}
//menggunakan findviewbyid
//private lateinit var editText :EditText
//private lateinit var btnSend : Button
//private lateinit var txtView : TextView
//
//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(R.layout.activity_main)
//
//    editText = findViewById(R.id.editText)
//    btnSend = findViewById(R.id.button)
//    txtView = findViewById(R.id.textview)
//
//    btnSend.setOnClickListener {
//        val data = editText.text
//        saveData(data.toString())
//    }
//}
//private fun saveData(data: String) {
//    txtView.text = data
//}
//}

//menggunakan kotlin syintetic
//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(R.layout.activity_main)
//
//
//    btn_send.setOnClickListener {
//        val data = editText.text
//        saveData(data.toString())
//    }
//}
