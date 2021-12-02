package com.example.newsapp

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface MainView : MvpView {
    @SingleState
    fun onError(error: Throwable)
}