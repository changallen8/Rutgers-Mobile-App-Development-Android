package com.example.button_and_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cheeseFragment = CheeseFragment()
        val hamFragment = HamFragment()
        val breadFragment = BreadFragment()
        val sandwichFragment = SandwichFragment()

        button_bread.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, breadFragment)
                .addToBackStack(null)
                .commit()
        }

        button_ham.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, hamFragment)
                .addToBackStack(null)
                .commit()
        }

        button_cheese.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, cheeseFragment)
                .addToBackStack(null)
                .commit()
        }

        button_sandwich.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, sandwichFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}
