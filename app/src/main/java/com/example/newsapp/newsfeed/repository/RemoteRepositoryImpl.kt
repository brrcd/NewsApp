package com.example.newsapp.newsfeed.repository

import com.example.newsapp.api.Api
import com.example.newsapp.model.ApiResponse
import com.example.newsapp.model.News
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RemoteRepositoryImpl
@Inject constructor(
    private val api: Api
) : RemoteRepository {
    override fun getListOfNews(countryCode: String): Single<ApiResponse> =
        api.getListOfNews(countryCode)
            .delay(3L, TimeUnit.SECONDS)
}