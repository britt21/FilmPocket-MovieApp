package com.example.data.moviedata

import androidx.room.TypeConverter
import com.example.data.moviedata.MovieData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


var gson = Gson()


class DataConverter {
    @TypeConverter
    fun toJson(movie : MovieData): String{
        return gson.toJson(movie)
    }

    @TypeConverter
    fun fromJson(data: String): MovieData{
        val listType = object : TypeToken<MovieData>(){}.type
        return gson.fromJson(data, listType)

    }
}