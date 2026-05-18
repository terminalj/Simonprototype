package com.example.simonprototype

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val item = intent.getSerializableExtra("GAME_ITEM") as? Item

        item?.let {
            val scoreView: TextView = findViewById(R.id.scoreText)
            val sequenceView: TextView = findViewById(R.id.detailSequenceText)

            scoreView.text = "Score: ${it.number}"

            val spannable = SpannableString(it.text)
            val convertedindex = 3 * it.index

            if (convertedindex < it.text.length && convertedindex >= 0) {
                spannable.setSpan(ForegroundColorSpan(Color.RED), convertedindex, it.text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            sequenceView.text = spannable
        }
    }
}