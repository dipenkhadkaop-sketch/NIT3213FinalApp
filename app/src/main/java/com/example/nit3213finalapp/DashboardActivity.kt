package com.example.nit3213finalapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val cardOne = findViewById<View>(R.id.cardOne)
        val cardTwo = findViewById<View>(R.id.cardTwo)

        cardOne.setOnClickListener {
            openDetails(
                "Item 1",
                "Property 2 for item 1",
                "This is the description for item 1."
            )
        }

        cardTwo.setOnClickListener {
            openDetails(
                "Item 2",
                "Property 2 for item 2",
                "This is the description for item 2."
            )
        }
    }

    private fun openDetails(title: String, property2: String, description: String) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("title", title)
        intent.putExtra("property2", property2)
        intent.putExtra("description", description)
        startActivity(intent)
    }
}