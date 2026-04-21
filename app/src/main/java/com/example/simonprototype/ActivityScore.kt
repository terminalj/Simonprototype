package com.example.simonprototype

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class ActivityScore : AppCompatActivity() {

    // basically a static list
    companion object {
        val scoreHistory = ArrayList<Item>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        // reference to layout RecyclerView
        val recyclerview: RecyclerView = findViewById(R.id.RecyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)

        // Pass the static list to the adapter
        val adapter = Adapter(scoreHistory)

        recyclerview.adapter = adapter
        // set passed data from game fragment to score
        val currentScore = intent.getStringExtra("saveScore")
        val currentCount = intent.getIntExtra("saveCount", 0)
        // accept data if consistent
        if (currentScore != null && currentScore != "ALREADY") {
            scoreHistory.add(Item(currentCount, currentScore))
            // CRITICAL: Tell the adapter a new item was added
            adapter.notifyItemInserted(scoreHistory.size - 1)
            // avoid double entry
            intent.putExtra("saveScore", "ALREADY")
        }
        // click listener for back button to close activity
        findViewById<Button>(R.id.Button_Start).setOnClickListener { finish() }
    }
}