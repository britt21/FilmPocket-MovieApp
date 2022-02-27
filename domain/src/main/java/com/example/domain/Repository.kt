package com.example.domain

import androidx.lifecycle.LiveData
import com.example.data.moviedata.MovieData
import com.example.data.moviedata.MovieEntity
import retrofit2.Response
import java.util.concurrent.Flow

interface Repository {

    suspend fun getMovie(apiKey : String, page : Int): Response<MovieData>

    suspend fun InsertMovie(movieEntity: MovieEntity)

    fun readData(): LiveData<List<MovieEntity>>



}