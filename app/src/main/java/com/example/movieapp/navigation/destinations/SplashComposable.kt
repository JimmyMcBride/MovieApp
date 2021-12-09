package com.example.movieapp.navigation.destinations

import android.window.SplashScreen
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import com.example.movieapp.utils.Constants.SPLASH_SCREEN
import com.example.movieapp.view.ui.screens.SplashScreen
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit
) {
    composable(
        route = SPLASH_SCREEN,
        exitTransition = {
            slideOutVertically(
                animationSpec = tween(300),
                targetOffsetY = { fullHeight -> -fullHeight }
            )
        }
    ) {
        SplashScreen(navigateToListScreen)
    }
}
