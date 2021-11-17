package com.example.mynewsapp

import android.app.Application
import android.content.Context
import com.example.mynewsapp.di.appModule
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
        startKoin {
            modules(appModule)
        }
    }

    companion object {
        lateinit var appContext: Context
    }
}