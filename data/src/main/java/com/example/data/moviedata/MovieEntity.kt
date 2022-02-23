package com.example.data.moviedata

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val movies : MovieData
):Parcelable