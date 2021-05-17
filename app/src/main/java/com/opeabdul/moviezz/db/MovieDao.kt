package com.opeabdul.moviezz.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.opeabdul.moviezz.model.Movie


@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: List<Movie>)

    @Query("SELECT * FROM movie")
    fun getAllMovies(): LiveData<List<Movie>>
}