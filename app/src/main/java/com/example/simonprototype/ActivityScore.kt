package com.example.simonprototype

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class ActivityScore : AppCompatActivity()
{
    // Called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        WindowCompat.enableEdgeToEdge(window)
        setContentView(R.layout.activity_score)

        val recyclerview : RecyclerView = findViewById(R.id.RecyclerView)

        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<Item>()

        var scorefill = ""

        val scoresample = "RGBMYC"

        for (i in 0..5) {
            scorefill += scoresample[i].toString()
            data.add(Item(scorefill.length, scorefill))
        }

        val adapter = Adapter(data)

        recyclerview.adapter = adapter

        val previous : Button = findViewById(R.id.Button_Start)
        previous.setOnClickListener {
            // Note: no result is communicated to the caller
            finish()
        }
    }
}