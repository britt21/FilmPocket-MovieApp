package com.example.domain

import com.example.data.moviedata.MovieDao
import com.example.data.moviedata.MovieData
import com.example.data.moviedata.MovieEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl  @Inject constructor(private val retrofitInterface: RetrofitInterface,private val movieDao: MovieDao) : Repository {
    override suspend fun getMovie(apiKey: String, page:  Int): Response<MovieData> {
        return retrofitInterface.getMovies(apiKey, page)
    }

    override suspend fun InsertMovie(movieEntity: MovieEntity) {
        movieDao.InsertMovie(movieEntity)

    }

    override fun readData(): Flow<List<MovieEntity>> {
        return movieDao.readMovie()
    }


}