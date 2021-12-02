package com.example.newsapp

import com.example.newsapp.model.News
import com.example.newsapp.newsfeed.NewsFeedFragment
import com.example.newsapp.singlenews.SingleNewsFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun newsFeedScreen(): Screen = FragmentScreen { NewsFeedFragment.newInstance() }
    fun singleNewsScreen(news: News) = FragmentScreen { SingleNewsFragment.newInstance(news) }
}