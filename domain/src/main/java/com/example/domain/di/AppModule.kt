package com.example.domain.di

import android.content.Context
import androidx.room.Room
import com.example.data.moviedata.MovieDao
import com.example.data.moviedata.MovieDatabase
import com.example.domain.BASE_URL
import com.example.domain.Repository
import com.example.domain.RepositoryImpl
import com.example.domain.RetrofitInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideretrofit(): Retrofit {
    return   Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetroApi(retrofit: Retrofit): RetrofitInterface {
        return  retrofit.create(RetrofitInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideatabase(
        @ApplicationContext context: Context
    ): MovieDatabase {
        return  Room.databaseBuilder(context, MovieDatabase::class.java, "movieData").build()
    }

    @Singleton
    @Provides
    fun provideDao(movieDatabase: MovieDatabase): MovieDao {
        return movieDatabase.movieDao
    }
    @Singleton
    @Provides
    fun provideRepository(retrofitInterface: RetrofitInterface, movieDao: MovieDao): Repository {
        return RepositoryImpl(retrofitInterface, movieDao)
    }




}