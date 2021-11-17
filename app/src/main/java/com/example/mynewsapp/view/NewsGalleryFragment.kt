package com.example.mynewsapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mynewsapp.AppState
import com.example.mynewsapp.R
import com.example.mynewsapp.adapter.NewsGalleryAdapter
import com.example.mynewsapp.databinding.NewsGalleryFragmentBinding
import com.example.mynewsapp.viewmodel.NewsGalleryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsGalleryFragment: Fragment(){

    private val viewModel: NewsGalleryViewModel by viewModel()
    private var _binding: NewsGalleryFragmentBinding? = null
    private val binding get() = _binding!!
    private val adapter = NewsGalleryAdapter()
    private val placeholderImage = R.drawable.placeholder_image

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = NewsGalleryFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner, { renderData(it) })
        viewModel.getListOfUrls()
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                adapter.setListOfUrls(appState.newsDTO.imageUrls)
                adapter.setPlaceholderImageRes(placeholderImage)
                recyclerView.adapter = adapter
            }
            is AppState.Error -> {
                Toast.makeText(context, appState.errorMessage, Toast.LENGTH_SHORT).show()
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