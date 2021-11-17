package com.example.mynewsapp

import com.example.mynewsapp.model.NewsDTO

sealed class AppState {
    data class Success(val newsDTO: NewsDTO) : AppState()
    data class Error(val errorMessage: String) : AppState()
    object Loading : AppState()
}
