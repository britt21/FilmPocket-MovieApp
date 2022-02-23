package com.example.themoviepro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.DifferCallback
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import  com.example.data.moviedata.Result

import com.example.themoviepro.databinding.ItemListBinding
import kotlinx.android.synthetic.main.item_list.view.*

class MovieAdapter : ListAdapter<Result, MovieAdapter.MovieViewHolder>(DifferCallback) {

    companion object DifferCallback : DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return  oldItem.id === newItem.id
        }

    }
    class MovieViewHolder(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root){
            fun bind(movies : Result){
                binding.movies = movies
                binding.imgUrl.load("https://image.tmdb.org/t/p/w500" + movies.posterPath)
                binding.textView.setText(movies.title)
                binding.textView2.setText(movies.releaseDate)


            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context)))

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val curlist = getItem(position)
        holder.bind(curlist)
        holder.itemView.item_container.setOnClickListener {
            val action = MovieHomeFragmentDirections.actionMovieHomeFragmentToMovieDetail(curlist)
            holder.itemView.findNavController().navigate(action)
        }

    }
}