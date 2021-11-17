package com.example.mynewsapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.mynewsapp.databinding.SingleNewsFragmentBinding
import com.example.mynewsapp.model.News

class SingleNewsFragment : Fragment() {

    private var _binding: SingleNewsFragmentBinding? = null
    private val binding get() = _binding!!
    private var news: News? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        news = arguments?.getParcelable(SINGLE_NEWS_BUNDLE)
        _binding = SingleNewsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            newsTitle.text = news?.title
            newsDescription.text = news?.description
            newsImage.load(
                news?.urlToImage
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val SINGLE_NEWS_BUNDLE = "single_news_bundle"

        fun newInstance(bundle: Bundle): Fragment =
            SingleNewsFragment().also {
                it.arguments = bundle
            }
    }
}