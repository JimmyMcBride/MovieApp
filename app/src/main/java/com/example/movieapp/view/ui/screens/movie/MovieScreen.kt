package com.example.movieapp.view.ui.screens.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.movieapp.viewmodel.SharedViewModel

@ExperimentalMaterial3Api
@Composable
fun MovieScreen(
    navigateToListScreen: () -> Unit,
    sharedViewModel: SharedViewModel
) {
    Scaffold(
        topBar = {
            MovieAppBar(
                navigateToListScreen
            )
        },
        content = {
            MovieDetailsContent(navigateToListScreen)
        }
    )

}

@Composable
fun MovieDetailsContent(
    navigateToListScreen: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Movie Screen",
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                fontWeight = FontWeight.Bold
            )
        }

    }
}
