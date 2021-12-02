package com.example.newsapp.singlenews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.arguments
import com.example.newsapp.databinding.SingleNewsFragmentBinding
import com.example.newsapp.di.AbsFragment
import com.example.newsapp.model.News
import moxy.ktx.moxyPresenter

class SingleNewsFragment : AbsFragment(R.layout.single_news_fragment), SingleNewsView {

    private var _binding: SingleNewsFragmentBinding? = null
    private val binding get() = _binding!!

    private val presenter by moxyPresenter {
        val news: News = arguments?.getParcelable(ARG_NEWS)!!
        SingleNewsPresenter(news)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SingleNewsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun showNews(news: News) = with (binding) {
        newsTitle.text = news.title
        Glide.with(requireContext())
            .load(news.urlToImage)
            .into(newsImage)
        newsDescription.text = news.description
    }

    override fun onError(error: Throwable) {
        Toast.makeText(requireContext(), "Error!", Toast.LENGTH_SHORT).show()
    }

    companion object {

        private const val ARG_NEWS = "arg_news"

        fun newInstance(news: News): Fragment =
            SingleNewsFragment().arguments(ARG_NEWS to news)
    }
}