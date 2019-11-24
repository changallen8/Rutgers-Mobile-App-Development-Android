package com.repository_search.repository_search

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.repository_search.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //private lateinit var repoViewModel: RepositoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        /*repoViewModel = ViewModelProviders.of(this).get(RepositoryViewModel::class.java)

        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = GridLayoutManager(this, 2)

        val repoAdapter = RepositoryAdapter(repoViewModel.repo.value!!)

        recycler_view.adapter = repoAdapter

        repoViewModel.repo.observe(this, Observer { repo ->
            repoAdapter.loadNewData(repo)
        })

        repoViewModel.error.observe(this, Observer { error ->
            if (error == true) {
                Toast.makeText(this, "Error getting Repositories", Toast.LENGTH_LONG).show()
                repoViewModel.error.value = false
            }
        })*/
        repo_name_edit_text.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                search_button.isEnabled = !(s?.isEmpty()?:false)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })

        search_button.setOnClickListener{
            if (repo_name_edit_text.text.isNotEmpty()) {
                val input = repo_name_edit_text.text.toString()
                val intent = Intent(this@MainActivity, RepoList::class.java)
                intent.putExtra("Input", input)
                startActivity(intent)
            }
        }
    }


}
