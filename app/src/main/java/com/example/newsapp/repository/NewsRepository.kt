package com.example.newsapp.repository

import com.example.newsapp.model.News
import io.reactivex.rxjava3.core.Observable

interface NewsRepository {
    fun getListOfNews(countryCode: String): Observable<List<News>>
}