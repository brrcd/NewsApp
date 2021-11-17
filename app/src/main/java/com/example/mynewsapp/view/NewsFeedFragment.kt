package com.example.mynewsapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mynewsapp.AppState
import com.example.mynewsapp.R
import com.example.mynewsapp.adapter.NewsFeedAdapter
import com.example.mynewsapp.adapter.OnItemViewClickListener
import com.example.mynewsapp.databinding.NewsFeedFragmentBinding
import com.example.mynewsapp.model.News
import com.example.mynewsapp.view.SingleNewsFragment.Companion.SINGLE_NEWS_BUNDLE
import com.example.mynewsapp.viewmodel.NewsFeedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFeedFragment : Fragment() {

    private val viewModel: NewsFeedViewModel by viewModel()
    private var _binding: NewsFeedFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: NewsFeedAdapter
    private val countryCode = "ru"
    private val placeholderImage = R.drawable.placeholder_image

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = NewsFeedFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewModel.getLiveData().observe(viewLifecycleOwner, { renderData(it) })
        viewModel.getListOfNews(countryCode)

        newsFeedFragment.setOnRefreshListener {
            viewModel.getListOfNews(countryCode)
            newsFeedFragment.isRefreshing = false
        }
    }

    private fun initAdapter() {
        adapter = NewsFeedAdapter(
            object : OnItemViewClickListener {
                override fun onItemViewClick(news: News) {
                    val bundle = bundleOf(SINGLE_NEWS_BUNDLE to news)
                    findNavController().navigate(R.id.action_newsFeedFragment_to_singleNewsFragment, bundle)
                }
            }
        )
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                adapter.setNewsList(appState.newsList)
                adapter.setPlaceholderImageRes(placeholderImage)
                recyclerView.adapter = adapter
                newsFeedFragment.isRefreshing = false
            }
            is AppState.Error -> {
                newsFeedFragment.isRefreshing = false
                Toast.makeText(context, appState.errorMessage, Toast.LENGTH_SHORT).show()
            }
            is AppState.Loading -> {
                newsFeedFragment.isRefreshing = true
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}