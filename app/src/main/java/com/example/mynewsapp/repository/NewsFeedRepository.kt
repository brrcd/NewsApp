package com.example.mynewsapp.repository

import com.example.mynewsapp.model.ApiResponse

interface NewsFeedRepository {
    fun getListOfNews(countryCode: String): ApiResponse
}