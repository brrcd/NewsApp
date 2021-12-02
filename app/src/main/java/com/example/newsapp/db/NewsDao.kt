package com.example.newsapp.db

import androidx.room.*
import com.example.newsapp.model.News
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface NewsDao{

    @Query("SELECT * FROM News")
    fun getNewsFromDB(): Observable<List<News>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNewsToDB(news: List<News>): Completable
}