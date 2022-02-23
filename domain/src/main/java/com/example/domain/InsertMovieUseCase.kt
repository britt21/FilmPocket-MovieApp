package com.example.domain

import com.example.data.moviedata.MovieEntity
import javax.inject.Inject

class InsertMovieUseCase @Inject constructor(private val repository: Repository) {

    suspend fun InsertMovies(movieEntity: MovieEntity){
        repository.InsertMovie(movieEntity)
    }
}