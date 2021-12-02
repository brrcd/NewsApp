package com.example.newsapp.newsfeed.repository

import com.example.newsapp.model.News
import io.reactivex.rxjava3.core.Maybe

interface RemoteRepository {
    fun getListOfNews(countryCode: String): Maybe<List<News>>
}