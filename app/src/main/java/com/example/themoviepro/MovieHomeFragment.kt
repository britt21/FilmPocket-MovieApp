package com.example.themoviepro

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.drawerlayout.widget.DrawerLayout
import androidx.legacy.app.ActionBarDrawerToggle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.data.moviedata.Constant.Companion.API_KEY
import com.example.data.moviedata.Constant.Companion.PAGE_NUMBER
import com.example.themoviepro.databinding.FragmentMovieHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movie_home.*


@AndroidEntryPoint
class MovieHomeFragment : Fragment() {


    lateinit var drawerLayout : DrawerLayout

    private lateinit var binding: FragmentMovieHomeBinding
    private lateinit var viewModel: MovieViewModel
    private val movieAapter =  MovieAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        binding = FragmentMovieHomeBinding.inflate(inflater)

        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)

        readDataBase()


        val options = arrayOf("1", "2", "3", "4", "5", "6", "8","9","10","11","12","13","14")

//        spinner.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1,options)
        binding.spinner.adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, options)
        binding.rvList.adapter = movieAapter




        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.getMovie(API_KEY, options.get(p2).toInt())

                viewModel.livemovie.observe(this@MovieHomeFragment, Observer { result ->
                    if (result != null) {
                        movieAapter.submitList(result.results)
                        Log.d("Response........", "$result")
                        Log.d("Response........", "${result}")
                    }

                })
            }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }



            binding.refeshList.setOnRefreshListener {
                binding.refeshList.isRefreshing = false
                viewModel.getMovie(API_KEY, PAGE_NUMBER)
                viewModel.livemovie.observe(this, Observer { result ->
                    if (result != null) {
                        movieAapter.submitList(result.results)
                        Log.d("Response........", "$result")
                        Log.d("Response........", "${result}")
                    }

                })
            }

        return  binding.root
    }

    private fun getMovies() {
        viewModel.getMovie(API_KEY, PAGE_NUMBER)
        viewModel.livemovie.observe(this, Observer { result ->
            if (result != null) {
                movieAapter.submitList(result.results)
                Log.d("Response........", "$result")
                Log.d("Response........", "${result}")
            }

        })

    }

    private fun readDataBase() {
        viewModel.readData.observe(this, Observer { database ->
        if (database.isNotEmpty()){
            movieAapter.submitList(database[0].movies.results)
        }else{
            getMovies()
        }

        })
    }


}