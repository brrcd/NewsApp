package com.example.newsapp.newsfeed.repository

import com.example.newsapp.db.NewsDatabase
import com.example.newsapp.model.News
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class LocalRepositoryImpl
@Inject constructor(
    private val newsDatabase: NewsDatabase
) : LocalRepository {
    override fun saveNewsToDB(news: List<News>): Observable<List<News>> =
        newsDatabase
            .newsDao()
            .saveNewsToDB(news)
            .andThen(
                newsDatabase
                    .newsDao()
                    .getNewsFromDB()
            )

    override fun getListOfNewsFromDB(): Observable<List<News>> =
        newsDatabase
            .newsDao()
            .getNewsFromDB()
}