package com.example.mynewsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewsapp.databinding.NewsRvItemBinding
import com.example.mynewsapp.model.News

class NewsFeedAdapter: RecyclerView.Adapter<NewsFeedAdapter.NewsFeedViewHolder>() {

    private var newsList = listOf<News>()

    fun setNewsList(data: List<News>){
        newsList = data
        notifyDataSetChanged()
    }

    inner class NewsFeedViewHolder(private val binding: NewsRvItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(news: News) {
            binding.tvName.text = news.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsFeedViewHolder {
        return NewsFeedViewHolder(
            NewsRvItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsFeedViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}