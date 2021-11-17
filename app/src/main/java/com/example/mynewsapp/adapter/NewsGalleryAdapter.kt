package com.example.mynewsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mynewsapp.databinding.GalleryRvItemBinding
import com.example.mynewsapp.model.News

class NewsGalleryAdapter : RecyclerView.Adapter<NewsGalleryAdapter.NewsGalleryViewHolder>() {

    private var listOfUrls = listOf<String>()
    private var placeholderImageRes: Int = 0

    fun setListOfUrls(data: List<String>){
        listOfUrls = data
        notifyDataSetChanged()
    }

    fun setPlaceholderImageRes(int: Int) {
        placeholderImageRes = int
    }

    inner class NewsGalleryViewHolder(private val binding: GalleryRvItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(string: String){
            binding.image.load(
                string
            ) {
                placeholder(placeholderImageRes)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsGalleryAdapter.NewsGalleryViewHolder {
        return NewsGalleryViewHolder(
            GalleryRvItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsGalleryAdapter.NewsGalleryViewHolder, position: Int) {
        holder.bind(listOfUrls[position])
    }

    override fun getItemCount(): Int {
        return listOfUrls.size
    }
}