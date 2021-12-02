package com.example.newsapp.newsfeed

import com.example.newsapp.MainView
import com.example.newsapp.model.News
import moxy.viewstate.strategy.alias.SingleState

interface NewsFeedView: MainView {
    @SingleState
    fun initAdapter(news: List<News>)
}