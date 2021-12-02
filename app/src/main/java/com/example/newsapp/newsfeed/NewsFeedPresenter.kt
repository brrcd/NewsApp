package com.example.newsapp.newsfeed

import com.example.newsapp.repository.NewsRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter

class NewsFeedPresenter(
    private val newsRepository: NewsRepository
) : MvpPresenter<NewsFeedView>() {

    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        getNews()
    }

    fun getNews(){
        disposable +=
            newsRepository
                .getListOfNews("ru")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    viewState::initAdapter,
                    viewState::onError
                )
    }

    override fun onDestroy() {
        disposable.clear()
    }
}