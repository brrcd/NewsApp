package com.example.mynewsapp.repository

import com.example.mynewsapp.model.ApiResponse
import retrofit2.Response

interface NewsFeedRepository {
    fun getListOfNews(countryCode: String): Response<ApiResponse>
    fun saveUrlsToDB(urls: List<String>)
    fun getUrlsFromDB(): List<String>
}