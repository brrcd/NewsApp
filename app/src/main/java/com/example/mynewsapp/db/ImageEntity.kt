package com.example.mynewsapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ImageEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val urlToImage: String
)