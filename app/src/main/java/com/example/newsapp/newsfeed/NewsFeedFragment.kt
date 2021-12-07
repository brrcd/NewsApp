package com.example.newsapp.newsfeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.newsapp.R
import com.example.newsapp.Screens
import com.example.newsapp.adapter.NewsFeedAdapter
import com.example.newsapp.adapter.OnItemViewClickListener
import com.example.newsapp.databinding.NewsFeedFragmentBinding
import com.example.newsapp.db.NewsDatabase
import com.example.newsapp.di.AbsFragment
import com.example.newsapp.model.News
import com.example.newsapp.repository.NewsRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.functions.Action
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.ktx.moxyPresenter
import java.util.*
import javax.inject.Inject

class NewsFeedFragment : AbsFragment(R.layout.news_feed_fragment), NewsFeedView {

    private var _binding: NewsFeedFragmentBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy {
        NewsFeedAdapter(
            object : OnItemViewClickListener {
                override fun onItemViewClick(news: News) {
                    router.navigateTo(Screens.singleNewsScreen(news))
                }
            }
        )
    }
    private val placeholderImage = R.drawable.placeholder_image

    @Inject
    lateinit var db: NewsDatabase

    @Inject
    lateinit var repository: NewsRepository

    private val presenter by moxyPresenter { NewsFeedPresenter(repository) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = NewsFeedFragmentBinding.inflate(inflater, container, false)
        binding.recyclerView.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.newsFeedFragment.setOnRefreshListener {
            presenter.getNews()
            binding.newsFeedFragment.isRefreshing = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun initAdapter(news: List<News>) {
        adapter.setPlaceholderImageRes(placeholderImage)
        adapter.setNewsList(news)
    }

    override fun onError(error: Throwable) {
        Toast.makeText(requireContext(), "Error!", Toast.LENGTH_SHORT).show()
    }

    companion object {

        fun newInstance(): Fragment =
            NewsFeedFragment()
    }
}