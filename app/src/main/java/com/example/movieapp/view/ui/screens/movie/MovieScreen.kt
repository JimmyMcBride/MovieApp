package com.example.movieapp.view.ui.screens.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.movieapp.R
import com.example.movieapp.data.models.Movie
import com.example.movieapp.utils.Constants
import com.example.movieapp.viewmodel.SharedViewModel
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@ExperimentalMaterial3Api
@Composable
fun MovieScreen(
    navigateToListScreen: () -> Unit,
    selectedMovie: Movie?
) {
    Scaffold(
        topBar = {
            MovieAppBar(
                navigateToListScreen
            )
        },
        content = {
            MovieDetailsContent(selectedMovie)
        }
    )

}

@Composable
fun MovieDetailsContent(
    selectedMovie: Movie?
//    navigateToListScreen: () -> Unit
) {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(MaterialTheme.colorScheme.background),
//        contentAlignment = Alignment.Center
//    ) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (selectedMovie != null) {
            GlideImage(
                imageModel = "${Constants.IMAGE_BASE_URL}${selectedMovie.poster_path}",
                contentScale = ContentScale.Crop,
                circularReveal = CircularReveal(duration = 250),
                placeHolder = ImageVector.vectorResource(id = R.drawable.ic_no_image_foreground),
                error = ImageVector.vectorResource(id = R.drawable.ic_no_image_foreground),
                modifier = Modifier
                    .width(500.dp)
                    .height(500.dp)
            )
            Text(
                text = selectedMovie.title,
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = selectedMovie.overview,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }

//    }
}
