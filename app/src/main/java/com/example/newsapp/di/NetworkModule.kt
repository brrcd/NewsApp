package com.example.newsapp.di

import com.example.newsapp.BuildConfig
import com.example.newsapp.api.Api
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val origin = chain.request()
            val requestBuilder = origin.newBuilder()
                .addHeader("Authorization", BuildConfig.API_KEY)
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .build()

    @Reusable
    @Provides
    fun provideGithubApi(okHttpClient: OkHttpClient): Api =
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(Api::class.java)
}