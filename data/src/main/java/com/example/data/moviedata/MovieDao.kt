package com.example.data.moviedata

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertMovie(movieData: MovieEntity)


    @androidx.room.Query("Select * From MovieEntity")
    fun readMovie(): kotlinx.coroutines.flow.Flow<List<MovieEntity>>



}