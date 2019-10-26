package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var people = mutableListOf(
        Person("John","#ff0000"),
        Person("Grace", "#0000ff")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = GridLayoutManager(this, 2)

        val peopleAdapter = PersonAdapter(people)

        recycler_view.adapter = peopleAdapter

        button_add_person.setOnClickListener{
            people.add(Person(edit_text_name.text.toString(), edit_text_color.text.toString()))
            peopleAdapter.loadNewData(people)
        }

    }

}

