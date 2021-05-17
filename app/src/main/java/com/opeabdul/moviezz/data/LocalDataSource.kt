package com.opeabdul.moviezz.data

import androidx.lifecycle.LiveData
import com.opeabdul.moviezz.db.MovieDao
import com.opeabdul.moviezz.model.Movie

class LocalDataSource(
    private val movieDao: MovieDao,
) {

    fun insertMovies(movies: List<Movie>, insertFinished: () -> Unit){
            movieDao.insert(movies)
            insertFinished()
    }

    fun getAllMovies(): LiveData<List<Movie>>{
        return movieDao.getAllMovies()
    }

}