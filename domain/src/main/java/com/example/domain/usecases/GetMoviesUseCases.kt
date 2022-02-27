package com.example.domain.usecases

import com.example.data.moviedata.MovieData
import com.example.domain.NetworkResult
import com.example.domain.Repository
import javax.inject.Inject

class GetMoviesUseCases @Inject constructor(private val repository: Repository) {

    suspend fun getMovies(apiKey: String, page: Int): NetworkResult<MovieData> {
        val response = repository.getMovie(apiKey, page)
        return NetworkResult.Sucess(response.body()!!)

    }

}