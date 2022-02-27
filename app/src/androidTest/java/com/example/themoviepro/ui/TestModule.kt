package com.example.themoviepro.ui

import android.content.Context
import androidx.room.Room
import com.example.data.moviedata.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named


@Module
@InstallIn(SingletonComponent::class)

object TestModule {

    @Provides
    @Named("test_db")
    fun provideDatabase(
        @ApplicationContext context: Context
    ): MovieDatabase{
        return Room.inMemoryDatabaseBuilder(
            context, MovieDatabase::class.java
        ).allowMainThreadQueries().build()
    }
}