package com.example.nit3213finalapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nit3213finalapp.network.Entity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewEntities)

        val entityList = listOf(
            Entity(
                property1 = "Item 1",
                property2 = "Property 2 for item 1",
                description = "This is the description for item 1."
            ),
            Entity(
                property1 = "Item 2",
                property2 = "Property 2 for item 2",
                description = "This is the description for item 2."
            ),
            Entity(
                property1 = "Item 3",
                property2 = "Property 2 for item 3",
                description = "This is the description for item 3."
            )
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EntityAdapter(entityList) { entity ->
            openDetails(entity.property1, entity.property2, entity.description)
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