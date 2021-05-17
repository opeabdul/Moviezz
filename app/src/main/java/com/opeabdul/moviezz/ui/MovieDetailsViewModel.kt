package com.opeabdul.moviezz.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.opeabdul.moviezz.model.Movie
import java.lang.RuntimeException

class MovieDetailsViewModel (val movie: Movie): ViewModel(){

}

class MovieDetailsViewModelFactory(val movie: Movie): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        try{
            return modelClass.getConstructor(Movie::class.java).newInstance(movie)
        }catch (e: Exception){
            throw RuntimeException("Cannot create instance of model class $modelClass", e)
        }
    }

}