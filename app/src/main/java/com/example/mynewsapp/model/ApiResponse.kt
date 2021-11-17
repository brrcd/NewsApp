package com.example.mynewsapp.model

data class ApiResponse(
    val status: String?,
    val totalResults: Int?,
    val articles: List<News>?,
    val code: String?,
    val message: String?
)
