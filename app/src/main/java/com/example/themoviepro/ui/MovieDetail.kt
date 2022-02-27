package com.example.themoviepro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.themoviepro.R
import com.example.themoviepro.databinding.FragmentMovieDetailBinding

class MovieDetail : Fragment() {

    val args = navArgs<MovieDetailArgs>()
    private lateinit var binding : FragmentMovieDetailBinding
    private lateinit var viewModel: MovieViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        binding = FragmentMovieDetailBinding.inflate(inflater)

        binding.textTitle.setText(args.value.moviedata.title)
        binding.textDesc.setText(args.value.moviedata.overview)
        binding.imgDet.load("https://image.tmdb.org/t/p/w500"+ args.value.moviedata.posterPath)
        binding.playBtn.setOnClickListener {

        }
        binding.postBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Review Posted", Toast.LENGTH_SHORT).show()
            binding.noiceText.visibility = View.VISIBLE
        }
        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_movieDetail_to_movieHomeFragment)
        }

        binding.saveBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Movie Added to WishList", Toast.LENGTH_SHORT).show()

        }

        binding.noiceText.visibility = View.GONE


        return binding.root
    }

}