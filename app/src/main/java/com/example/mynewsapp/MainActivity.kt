package com.example.mynewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.mynewsapp.view.NewsFeedFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .add(R.id.main_container, NewsFeedFragment())
            .addToBackStack(null)
            .commit()
    }
}