package com.example.domain.usecases

import androidx.lifecycle.LiveData
import com.example.data.moviedata.MovieEntity
import com.example.domain.Repository
import javax.inject.Inject

class ReadDataUseCase @Inject constructor(private val repository: Repository) {

    fun readData(): LiveData<List<MovieEntity>> {
     return repository.readData()
    }

}