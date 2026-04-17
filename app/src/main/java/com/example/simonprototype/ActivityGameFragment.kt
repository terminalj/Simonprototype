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
            // Note: no result is coming back
            val intent = Intent(requireContext(), ActivityScore::class.java)
            intent.putExtra("saveScore", tv.text.toString())

            startActivity(intent)
            //findNavController().navigate(R.id.activity_score)
            tv.text = "PLACEHOLDER"
        }

        val red : Button = view.findViewById(R.id.Button_Red)
        red.setOnClickListener {
            if (tv.text.toString() == "PLACEHOLDER")
                tv.text = ""
            tv.text = tv.text.toString() + "R"

        }

        val green : Button = view.findViewById(R.id.Button_Green)
        green.setOnClickListener {
            if (tv.text.toString() == "PLACEHOLDER")
                tv.text = ""
            tv.text = tv.text.toString() + "G"

        }

        val blue : Button = view.findViewById(R.id.Button_Blue)
        blue.setOnClickListener {
            if (tv.text.toString() == "PLACEHOLDER")
                tv.text = ""
            tv.text = tv.text.toString() + "B"

        }

        val magenta : Button = view.findViewById(R.id.Button_Magenta)
        magenta.setOnClickListener {
            if (tv.text.toString() == "PLACEHOLDER")
                tv.text = ""
            tv.text = tv.text.toString() + "M"

        }

        val yellow : Button = view.findViewById(R.id.Button_Yellow)
        yellow.setOnClickListener {
            if (tv.text.toString() == "PLACEHOLDER")
                tv.text = ""
            tv.text = tv.text.toString() + "Y"

        }

        val cyan : Button = view.findViewById(R.id.Button_Cyan)
        cyan.setOnClickListener {
            if (tv.text.toString() == "PLACEHOLDER")
                tv.text = ""
            tv.text = tv.text.toString() + "C"

        }

        val reset : Button = view.findViewById(R.id.Button_Reset)
        reset.setOnClickListener {
            tv.text = "PLACEHOLDER"
        }
    }
}
