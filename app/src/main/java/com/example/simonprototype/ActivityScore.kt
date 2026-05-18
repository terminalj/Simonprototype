package com.example.simonprototype

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActivityScore : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private var scoreHistory = ArrayList<Item>()
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        dbHelper = DatabaseHelper(this)

        val recyclerview: RecyclerView = findViewById(R.id.RecyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)

        scoreHistory = dbHelper.getAllGames()

        adapter = Adapter(scoreHistory) { clickedItem ->
            val intent = Intent(this@ActivityScore, ActivityDetail::class.java)
            intent.putExtra("GAME_ITEM", clickedItem)
            startActivity(intent)
        }

        recyclerview.adapter = adapter

        findViewById<Button>(R.id.Button_Start).setOnClickListener {
            val intent = Intent(this@ActivityScore, ActivityGame::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        scoreHistory.clear()
        scoreHistory.addAll(dbHelper.getAllGames())
        adapter.notifyDataSetChanged()
    }
}