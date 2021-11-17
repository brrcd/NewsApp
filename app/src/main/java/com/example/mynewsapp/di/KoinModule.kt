package com.example.mynewsapp.di

import com.example.mynewsapp.repository.NewsFeedRepository
import com.example.mynewsapp.repository.NewsFeedRepositoryImpl
import com.example.mynewsapp.viewmodel.NewsFeedViewModel
import com.example.mynewsapp.viewmodel.NewsGalleryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<NewsFeedRepository> { NewsFeedRepositoryImpl() }
    //View models
    viewModel { NewsFeedViewModel(get()) }
    viewModel { NewsGalleryViewModel(get()) }
}