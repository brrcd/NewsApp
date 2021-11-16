package com.example.mynewsapp

import android.app.Application
import com.example.mynewsapp.di.appModule
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}