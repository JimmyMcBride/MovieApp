package com.example.movieapp.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.movieapp.utils.Constants.MOVIE_ARGUMENT_KEY
import com.example.movieapp.utils.Constants.MOVIE_SCREEN
import com.example.movieapp.view.ui.screens.movie.MovieScreen
import com.example.movieapp.viewmodel.SharedViewModel
import com.google.accompanist.navigation.animation.composable

@ExperimentalMaterial3Api
@ExperimentalAnimationApi
fun NavGraphBuilder.movieComposable(
    navigateToListScreen: () -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = MOVIE_SCREEN,
        listOf(navArgument(MOVIE_ARGUMENT_KEY) {
            type = NavType.IntType
        }),
        exitTransition = {
            slideOutHorizontally(
                animationSpec = tween(300),
                targetOffsetX = { fullHeight -> fullHeight }
            )
        }
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(MOVIE_ARGUMENT_KEY)

//        val selectedMovie by sharedViewModel.selectedMovie.collectAsState()

//        LaunchedEffect(key1 = taskId) {
//            sharedViewModel.getSelectedMovie(taskId)
//        }

        MovieScreen(navigateToListScreen, sharedViewModel)
    }
}
