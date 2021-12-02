package com.example.newsapp.di

import android.content.Context
import com.example.newsapp.App
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [AndroidInjectionModule::class,
        MainModule::class]
)
interface NewsAppComponent: AndroidInjector<App> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        fun build(): NewsAppComponent
    }
}