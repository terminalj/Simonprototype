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
        val currentCount = intent.getIntExtra("saveCount", 0)
        if (currentScore != null && currentScore != "ALREADY") {
            scoreHistory.add(Item(currentCount, currentScore))
            // CRITICAL: Tell the adapter a new item was added
            adapter.notifyItemInserted(scoreHistory.size - 1)
            intent.putExtra("saveScore", "ALREADY")
        }

        findViewById<Button>(R.id.Button_Start).setOnClickListener { finish() }
    }
}