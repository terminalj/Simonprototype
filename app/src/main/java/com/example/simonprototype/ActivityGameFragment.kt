package com.example.simonprototype

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.content.Intent

class ActivityGameFragment : Fragment()
{

    var count = 0
    // View initialization logic
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View
    {
        return inflater.inflate(R.layout.fragment_game,
            container,
            false)
    }

    // Post view initialization logic
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        val tv : TextView = view.findViewById(R.id.TextGame)
        val next : Button = view.findViewById(R.id.Button_End)
        next.setOnClickListener {
            val intent = Intent(requireContext(), ActivityScore::class.java)
            intent.putExtra("saveScore", tv.text.toString())
            intent.putExtra("saveCount", count)
            startActivity(intent)
            tv.text = ""
            count = 0
        }

        val red : Button = view.findViewById(R.id.Button_Red)
        red.setOnClickListener {
            if (tv.text.toString() == "")
                tv.text = "R"
            else tv.text = String.format(getString(R.string.sequence), tv.text, getString(R.string.R))
            count++
        }

        val green : Button = view.findViewById(R.id.Button_Green)
        green.setOnClickListener {
            if (tv.text.toString() == "")
                tv.text = "G"
            else tv.text = String.format(getString(R.string.sequence), tv.text, getString(R.string.G))
            count++
        }

        val blue : Button = view.findViewById(R.id.Button_Blue)
        blue.setOnClickListener {
            if (tv.text.toString() == "")
                tv.text = "B"
            else tv.text = String.format(getString(R.string.sequence), tv.text, getString(R.string.B))
            count++
        }

        val magenta : Button = view.findViewById(R.id.Button_Magenta)
        magenta.setOnClickListener {
            if (tv.text.toString() == "")
                tv.text = "M"
            else tv.text = String.format(getString(R.string.sequence), tv.text, getString(R.string.M))
            count++
        }

        val yellow : Button = view.findViewById(R.id.Button_Yellow)
        yellow.setOnClickListener {
            if (tv.text.toString() == "")
                tv.text = "Y"
            else tv.text = String.format(getString(R.string.sequence), tv.text, getString(R.string.Y))
            count++
        }

        val cyan : Button = view.findViewById(R.id.Button_Cyan)
        cyan.setOnClickListener {
            if (tv.text.toString() == "")
                tv.text = "C"
            else tv.text = String.format(getString(R.string.sequence), tv.text, getString(R.string.C))
            count++
        }

        val reset : Button = view.findViewById(R.id.Button_Reset)
        reset.setOnClickListener {
            tv.text = ""
            count = 0
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tv : TextView = requireView().findViewById(R.id.TextGame)
        outState.putString("Sequence", tv.text.toString())
        outState.putInt("Count", count)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        val tv : TextView = requireView().findViewById(R.id.TextGame)
        if (savedInstanceState != null) {
            tv.text = savedInstanceState.getString("Sequence")
            count = savedInstanceState.getInt("Count")
        }
    }
}
