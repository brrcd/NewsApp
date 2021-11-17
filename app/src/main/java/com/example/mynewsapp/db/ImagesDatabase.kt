package com.example.mynewsapp.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mynewsapp.App

@Database(
    entities = [ImageEntity::class],
    version = 2,
    exportSchema = false
)

abstract class ImagesDatabase : RoomDatabase() {
    abstract fun imageDao(): ImageDao

    companion object{
        private const val DB_NAME = "images_db"
        val db: ImagesDatabase by lazy {
            Room.databaseBuilder(
                App.appContext,
                ImagesDatabase::class.java,
                DB_NAME
            )
                .build()
        }
    }
}