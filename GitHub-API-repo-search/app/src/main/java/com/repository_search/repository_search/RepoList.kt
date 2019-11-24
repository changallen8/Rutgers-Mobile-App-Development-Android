package com.repository_search.repository_search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.repository_search.R
import kotlinx.android.synthetic.main.activity_repo__list.*

class RepoList : AppCompatActivity() {

    private lateinit var repoViewModel: RepositoryViewModel

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo__list)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val input: String? = intent.getStringExtra("Input")

        if (input != null) {

            supportActionBar?.title = "Search results for $input"

            repoViewModel = ViewModelProviders.of(this).get(RepositoryViewModel::class.java)

            repoViewModel.attemptToGet(input)

                recycler_view.setHasFixedSize(true)
                recycler_view.layoutManager = GridLayoutManager(this, 1)

                val repoAdapter = RepositoryAdapter(listOf())

                recycler_view.adapter = repoAdapter

                repoViewModel.repoResponse.observe(this, Observer { repo ->
                    progressBar.visibility= View.INVISIBLE
                    recycler_view.visibility= View.VISIBLE
                    repoAdapter.loadNewData(repo.items)
                })

                repoViewModel.error.observe(this, Observer { error ->
                    if (error == true) {
                        Toast.makeText(this, "Error getting Repositories", Toast.LENGTH_LONG).show()
                        repoViewModel.error.value = false
                    }
                })
        }
    }
}
