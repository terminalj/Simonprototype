package com.example.simonprototype

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class ActivityGame : AppCompatActivity()
{
    // Called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        WindowCompat.enableEdgeToEdge(window)
        setContentView(R.layout.activity_game)

        if (savedInstanceState == null)
        {
            val fragment = ActivityGameFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.activity_game, fragment)
                .commit()
        }

        // Ensure that system bars remain visible regardless of the background color:
        // can be done via XML styling because minSdk is 27
    }
}
