package com.example.themoviepro

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.data.moviedata.MovieData
import com.example.data.moviedata.MovieEntity
import com.example.data.moviedata.Result
import com.example.domain.NetworkResult
import com.example.domain.Repository
import com.example.domain.RetrofitInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class FakeMovieRepository : Repository {

    private val data = mutableListOf<MovieEntity>()
    private val movie = mutableListOf<MovieData>()
    val listresult = mutableListOf<Result>()
    private  val movieData = MovieData(28, listresult,83, 383)
   val retrofitInterface : RetrofitInterface? = null
    override suspend fun getMovie(apiKey: String, page: Int): Response<MovieData> {
     movie?.let {  return  Response.success(movieData) }
    }

    override suspend fun InsertMovie(movieEntity: MovieEntity) {
        data.add(movieEntity)

    }

    override fun readData(): LiveData<List<MovieEntity>> {
     return  liveData{ movie }
    }


}