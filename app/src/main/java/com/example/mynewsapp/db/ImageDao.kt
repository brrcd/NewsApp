package com.example.mynewsapp.db

import androidx.room.*

@Dao
interface ImageDao{

    @Query("SELECT * FROM ImageEntity")
    fun all(): List<ImageEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: ImageEntity)

    @Update
    fun update(entity: ImageEntity)

    @Delete
    fun delete(entity: ImageEntity)
}