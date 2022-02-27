package com.example.themoviepro.ui

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.data.moviedata.Constant
import com.example.data.moviedata.Result
import com.example.themoviepro.databinding.FragmentMovieHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieHomeFragment : Fragment() {


    lateinit var drawerLayout : DrawerLayout

    private lateinit var binding: FragmentMovieHomeBinding
    private lateinit var viewModel: MovieViewModel
    private val movieAapter = MovieAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        // Inflate the layout for this fragment
        binding = FragmentMovieHomeBinding.inflate(inflater)

        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)




        val options = arrayOf("1", "2", "3", "4", "5", "6", "8","9","10","11","12","13","14")

//        spinner.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1,options)
        binding.spinner.adapter =
            ArrayAdapter(requireContext(), R.layout.simple_list_item_1, options)
        binding.rvList.adapter = movieAapter




        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.getMovie(Constant.API_KEY, options.get(p2).toInt())

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
            viewModel.getMovie(Constant.API_KEY, Constant.PAGE_NUMBER)
            viewModel.livemovie.observe(this, { response ->
                if (response != null) {
                    movieAapter.submitList(response.results)
                    Log.d("Response........", "$response")
                    Log.d("Response........", "${response}")
                }
                else{
                    Toast.makeText(requireContext(), response, Toast.LENGTH_SHORT).show()
                }


            })
        }
        val result = Result(false, "Drop_Dope,", listOf(), 93, "incm", "dmd", "dindi",8.00,"k d","4444","Bd Man By Rema",false,77.000,9000)
        val action = MovieHomeFragmentDirections.actionMovieHomeFragmentToMovieDetail(result)
        binding.goBtn.setOnClickListener {
            findNavController().navigate(action)
        }

        readDataBase()
        return  binding.root
    }



    private fun getMovies() {
        viewModel.getMovie(Constant.API_KEY, Constant.PAGE_NUMBER)
        viewModel.livemovie.observe(this, Observer { response ->
            if (response != null) {
                movieAapter.submitList(response.results)
                Log.d("Response........", "$response")
                Log.d("Response........", "${response}")
            }
            else{
                Toast.makeText(requireContext(), response, Toast.LENGTH_SHORT).show()
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