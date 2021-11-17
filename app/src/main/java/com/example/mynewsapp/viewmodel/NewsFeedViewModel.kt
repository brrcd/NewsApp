package com.example.mynewsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewsapp.AppState
import com.example.mynewsapp.repository.NewsFeedRepository
import com.google.gson.Gson
import kotlinx.coroutines.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Retrofit

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
                    liveDataToObserve.postValue(response.body()?.articles?.let { AppState.Success(it) })
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