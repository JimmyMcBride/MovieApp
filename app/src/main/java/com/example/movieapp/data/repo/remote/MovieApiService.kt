package com.example.movieapp.data.repo.remote

import com.example.movieapp.data.models.Movie
import com.example.movieapp.data.models.MovieResponse
import com.example.movieapp.utils.Constants.AUTH_TOKEN
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.*

interface MovieApiService {
    @GET("movie/popular")
    @Headers("Authorization: Bearer $AUTH_TOKEN")
    suspend fun getMovies(@Query("page") page: Int = 1): Response<MovieResponse>

//    @GET("movie/popular")
//    @Headers("Authorization: Bearer $AUTH_TOKEN")
//    suspend fun getMoviesFlow(): Flow<List<Movie>>
}