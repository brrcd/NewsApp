package com.example.newsapp.newsfeed.repository

import com.example.newsapp.model.News
import io.reactivex.rxjava3.core.Observable

interface LocalRepository {
    fun saveNewsToDB(news: List<News>): Observable<List<News>>
    fun getListOfNewsFromDB(): Observable<List<News>>
}