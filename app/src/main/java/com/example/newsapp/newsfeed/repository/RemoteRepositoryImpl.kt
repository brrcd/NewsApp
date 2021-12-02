package com.example.newsapp.newsfeed.repository

import com.example.newsapp.api.Api
import com.example.newsapp.model.News
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RemoteRepositoryImpl
@Inject constructor(
    private val api: Api
) : RemoteRepository {
    override fun getListOfNews(countryCode: String): Maybe<List<News>> =
        api.getListOfNews(countryCode)
            .subscribeOn(Schedulers.io())
            .flatMapMaybe { response ->
                if (response.articles?.isNotEmpty() == true) {
                    Maybe.just(response.articles)
                } else (Maybe.empty())
            }
}