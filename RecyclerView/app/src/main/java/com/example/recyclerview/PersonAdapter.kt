package com.example.recyclerview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(var people: List<Person>) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    fun loadNewData(newPeople: List<Person>){
        people = newPeople
        notifyItemInserted(people.lastIndex)
    }

    override fun getItemCount() = people.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.textViewPersonName.text = people[position].name
        holder.viewColorBlock.setBackgroundColor(Color.parseColor(people[position].favoriteColor))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.person_view_holder, parent, false)
        return PersonViewHolder(v)
    }


    class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textViewPersonName = view.findViewById<TextView>(R.id.text_view_person_name)
        val viewColorBlock = view.findViewById<View>(R.id.view_color_block)
    }

}