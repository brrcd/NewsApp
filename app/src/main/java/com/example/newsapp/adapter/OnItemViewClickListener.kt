package com.example.newsapp.adapter

import com.example.newsapp.model.News

interface OnItemViewClickListener {
    fun onItemViewClick(news: News)
}