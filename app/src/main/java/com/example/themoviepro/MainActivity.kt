package com.example.themoviepro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_movie_home.*

//https://api.themoviedb.org/3/movie/popular?api_key=0a9a56d12504c6d92ce90bc56144ef00&language=en-US&page=1
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar2)
    }
}

