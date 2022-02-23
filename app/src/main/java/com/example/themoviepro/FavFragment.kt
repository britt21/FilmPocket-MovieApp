package com.example.themoviepro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.themoviepro.databinding.FavItemBinding
import com.example.themoviepro.databinding.FragmentFavBinding

class FavFragment : Fragment() {

    lateinit var binding : FragmentFavBinding
    val adapter =  MovieAdapter()
    private lateinit var viewModel: MovieViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentFavBinding.inflate(inflater)

        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)

        binding.favList.adapter = adapter

        ReadData()

        return binding.root
    }

    private fun ReadData() {
        viewModel.readData.observe(this, Observer { data ->
            if (data.isNotEmpty()){
                adapter.submitList(data[0].movies.results)
            }

        })
    }


}