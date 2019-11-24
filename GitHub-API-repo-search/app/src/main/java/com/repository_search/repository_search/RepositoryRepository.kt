package com.repository_search.repository_search

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryRepository{
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/search/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val repositoryService = retrofit.create(RepositoryService::class.java)

    fun getRepository(name: String, callback: (repositoryResponse: RepositoryResponse?) -> Unit){
        repositoryService.getRepositoryByName(name).enqueue(object : Callback<RepositoryResponse> {
            override fun onFailure(call: Call<RepositoryResponse>, t: Throwable){

                callback(null)
            }
            override fun onResponse(call: Call<RepositoryResponse>, response: Response<RepositoryResponse>) {
                callback(response.body())
            }
        })
    }


}