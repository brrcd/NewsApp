package com.example.newsapp.repository

import com.example.newsapp.model.News
import com.example.newsapp.newsfeed.repository.LocalRepository
import com.example.newsapp.newsfeed.repository.RemoteRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class NewsRepositoryImpl
@Inject constructor(
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository
) : NewsRepository {
    override fun getListOfNews(countryCode: String): Observable<List<News>> =
        Observable.merge(
            localRepository
                .getListOfNewsFromDB(),
            remoteRepository
                .getListOfNews(countryCode)
                .flatMapObservable { response ->
                    localRepository
                        .saveNewsToDB(response.articles)
                }
        )
}