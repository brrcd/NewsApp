package com.example.newsapp.singlenews

import com.example.newsapp.model.News
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class SingleNewsPresenter(
    private val news: News
) : MvpPresenter<SingleNewsView>() {

    private val disposable = CompositeDisposable()


    override fun onFirstViewAttach() {
        viewState.showNews(news)
    }

    override fun onDestroy() {
        disposable.clear()
    }
}