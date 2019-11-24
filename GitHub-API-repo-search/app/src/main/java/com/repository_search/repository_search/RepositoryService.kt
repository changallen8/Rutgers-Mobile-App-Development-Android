package com.repository_search.repository_search

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RepositoryService {
    @GET("repositories?")
    fun getRepositoryByName(@Query("q") name: String): Call<RepositoryResponse>

}
