package com.example.newsapp

import com.example.newsapp.di.DaggerNewsAppComponent
import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerNewsAppComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()
                withRouter(cicerone.router)
                withNavigatorHolder(cicerone.getNavigatorHolder())
            }
            .build()

    companion object{
        const val TAG = "_TEST_"
    }
}