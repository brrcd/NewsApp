package com.example.newsapp.api

import com.example.newsapp.model.ApiResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("top-headlines")
    fun getListOfNews(
        @Query("country") countryCode: String
    ): Single<ApiResponse>
}