package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.NewsRvItemBinding
import com.example.newsapp.model.News

class NewsFeedAdapter(private val onItemViewClickListener: OnItemViewClickListener): RecyclerView.Adapter<NewsFeedAdapter.NewsFeedViewHolder>() {

    private var newsList = listOf<News>()
    private var placeholderImageRes: Int = 0

    fun setNewsList(data: List<News>){
        newsList = data
        notifyDataSetChanged()
    }

    fun setPlaceholderImageRes(int: Int) {
        placeholderImageRes = int
    }

    inner class NewsFeedViewHolder(private val binding: NewsRvItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(news: News) = with(binding) {
            tvName.text = news.description
            Glide.with(itemView.context)
                .load(news.urlToImage)
                .placeholder(placeholderImageRes)
                .into(imageView)
            itemView.setOnClickListener {
                onItemViewClickListener.onItemViewClick(news)
            }
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