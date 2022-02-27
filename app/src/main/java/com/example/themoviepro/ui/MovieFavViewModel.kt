package com.example.themoviepro.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.data.moviedata.MovieEntity
import com.example.domain.usecases.ReadDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieFavViewModel @Inject constructor(private val readDataUseCase: ReadDataUseCase): ViewModel() {

    val readData : LiveData<List<MovieEntity>> = readDataUseCase.readData()


}