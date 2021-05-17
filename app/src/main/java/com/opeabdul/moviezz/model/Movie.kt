package com.opeabdul.moviezz.model

import com.squareup.moshi.Json
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "movie")
@Parcelize
data class Movie(@Json(name = "adult") val adult: Boolean,
                 @Json(name ="backdrop_path") val backdropPath: String,
                 @PrimaryKey @Json(name ="id") val id: Int,
                 @Json(name ="original_language") val originalLanguage: String,
                 @Json(name ="original_title") val originalTitle: String,
                 @Json(name ="overview") val overview: String,
                 @Json(name ="popularity") val popularity: Double,
                 @Json(name ="poster_path") val posterPath: String,
                 @Json(name ="release_date") val releaseDate: String,
                 @Json(name ="title") val title: String,
                 @Json(name ="video") val video: Boolean,
                 @Json(name ="vote_average") val voteAverage: Double,
                 @Json(name ="vote_count") val voteCount: Int
): Parcelable{

}
