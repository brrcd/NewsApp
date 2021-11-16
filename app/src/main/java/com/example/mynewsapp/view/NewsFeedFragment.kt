package com.example.mynewsapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mynewsapp.databinding.NewsFeedFragmentBinding
import com.example.mynewsapp.viewmodel.NewsFeedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFeedFragment: Fragment() {

    private val viewModel: NewsFeedViewModel by viewModel()
    private var _binding: NewsFeedFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = NewsFeedFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}