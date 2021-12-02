package com.example.newsapp.di

import com.example.newsapp.MainActivity
import com.example.newsapp.newsfeed.NewsFeedFragment
import com.example.newsapp.newsfeed.repository.LocalRepository
import com.example.newsapp.newsfeed.repository.LocalRepositoryImpl
import com.example.newsapp.newsfeed.repository.RemoteRepository
import com.example.newsapp.newsfeed.repository.RemoteRepositoryImpl
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.repository.NewsRepositoryImpl
import com.example.newsapp.singlenews.SingleNewsFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes =
    [NetworkModule::class,
        DBModule::class]
)
interface MainModule {

    @ContributesAndroidInjector
    fun bindNewsFeedFragment(): NewsFeedFragment

    @ContributesAndroidInjector
    fun bindSingleNewsFragment(): SingleNewsFragment

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @Binds
    fun bindNewsRepository(
        newsRepository: NewsRepositoryImpl
    ): NewsRepository

    @Binds
    fun bindLocalRepository(
        localRepository: LocalRepositoryImpl
    ): LocalRepository

    @Binds
    fun bindRemoteRepository(
        remoteRepository: RemoteRepositoryImpl
    ): RemoteRepository
}