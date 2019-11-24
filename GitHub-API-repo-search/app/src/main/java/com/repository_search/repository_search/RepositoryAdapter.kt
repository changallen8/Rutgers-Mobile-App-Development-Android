package com.repository_search.repository_search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.repository_search.R
import kotlinx.android.synthetic.main.repo_view_holder.view.*

class RepositoryAdapter(var items: List<Item>) : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>(){

    fun loadNewData(newRepo: List<Item>) {
        items = newRepo
        notifyItemInserted(items.lastIndex)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val v = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.repo_view_holder, parent, false)

        return RepositoryViewHolder(v)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.setUpForItem(items[position])
    }

    class RepositoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            fun setUpForItem(item : Item) {
                itemView.text_view_repo.text = item.html_url
                itemView.desc_text_view.text = item.description
            }
    }


}