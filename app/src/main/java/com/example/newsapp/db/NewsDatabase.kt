package com.example.newsapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsapp.model.News

@Database(
    entities = [News::class],
    version = 5,
    exportSchema = false
)

abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
}