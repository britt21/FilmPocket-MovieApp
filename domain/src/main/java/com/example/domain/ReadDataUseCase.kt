package com.example.domain

import com.example.data.moviedata.MovieEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadDataUseCase @Inject constructor(private val repository: Repository) {

    fun readData(): Flow<List<MovieEntity>>{
     return repository.readData()
    }

}