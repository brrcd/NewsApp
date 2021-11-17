package com.example.mynewsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mynewsapp.AppState
import com.example.mynewsapp.repository.NewsFeedRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NewsFeedViewModel(private val repository: NewsFeedRepository) : ViewModel() {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private var job : Job? = null

    fun getLiveData() = liveDataToObserve

    fun getListOfNews(countryCode: String) {
        liveDataToObserve.value = AppState.Loading
        job = CoroutineScope(Dispatchers.Default).launch {
            val data = repository.getListOfNews(countryCode).articles

            liveDataToObserve.postValue(data?.let { AppState.Success(it) })
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}