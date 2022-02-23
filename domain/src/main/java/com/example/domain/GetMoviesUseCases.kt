package com.example.domain

import com.example.data.moviedata.MovieData
import javax.inject.Inject

class GetMoviesUseCases @Inject constructor(private val repository: Repository) {

    suspend fun getMovies(apiKey : String, page : Int) : NetworkResult<MovieData>{
         val response = repository.getMovie(apiKey, page)
        val result = response.body()
        if(response.isSuccessful){
       return     NetworkResult.Sucess(result!!)
        }
        else{
       return     NetworkResult.Error("No internet Connection")
        }

    }
}