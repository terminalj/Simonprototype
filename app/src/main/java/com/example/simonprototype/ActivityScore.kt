package com.example.simonprototype

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class ActivityScore : AppCompatActivity() {

    // This lives as long as the app process is alive
    companion object {
        val scoreHistory = ArrayList<Item>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val recyclerview: RecyclerView = findViewById(R.id.RecyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)

        // Pass the static list to the adapter
        val adapter = Adapter(scoreHistory)
        recyclerview.adapter = adapter

        val currentScore = intent.getStringExtra("saveScore")
        if (currentScore != null && currentScore != "PLACEHOLDER") {
            scoreHistory.add(Item(currentScore.length, currentScore))
            // CRITICAL: Tell the adapter a new item was added
            adapter.notifyItemInserted(scoreHistory.size - 1)
        }

        findViewById<Button>(R.id.Button_Start).setOnClickListener { finish() }
    }
}