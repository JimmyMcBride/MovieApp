package com.example.movieapp.data.repo.remote

import com.example.movieapp.data.models.MovieResponse
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Response
import javax.inject.Inject

@ViewModelScoped
class MovieApiRepo @Inject constructor(
    private val movieApiService: MovieApiService
) {
    suspend fun getAllMovies(page: Int): Response<MovieResponse> {
        return movieApiService.getMovies(page)
    }
}