package com.example.mynewsapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRepository {
    val api: Api by lazy {
        val adapter = Retrofit.Builder()
            .baseUrl(ApiUtils.url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(ApiUtils.getOkHttpClient())
            .build()
        adapter.create(Api::class.java)
    }
}