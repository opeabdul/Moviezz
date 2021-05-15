package com.opeabdul.moviezz.data

import androidx.lifecycle.LiveData
import com.opeabdul.moviezz.model.MovieResponse
import com.opeabdul.moviezz.remote.MovieService
import java.util.concurrent.Executor

class RemoteDataSource(private val movieService: MovieService) {



    private val request = movieService.topRatedMovies("a5d4af2020006057b35a2721a9cb4025", "en-US", 1)

    suspend fun getTopRatedMovies(): MovieResponse = request.await()

}