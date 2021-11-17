package com.example.mynewsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewsapp.AppState
import com.example.mynewsapp.model.NewsDTO
import com.example.mynewsapp.repository.NewsFeedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsGalleryViewModel(private val repository: NewsFeedRepository) : ViewModel() {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()

    fun getLiveData() = liveDataToObserve

    fun getListOfUrls() {
        liveDataToObserve.value = AppState.Loading
        viewModelScope.launch(Dispatchers.Default) {
            val data = repository.getUrlsFromDB()
            liveDataToObserve.postValue(
                AppState.Success(
                    NewsDTO(null, data)
                )
            )
        }
    }
}