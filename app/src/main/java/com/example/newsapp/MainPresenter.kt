package com.example.newsapp

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(val router: Router): MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(Screens.newsFeedScreen())
    }
}