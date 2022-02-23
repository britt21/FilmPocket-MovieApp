package com.example.themoviepro

import android.graphics.Movie
import androidx.lifecycle.*
import com.example.data.moviedata.MovieData
import com.example.data.moviedata.MovieEntity
import com.example.data.moviedata.Result
import com.example.domain.GetMoviesUseCases
import com.example.domain.InsertMovieUseCase
import com.example.domain.ReadDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val getMoviesUseCases: GetMoviesUseCases,
private val insertMovieUseCase: InsertMovieUseCase,
private val readDataUseCase: ReadDataUseCase) : ViewModel() {


    val readData : LiveData<List<MovieEntity>> = readDataUseCase.readData().asLiveData()

    fun InsertMovie(movieEntity: MovieEntity){
        viewModelScope.launch(Dispatchers.IO) {
            insertMovieUseCase.InsertMovies(movieEntity)
        }




    }

private val _livemovie = MutableLiveData<MovieData>()
    val livemovie : LiveData<MovieData>
    get() = _livemovie


//    fun update(movieData: MovieData){
//        viewModelScope.launch {
//                val newEntity = MovieEntity(3, movieData)
//                updateMovieUscCase.updateMovie(newEntity)
//            }
//
//
//    }

    fun getMovie(apiKey : String, page: Int){
        viewModelScope.launch {
            try {


            val response = getMoviesUseCases.getMovies(apiKey, page)
            if (response.data != null) {
                _livemovie.value = response.data!!
                val result = _livemovie.value
                if (result != null) {
                    offlinecache(result)

                }
            }



        }catch (e:Exception){


            }
        }
    }

    private fun offlinecache(result: MovieData) {
        val movieEntity = MovieEntity(1, result)
        InsertMovie(movieEntity)

    }
}
