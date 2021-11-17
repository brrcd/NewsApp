package com.example.mynewsapp.api

import com.example.mynewsapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object ApiUtils {
    private const val mainUrlPart = "https://newsapi.org/v2"
    private const val apiKey = BuildConfig.API_KEY

    const val url = "$mainUrlPart/"

    // TODO remove this interceptor
    private val interceptor = HttpLoggingInterceptor()

    fun getOkHttpClient(): OkHttpClient {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val origin = chain.request()
                val requestBuilder = origin.newBuilder()
                    .addHeader("Authorization", apiKey)
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .addInterceptor(interceptor)
            .build()
        return httpClient
    }
}