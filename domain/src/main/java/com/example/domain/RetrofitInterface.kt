package com.example.domain

import com.example.data.moviedata.MovieData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//https://api.themoviedb.org/3/movie/popular?api_key=0a9a56d12504c6d92ce90bc56144ef00&language=en-US&page=1

const val BASE_URL = "https://api.themoviedb.org"
interface RetrofitInterface{
    @GET("/3/movie/popular?language=en-US")
   suspend fun getMovies(
        @Query("api_key") apiKey : String,
        @Query("page") page : Int
    ): Response<MovieData>
}

