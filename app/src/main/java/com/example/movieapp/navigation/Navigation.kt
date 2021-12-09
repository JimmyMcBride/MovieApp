package com.example.movieapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.example.movieapp.navigation.destinations.listComposable
import com.example.movieapp.navigation.destinations.movieComposable
import com.example.movieapp.navigation.destinations.splashComposable
import com.example.movieapp.utils.Constants.SPLASH_SCREEN
import com.example.movieapp.viewmodel.SharedViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost

@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController)
    }

    AnimatedNavHost(navController, SPLASH_SCREEN) {
        splashComposable(screen.splash)
        listComposable(screen.list, sharedViewModel)
        movieComposable(screen.movie, sharedViewModel)
    }
}