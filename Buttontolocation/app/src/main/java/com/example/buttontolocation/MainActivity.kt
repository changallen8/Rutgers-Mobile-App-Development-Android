package com.example.buttontolocation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            view_map.setOnClickListener {

                val eiffelTowerUri = Uri.parse("geo:0,0?q=Eiffel+Tower")
                val openMapIntent = Intent(Intent.ACTION_VIEW, eiffelTowerUri)

                startActivity(openMapIntent)
            }
    }
}
