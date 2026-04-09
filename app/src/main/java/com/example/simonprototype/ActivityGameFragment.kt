package com.example.simonprototype

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import android.os.Build
import android.content.res.Configuration
import android.view.WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS

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
//        val tv : TextView = findTextView(R.id.TextGame)

        val next : Button = view.findViewById(R.id.Button1)
        next.setOnClickListener {
            // Note: no result is coming back
            findNavController().navigate(R.id.activity_score)
        }

        val red : Button = view.findViewById(R.id.Button_1)
        red.setOnClickListener {
            val a = getString(R.string.sequence) + "R"

        }
    }
}
