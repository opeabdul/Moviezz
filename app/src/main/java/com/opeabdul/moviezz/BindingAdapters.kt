package com.opeabdul.moviezz

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.opeabdul.moviezz.model.Movie
import com.opeabdul.moviezz.ui.adapters.MovieListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, list: List<Movie>?){
    list?.let {
        if(it.isNotEmpty()){
            val adapter = recyclerView.adapter as MovieListAdapter
            adapter.submitList(list)
            recyclerView.visibility = View.VISIBLE
        }else{
            recyclerView.visibility = View.GONE
        }
    }
}

@BindingAdapter("barVisibility")
fun showProgressbar(view: View, data: List<Any>?){
    if (data == null)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

@BindingAdapter("emptyStateVisibility")
fun showEmptyState(cardView: CardView, data: List<Any>?){
    cardView.visibility = when(data){
        null -> View.GONE
        else -> if(data.isEmpty()) View.VISIBLE else View.GONE
    }
}

@BindingAdapter("loadImg")
fun loadImage(imageView: AppCompatImageView, path: String){
    val imageUrl = "https://image.tmdb.org/t/p/w500" + path
    Glide.with(imageView).load(imageUrl).into(imageView)
}