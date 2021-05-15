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

class MovieListViewModel(private val repository: MovieRepository): ViewModel() {


    private var job: Job? = null

    private val _movieResponseLiveData = MutableLiveData<MovieResponse>()
    val movieResponseLiveData: LiveData<MovieResponse?>
        get() = _movieResponseLiveData

    val topRatedMovieList: LiveData<List<Movie>?> = Transformations.map(movieResponseLiveData){ it ->
        it?.movies
    }

    init {
        getTopRatedMovies()
    }

    init {
            getTopRatedMovies()
    }

    fun getTopRatedMovies(){
        job?.cancel()
        job = viewModelScope.launch {
            try{
                _movieResponseLiveData.value = repository.getTopRatedMovies(true)
            }catch (e: IOException){
                _movieResponseLiveData.postValue(null)
            }
        }
    }

}