package com.example.data.moviedata

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [MovieEntity::class], version = 1)
@TypeConverters(DataConverter::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract val movieDao: MovieDao
}