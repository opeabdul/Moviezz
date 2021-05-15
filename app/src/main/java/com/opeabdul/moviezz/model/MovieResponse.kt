package com.opeabdul.moviezz.model

import com.squareup.moshi.Json

data class MovieResponse(@Json(name = "page") val page: String,
                         @Json(name = "results") val movies: List<Movie>,
                         @Json(name = "total_pages") val totalPages: Int,
                         @Json(name = "total_results") val totalResults: Int
)