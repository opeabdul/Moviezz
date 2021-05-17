package com.opeabdul.moviezz.ui

import androidx.lifecycle.*
import com.opeabdul.moviezz.data.MovieRepository
import com.opeabdul.moviezz.model.Movie
import com.opeabdul.moviezz.model.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.xml.transform.TransformerFactory

class MovieListViewModel(private val repository: MovieRepository): ViewModel() {


    private var job: Job? = null

    val topRatedMovieList: LiveData<List<Movie>> = repository.getAllRatedMovies(false)

    init {
        getTopRatedMovies(true)
    }

    fun getTopRatedMovies(refreshFromServer: Boolean){
        job?.cancel()

        job = viewModelScope.launch {
            try{
                repository.getTopRatedMoviesAndSaveData()
            }catch (e: IOException){

            }
        }
    }

}