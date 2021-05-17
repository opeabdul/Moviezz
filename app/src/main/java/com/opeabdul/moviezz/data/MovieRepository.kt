package com.opeabdul.moviezz.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.opeabdul.moviezz.db.MovieDatabase
import com.opeabdul.moviezz.model.Movie
import com.opeabdul.moviezz.model.MovieResponse
import com.opeabdul.moviezz.remote.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource) {


    companion object {
        private var instance: MovieRepository? = null

        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(RemoteDataSource(MovieService.create()), LocalDataSource(MovieDatabase.getInstance(context).movieDao())).also { instance = it }
            }
    }



    suspend fun getTopRatedMovies(refreshFromServer: Boolean): MovieResponse? {
        return remoteDataSource.getTopRatedMovies()
    }

    suspend fun getTopRatedMoviesAndSaveData(){
        withContext(Dispatchers.IO){
            val moviesResponse = remoteDataSource.getTopRatedMovies()
            localDataSource.insertMovies(moviesResponse.movies){
                Log.i("MovieRepository", "Movies retrieved: " + moviesResponse.movies.size)
            }
        }
    }

    fun getAllRatedMovies(refreshFromServer: Boolean): LiveData<List<Movie>>{
        return localDataSource.getAllMovies()
    }
}