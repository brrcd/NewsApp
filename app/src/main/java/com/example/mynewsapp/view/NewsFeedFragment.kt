package com.example.mynewsapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mynewsapp.AppState
import com.example.mynewsapp.R
import com.example.mynewsapp.adapter.NewsFeedAdapter
import com.example.mynewsapp.databinding.NewsFeedFragmentBinding
import com.example.mynewsapp.viewmodel.NewsFeedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFeedFragment: Fragment() {

    private val viewModel: NewsFeedViewModel by viewModel()
    private var _binding: NewsFeedFragmentBinding? = null
    private val binding get() = _binding!!
    private val adapter = NewsFeedAdapter()
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner, { renderData(it) })
        viewModel.getListOfNews(countryCode)
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                adapter.setNewsList(appState.newsList)
                adapter.setPlaceholderImageRes(placeholderImage)
                recyclerView.adapter = adapter
            }
            is AppState.Error -> {

            }
            is AppState.Loading -> {

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}