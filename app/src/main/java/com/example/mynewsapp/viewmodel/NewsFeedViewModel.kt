package com.example.mynewsapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewsapp.AppState
import com.example.mynewsapp.model.NewsDTO
import com.example.mynewsapp.repository.NewsFeedRepository
import kotlinx.coroutines.*

class NewsFeedViewModel(private val repository: NewsFeedRepository) : ViewModel() {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()

    fun getLiveData() = liveDataToObserve

    fun getListOfNews(countryCode: String) {
        liveDataToObserve.value = AppState.Loading
        viewModelScope.launch(Dispatchers.Default) {
            val response = repository.getListOfNews(countryCode)
            if (response.isSuccessful) {
                if (response.body()?.articles?.isEmpty() == true) {
                    liveDataToObserve.postValue(AppState.Error("Bad request!"))
                } else {
                    liveDataToObserve.postValue(
                        AppState.Success(
                            NewsDTO(
                                response.body()?.articles
                            )
                        )
                    )
                    val listOfUrls = mutableListOf<String>()
                    response.body()?.articles?.forEach {
                        it.urlToImage?.let { it1 -> listOfUrls.add(it1) }
                    }
                    repository.saveUrlsToDB(listOfUrls)
                }
            } else {
                liveDataToObserve.postValue(
                    AppState.Error(
                        "Error! No Connection or bad api key."
                    )
                )
            }
        }
    }
}