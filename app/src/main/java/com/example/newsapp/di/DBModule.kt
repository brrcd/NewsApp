package com.example.newsapp.di

import android.content.Context
import androidx.room.Room
import com.example.newsapp.db.NewsDatabase
import dagger.Module
import dagger.Provides

@Module
class DBModule {

    @Provides
    fun provideDatabase(context: Context): NewsDatabase =
        Room.databaseBuilder(
            context,
            NewsDatabase::class.java,
            "images_db"
        )
            .fallbackToDestructiveMigration()
            .build()
}