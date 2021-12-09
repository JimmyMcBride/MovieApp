package com.example.movieapp.view.ui.screens.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.movieapp.data.models.Movie
import com.example.movieapp.utils.RequestState
import com.example.movieapp.utils.SearchAppBarState
import com.example.movieapp.viewmodel.SharedViewModel

@ExperimentalMaterial3Api
@Composable
fun ListScreen(
    navigateToMovieScreen: (movieId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    val allMovies = sharedViewModel.movies.collectAsState()
    val searchedMovies = sharedViewModel.searchedMovies.collectAsState()

    val searchAppBarState: SearchAppBarState by sharedViewModel.searchAppBarState
    val searchTextState: String by sharedViewModel.searchTextState

    Scaffold(
        topBar = {
            ListAppBar(
                sharedViewModel,
                searchAppBarState,
                searchTextState
            )
        },
        content = {
            ListContent(
                allMovies = allMovies.value,
                searchedMovies = searchedMovies.value,
                navigateToMovieScreen,
                searchAppBarState,
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navigateToMovieScreen(1)
            }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "FAB")
            }
        }
    )
}

@Composable
fun ListContent(
    allMovies: RequestState<List<Movie>>,
    searchedMovies: RequestState<List<Movie>>,
    navigateToTaskScreen: (movieId: Int) -> Unit,
    searchAppBarState: SearchAppBarState
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "List Screen",
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

    }
}
