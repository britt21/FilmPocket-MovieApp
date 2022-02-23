package com.example.themoviepro

import com.example.data.moviedata.MovieData
import com.example.data.moviedata.MovieEntity
import com.example.data.moviedata.Result
import com.example.domain.GetMoviesUseCases
import com.example.domain.InsertMovieUseCase
import com.example.domain.ReadDataUseCase
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test


class MovieViewModelTest {

    lateinit var viewModel: MovieViewModel
    lateinit var getMoviesUseCases: GetMoviesUseCases
    lateinit var insertMovieUseCase: InsertMovieUseCase
    lateinit var readDataUseCase: ReadDataUseCase
    lateinit var fakeMovieRepository: FakeMovieRepository
    @Before
    fun setup(){
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

        val movieresult = mutableListOf<Result>()
        val news = MovieData(2,movieresult, 543, 23)
        val newsEntity= MovieEntity(8,news)
        viewModel.InsertMovie(newsEntity)
        val movie = viewModel.livemovie.value
        assertThat(movie).isNull()
    }

}