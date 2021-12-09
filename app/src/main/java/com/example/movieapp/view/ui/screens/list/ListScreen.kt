package com.example.movieapp.view.ui.screens.list

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
//        floatingActionButton = {
//            FloatingActionButton(onClick = {
//                navigateToMovieScreen(1)
//            }) {
//                Icon(imageVector = Icons.Filled.Add, contentDescription = "FAB")
//            }
//        }
    )
}
