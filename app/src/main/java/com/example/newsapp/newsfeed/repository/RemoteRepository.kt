package com.example.newsapp.newsfeed.repository

import com.example.newsapp.model.ApiResponse
import com.example.newsapp.model.News
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

interface RemoteRepository {
    fun getListOfNews(countryCode: String): Single<ApiResponse>
}