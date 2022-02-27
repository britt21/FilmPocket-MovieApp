package com.example.themoviepro.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import com.example.data.moviedata.MovieDao
import com.example.data.moviedata.MovieData
import com.example.data.moviedata.MovieDatabase
import com.example.data.moviedata.MovieEntity
import com.example.data.moviedata.Result
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


private  val movie = mutableListOf<MovieEntity>()


@ExperimentalCoroutinesApi
@SmallTest
@HiltAndroidTest
class MovieDaoTest {


    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    lateinit var database: MovieDatabase
    lateinit var dao: MovieDao

    @Before
    fun setup() {

        hiltAndroidRule.inject()
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(), MovieDatabase::class.java
        ).build()
        dao = database.movieDao
    }

        @After
        fun tearDown() {
            database.close()
        }

        @Test
        fun InsertMovie() = runBlockingTest {

            val result = mutableListOf<Result>()
            val movieData = MovieData(3, result, 39, 393)
            val movieEntity = MovieEntity(32, movieData)
            dao.InsertMovie(movieEntity)

            val observeData = dao.readMovie().getOrAwaitValuetest()

            assertThat(observeData).contains(movieEntity)

        }

    @Test
    fun launchfragmentinsenerio(){

        launchFragmentInHiltContainer<MovieHomeFragment> {

        }
    }


    }


