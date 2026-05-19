package com.example.simonprototype

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import androidx.fragment.app.Fragment

class ActivityGameFragment : Fragment()
{

    // gameState: 0(start/end), 1 (computer), 2(player)
    var gameState = 0
    var isPaused = false

    var sequence = ""

    private lateinit var dbHelper: DatabaseHelper

    private lateinit var btnStart: Button
    private lateinit var btnReset: Button
    private lateinit var btnEnd: Button
    private lateinit var tv: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        dbHelper = DatabaseHelper(requireContext())
        tv = view.findViewById(R.id.TextGame)
        btnReset = view.findViewById(R.id.Button_Reset)
        btnEnd = view.findViewById(R.id.Button_End)
        btnStart = view.findViewById(R.id.Button_Start)


        btnEnd.setOnClickListener {
            val intent = Intent(requireContext(), ActivityScore::class.java)
            saveGameToDB()
            startActivity(intent)
            tv.text = ""
            sequence = ""
        }

        btnStart.setOnClickListener {
            if (gameState == 0) {
                gameState = 1
            }
            else {isPaused = !isPaused}
            btnStart.text = if (isPaused) {getString(R.string.continuee)} else {getString(R.string.pause)}
        }
        // red button declaration
        val red : Button = view.findViewById(R.id.Button_Red)
        // button listener
        red.setOnClickListener {
            // check to see if it is the first button
            if (tv.text.toString() == "")
                // if yes don't put comma
                tv.text = "R"
            // else concatenate with what came before
            else tv.text = String.format(getString(R.string.sequence), tv.text, getString(R.string.R))
            sequence = sequence.plus("R")
        }

        val green : Button = view.findViewById(R.id.Button_Green)
        green.setOnClickListener {
            if (tv.text.toString() == "")
                tv.text = "G"
            else tv.text = String.format(getString(R.string.sequence), tv.text, getString(R.string.G))
            sequence = sequence.plus("G")
        }

        val blue : Button = view.findViewById(R.id.Button_Blue)
        blue.setOnClickListener {
            if (tv.text.toString() == "")
                tv.text = "B"
            else tv.text = String.format(getString(R.string.sequence), tv.text, getString(R.string.B))
            sequence = sequence.plus("B")
        }

        val magenta : Button = view.findViewById(R.id.Button_Magenta)
        magenta.setOnClickListener {
            if (tv.text.toString() == "")
                tv.text = "M"
            else tv.text = String.format(getString(R.string.sequence), tv.text, getString(R.string.M))
            sequence = sequence.plus("M")
        }

        val yellow : Button = view.findViewById(R.id.Button_Yellow)
        yellow.setOnClickListener {
            if (tv.text.toString() == "")
                tv.text = "Y"
            else tv.text = String.format(getString(R.string.sequence), tv.text, getString(R.string.Y))
            sequence = sequence.plus("Y")
        }

        val cyan : Button = view.findViewById(R.id.Button_Cyan)
        cyan.setOnClickListener {
            if (tv.text.toString() == "")
                tv.text = "C"
            else tv.text = String.format(getString(R.string.sequence), tv.text, getString(R.string.C))
            sequence = sequence.plus("C")
        }
        btnReset.setOnClickListener {
            tv.text = ""
            sequence = ""
            gameState = 0
            btnStart.text = getString(R.string.start)
        }
    }

    private fun saveGameToDB() {
        val score = sequence.length - 1
        if (score == 0) return
        dbHelper.insertGame(sequence.length, sequence.length-1, tv.text as String)
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tv : TextView = requireView().findViewById(R.id.TextGame)
        outState.putString("Sequence", sequence)
        outState.putString("SequenceViewed", tv.text.toString())
    }
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        val tv : TextView = requireView().findViewById(R.id.TextGame)
        if (savedInstanceState != null) {
            sequence = savedInstanceState.getString("Sequence").toString()
            tv.text = savedInstanceState.getString("SequenceViewed")
        }
    }
}
