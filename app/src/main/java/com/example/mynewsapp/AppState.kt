package com.example.mynewsapp

import com.example.mynewsapp.model.News

sealed class AppState {
    data class Success(val newsList: List<News>) : AppState()
    data class Error(val throwable: Throwable) : AppState()
    object Loading : AppState()
}
