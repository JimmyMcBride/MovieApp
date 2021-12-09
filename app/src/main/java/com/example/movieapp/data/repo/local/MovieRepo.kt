package com.example.movieapp.data.repo.local

import com.example.movieapp.data.models.Movie
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class MovieRepo @Inject constructor(private val movieDao: MovieDao) {
    val allMovies = movieDao.getAllMovies()
    fun searchMovies(searchText: String) = movieDao.searchDatabase(searchText)
    fun getMovieById(movieId: Int) = movieDao.getSelectedMovie(movieId)
    suspend fun addMovie(movie: Movie) = movieDao.addMovie(movie)
}