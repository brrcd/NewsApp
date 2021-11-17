package com.example.mynewsapp

import com.example.mynewsapp.model.ApiResponse
import com.example.mynewsapp.model.News

sealed class AppState {
    data class Success(val newsList: List<News>) : AppState()
    data class Error(val errorMessage: String) : AppState()
    object Loading : AppState()
}
