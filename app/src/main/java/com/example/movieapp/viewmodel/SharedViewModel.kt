package com.example.movieapp.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.models.Movie
import com.example.movieapp.data.repo.local.MovieRepo
import com.example.movieapp.data.repo.remote.MovieApiRepo
import com.example.movieapp.utils.RequestState
import com.example.movieapp.utils.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val movieRepo: MovieRepo,
//    private val movieApiRepo: MovieApiRepo
) : ViewModel() {

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf("")

//    private suspend fun remoteMovies(page: Int) = movieApiRepo.getAllMovies(page)

    private val _movies = MutableStateFlow<RequestState<List<Movie>>>(RequestState.Idle)
    val movies: StateFlow<RequestState<List<Movie>>> = _movies

    private val _searchedMovies = MutableStateFlow<RequestState<List<Movie>>>(RequestState.Idle)
    val searchedMovies: StateFlow<RequestState<List<Movie>>> = _searchedMovies

    fun movieById(movieId: Int) = movieRepo.getMovieById(movieId)

    private val _selectedMovie: MutableStateFlow<Movie?> = MutableStateFlow(null)
    val selectedMovie: StateFlow<Movie?> = _selectedMovie

    fun getSelectedMovie(movieId: Int) {
        viewModelScope.launch {
            movieRepo.getMovieById(movieId).collect { movie ->
                _selectedMovie.value = movie
            }
        }
    }

    init {
        getAllMovies()
//        viewModelScope.launch {
//            val res = remoteMovies(1)
//            if (res.isSuccessful) {
//                val maxPages = res.body()!!.total_pages
//                for (num in 1..maxPages) {
//                    val movieList = remoteMovies(num).body()?.results
//                    movieList?.map {
//                        Log.d("SharedViewModel", it.toString())
//                        movieRepo.addMovie(it)
//                    }
//                }
//            }
//        }
    }

    private fun getAllMovies() {
        _movies.value = RequestState.Loading
        try {
            viewModelScope.launch {
                movieRepo.allMovies.collect {
                    _movies.value = RequestState.Success(it)
                }
            }
        } catch (err: Exception) {
            _movies.value = RequestState.Error(err)
        }

    }

    fun searchDatabase(searchQuery: String) {
        _searchedMovies.value = RequestState.Loading
        try {
            viewModelScope.launch {
                movieRepo.searchMovies("%$searchQuery%").collect {
                    _searchedMovies.value = RequestState.Success(it)
                }
            }
        } catch (err: Exception) {
            _searchedMovies.value = RequestState.Error(err)
        }
        searchAppBarState.value = SearchAppBarState.TRIGGERED
    }
}