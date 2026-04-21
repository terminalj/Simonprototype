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
    // count is public
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
        // initialize TextView variable to tv
        val tv : TextView = view.findViewById(R.id.TextGame)
        val next : Button = view.findViewById(R.id.Button_End)
        // start activity_score on next click
        next.setOnClickListener {
            //send data through activities via intent
            val intent = Intent(requireContext(), ActivityScore::class.java)
            intent.putExtra("saveScore", tv.text.toString())
            intent.putExtra("saveCount", count)
            startActivity(intent)
            // reset data values
            tv.text = ""
            count = 0
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
            // increase count
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
            // reset sequence and count
            tv.text = ""
            count = 0
        }
    }
    // function to save State Instance on focus loss
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // assignment of TextGame TextView to tv necessary from incapsulation
        val tv : TextView = requireView().findViewById(R.id.TextGame)
        // saving values to InstanceState with keywords
        outState.putString("Sequence", tv.text.toString())
        // count is public
        outState.putInt("Count", count)
    }
    // function to restore Instance State on focus gain
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        // assignment of TextGame TextView to tv necessary from incapsulation
        val tv : TextView = requireView().findViewById(R.id.TextGame)
        // assignment of values from InstanceState with keywords
        if (savedInstanceState != null) {
            tv.text = savedInstanceState.getString("Sequence")
            count = savedInstanceState.getInt("Count")
        }
    }
}
