package com.example.themoviepro

import com.example.data.moviedata.MovieData
import com.example.data.moviedata.MovieEntity
import com.example.domain.Repository
import com.example.domain.RetrofitInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class FakeMovieRepository : Repository {

    private val movie = mutableListOf<MovieEntity>()
   val retrofitInterface : RetrofitInterface? = null
    override suspend fun getMovie(apiKey: String, page: Int): Response<MovieData> {
        return retrofitInterface!!.getMovies(apiKey, page)
    }

    override suspend fun InsertMovie(movieEntity: MovieEntity) {
        movie.add(movieEntity)

    }

    override fun readData(): Flow<List<MovieEntity>> {
     return  flow{ movie }
    }


}