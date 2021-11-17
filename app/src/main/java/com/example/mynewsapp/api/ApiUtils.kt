package com.example.mynewsapp.api

import com.example.mynewsapp.BuildConfig
import okhttp3.OkHttpClient

object ApiUtils {
    private const val mainUrlPart = "https://newsapi.org/v2"
    private const val apiKey = BuildConfig.API_KEY

    const val url = "$mainUrlPart/"

    fun getOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val origin = chain.request()
                val requestBuilder = origin.newBuilder()
                    .addHeader("Authorization", apiKey)
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .build()
        return httpClient
    }
}