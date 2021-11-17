package com.example.mynewsapp.api

import com.example.mynewsapp.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET ("top-headlines")
    fun getListOfNews(
        @Query("country") countryCode: String
    ): Call<ApiResponse>
}