package com.example.domain.usecases

import com.example.data.moviedata.MovieEntity
import com.example.domain.Repository
import javax.inject.Inject

class InsertMovieUseCase @Inject constructor(private val repository: Repository) {

    suspend fun InsertMovies(movieEntity: MovieEntity){
        repository.InsertMovie(movieEntity)
    }
}