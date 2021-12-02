package com.example.newsapp.singlenews

import com.example.newsapp.MainView
import com.example.newsapp.model.News
import moxy.viewstate.strategy.alias.SingleState

interface SingleNewsView : MainView{
    @SingleState
    fun showNews(news: News)
}