package com.example.movieapp.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import com.example.movieapp.utils.Constants.LIST_SCREEN
import com.example.movieapp.view.ui.screens.SplashScreen
import com.example.movieapp.view.ui.screens.list.ListScreen
import com.example.movieapp.viewmodel.SharedViewModel
import com.google.accompanist.navigation.animation.composable

@ExperimentalMaterial3Api
@ExperimentalAnimationApi
fun NavGraphBuilder.listComposable(
    navigateToMovieScreen: (movieId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        exitTransition = {
            slideOutHorizontally(
                animationSpec = tween(300),
                targetOffsetX = { fullHeight -> -fullHeight }
            )
        }
    ) {
        ListScreen(navigateToMovieScreen, sharedViewModel)
    }
}