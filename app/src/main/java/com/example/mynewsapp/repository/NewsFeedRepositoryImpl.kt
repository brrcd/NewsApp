package com.example.mynewsapp.repository

import com.example.mynewsapp.BuildConfig
import com.example.mynewsapp.api.ApiRepository
import com.example.mynewsapp.model.ApiResponse

class NewsFeedRepositoryImpl: NewsFeedRepository {

    override fun getListOfNews(countryCode: String): ApiResponse {
        val dto = ApiRepository
            .api
            .getListOfNews(countryCode)
            .execute()
            .body()

        return ApiResponse(
            dto?.status,
            dto?.totalResults,
            dto?.articles
        )
    }
}