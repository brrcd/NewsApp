package com.example.mynewsapp.repository

import com.example.mynewsapp.api.ApiRepository
import com.example.mynewsapp.model.ApiResponse
import retrofit2.Response

class NewsFeedRepositoryImpl: NewsFeedRepository {

    override fun getListOfNews(countryCode: String): Response<ApiResponse> {

        return ApiRepository
            .api
            .getListOfNews(countryCode)
            .execute()
    }
}