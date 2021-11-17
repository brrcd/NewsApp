package com.example.mynewsapp.adapter

import com.example.mynewsapp.model.News

interface OnItemViewClickListener {
    fun onItemViewClick(news: News)
}