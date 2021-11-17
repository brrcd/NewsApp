package com.example.mynewsapp.api

import com.example.mynewsapp.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET
    fun getNews(): Call<ApiResponse>
}