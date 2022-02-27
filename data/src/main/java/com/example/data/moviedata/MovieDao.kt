package com.example.data.moviedata

import androidx.lifecycle.LiveData
import androidx.room.*
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertMovie(movieData: MovieEntity)


    @androidx.room.Query("Select * From MovieEntity")
    fun readMovie(): LiveData<List<MovieEntity>>



}