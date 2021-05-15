package com.opeabdul.moviezz.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.opeabdul.moviezz.model.MovieResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieService {

    @GET("3/movie/top_rated")
    fun topRatedMovies(@Query("api_key") apiKey: String,
                       @Query("language") language: String,
                       @Query("page") pageNumber: Int,
    ): Deferred<MovieResponse>

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org"
        //https://api.themoviedb.org/3/movie/top_rated?api_key=a5d4af2020006057b35a2721a9cb4025&language=en-US&page=1


        fun create(): MovieService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

            return Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl(BASE_URL)
                .client(client)
                .build()
                .create(MovieService::class.java)
        }
    }
}