package com.opeabdul.moviezz.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.opeabdul.moviezz.databinding.MovieItemBinding
import com.opeabdul.moviezz.model.Movie

class MovieListAdapter: ListAdapter<Movie, MovieListAdapter.MovieListViewHolder>(DiffUtilCallBack()) {

    class MovieListViewHolder(val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(movie:Movie){
            binding.movie = movie
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffUtilCallBack: DiffUtil.ItemCallback<Movie>(){
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

}