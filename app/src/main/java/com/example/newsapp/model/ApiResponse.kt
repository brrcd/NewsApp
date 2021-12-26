package com.example.newsapp.model

data class ApiResponse(
    val status: String = "",
    val totalResults: Int = 0,
    val articles: List<News>,
    val code: String = "",
    val message: String = ""
)
