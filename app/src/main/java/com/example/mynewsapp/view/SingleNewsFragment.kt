package com.example.mynewsapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mynewsapp.databinding.SingleNewsFragmentBinding
import com.example.mynewsapp.viewmodel.SingleNewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SingleNewsFragment: Fragment() {

    private val viewModel: SingleNewsViewModel by viewModel()
    private var _binding: SingleNewsFragmentBinding? = null
    private val binding get() = _binding!!

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
}