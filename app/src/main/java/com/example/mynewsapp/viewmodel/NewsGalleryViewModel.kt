package com.example.mynewsapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mynewsapp.repository.NewsFeedRepository

class NewsGalleryViewModel(private val newsFeedRepository: NewsFeedRepository) : ViewModel()  {
}