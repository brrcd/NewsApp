package com.example.mynewsapp.repository

import com.example.mynewsapp.api.ApiRepository
import com.example.mynewsapp.db.ImageEntity
import com.example.mynewsapp.db.ImagesDatabase
import com.example.mynewsapp.model.ApiResponse
import retrofit2.Response

class NewsFeedRepositoryImpl : NewsFeedRepository {

    override fun getListOfNews(countryCode: String): Response<ApiResponse> {

        return ApiRepository
            .api
            .getListOfNews(countryCode)
            .execute()
    }

    override fun saveUrlsToDB(urls: List<String>) =
        urls.forEach {
            ImagesDatabase.db.imageDao().insert(convertToDBEntity(it))
        }


    override fun getUrlsFromDB(): List<String> =
        convertToStringList(ImagesDatabase.db.imageDao().all())


    private fun convertToDBEntity(string: String): ImageEntity =
        ImageEntity(
            0,
            urlToImage = string
        )

    private fun convertToStringList(entityList: List<ImageEntity>): List<String> =
        entityList.map {
            (it.urlToImage)
        }
}