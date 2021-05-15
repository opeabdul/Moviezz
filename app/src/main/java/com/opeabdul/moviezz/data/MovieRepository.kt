package com.opeabdul.moviezz.data

import androidx.lifecycle.LiveData
import com.opeabdul.moviezz.model.Movie
import com.opeabdul.moviezz.model.MovieResponse
import com.opeabdul.moviezz.remote.MovieService

class MovieRepository(private val remoteDataSource: RemoteDataSource) {


    companion object {
        private var instance: MovieRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(RemoteDataSource(MovieService.create())).also { instance = it }
            }
    }



    suspend fun getTopRatedMovies(refreshFromServer: Boolean): MovieResponse? {
        return remoteDataSource.getTopRatedMovies()
    }
}