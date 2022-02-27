package com.example.themoviepro

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.data.moviedata.MovieData
import com.example.data.moviedata.MovieEntity
import com.example.data.moviedata.Result
import com.example.domain.usecases.GetMoviesUseCases
import com.example.domain.usecases.InsertMovieUseCase
import com.example.domain.usecases.ReadDataUseCase
import com.example.themoviepro.ui.MovieViewModel
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    val dispatcher = TestCoroutineDispatcher()



    lateinit var viewModel: MovieViewModel
    lateinit var getMoviesUseCases: GetMoviesUseCases
    lateinit var insertMovieUseCase: InsertMovieUseCase
    lateinit var readDataUseCase: ReadDataUseCase
    lateinit var fakeMovieRepository: FakeMovieRepository
    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        fakeMovieRepository = FakeMovieRepository()
        getMoviesUseCases = GetMoviesUseCases(fakeMovieRepository)
        insertMovieUseCase = InsertMovieUseCase(fakeMovieRepository)
        readDataUseCase = ReadDataUseCase(fakeMovieRepository)
        viewModel = MovieViewModel(getMoviesUseCases,insertMovieUseCase,readDataUseCase)
    }



    @Test
    fun `check that getmovies function correctly gets the data`(){
        val result = mutableListOf<Result>()
        val movieData = MovieData(2,result, 543, 23)
        val movieEntity = MovieEntity(2, movieData)
        val data= viewModel.InsertMovie(movieEntity)
        assertThat(data).isNotNull()
    }

    @Test
    fun  `check that live data gets data sucessfully`(){
        viewModel.getMovie("api-key", 1)

        val movie = viewModel.livemovie.getOrAwaitValue()
        assertThat(movie).isNotNull()
    }


}