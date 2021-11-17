package com.example.mynewsapp.model


data class NewsDTO (
    val newsList: List<News>? = null,
    val imageUrls: List<String> = listOf()
)