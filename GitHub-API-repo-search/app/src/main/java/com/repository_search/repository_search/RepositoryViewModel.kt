package com.repository_search.repository_search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.concurrent.thread

class RepositoryViewModel : ViewModel() {
    private val repositoryRepository = RepositoryRepository()

    val repoResponse = MutableLiveData<RepositoryResponse>()

    val error = MutableLiveData<Boolean>(false)

    fun attemptToGet(name: String) {

        thread {

            repositoryRepository.getRepository(name) { newRepositoryResponse ->

                if (newRepositoryResponse != null) {
                    repoResponse.postValue(newRepositoryResponse)
                } else {
                    error.postValue(true)

                }
            }
        }
    }
}
