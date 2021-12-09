package com.example.movieapp.navigation

import androidx.navigation.NavController
import com.example.movieapp.utils.Constants.LIST_SCREEN
import com.example.movieapp.utils.Constants.SPLASH_SCREEN

class Screens(navController: NavController) {
    val splash: () -> Unit = {
        navController.navigate(route = "list") {
            popUpTo(SPLASH_SCREEN) { inclusive = true }
        }
    }
    val list: (Int) -> Unit = { movieId ->
        navController.navigate("movie/$movieId")
    }
    val movie: () -> Unit = {
        navController.navigate("list") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
}