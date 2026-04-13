package com.example.nit3213finalapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val title = intent.getStringExtra("title")
        val property2 = intent.getStringExtra("property2")
        val description = intent.getStringExtra("description")

        findViewById<TextView>(R.id.tvDetailProperty1).text = title
        findViewById<TextView>(R.id.tvDetailProperty2).text = property2
        findViewById<TextView>(R.id.tvDetailDescription).text = description
    }
}