package com.example.movieapp.view.ui.screens.list

import android.graphics.BitmapFactory
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.movieapp.R
import com.example.movieapp.data.models.Movie
import com.example.movieapp.utils.Constants.IMAGE_BASE_URL
import com.example.movieapp.utils.RequestState
import com.example.movieapp.utils.SearchAppBarState
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.rememberDrawablePainter

@Composable
fun ListContent(
    allMovies: RequestState<List<Movie>>,
    searchedMovies: RequestState<List<Movie>>,
    navigateToMovieScreen: (movieId: Int) -> Unit,
    searchAppBarState: SearchAppBarState
) {
    if (searchAppBarState == SearchAppBarState.TRIGGERED) {
        if (searchedMovies is RequestState.Success) {
            DisplayMovies(
                movies = searchedMovies.data,
                navigateToMovieScreen
            )
        }
    } else {
        if (allMovies is RequestState.Success) {
            DisplayMovies(movies = allMovies.data, navigateToMovieScreen)
        }
    }
}

@Composable
fun DisplayMovies(
    movies: List<Movie>,
    navigateToMovieScreen: (taskId: Int) -> Unit
) {
    LazyColumn {
        items(
            items = movies,
            key = { task ->
                task.id
            }
        ) { movie ->
            MovieItem(
                movie,
                navigateToMovieScreen
            )
        }
    }
}

@Composable
fun MovieItem(
    movie: Movie,
    navigateToMovieScreen: (taskId: Int) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface,
        shape = RectangleShape,
        shadowElevation = 2.dp,
        onClick = {
            navigateToMovieScreen(movie.id)
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            movie.poster_path?.let { Log.d("MovieItem", it) }
            GlideImage(
                imageModel = "${IMAGE_BASE_URL}${movie.poster_path}",
//                 Crop, Fit, Inside, FillHeight, FillWidth, None
                contentScale = ContentScale.Crop,
//                 shows an image with a circular revealed animation.
                circularReveal = CircularReveal(duration = 250),
//                 shows a placeholder ImageBitmap when loading.
                placeHolder = ImageVector.vectorResource(id = R.drawable.ic_no_image_foreground),
//                 shows an error ImageBitmap when the request failed.
                error = ImageVector.vectorResource(id = R.drawable.ic_no_image_foreground),
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )
//            Image(
//                painter = rememberImagePainter(
//                    data = "${IMAGE_BASE_URL}/wwemzKWzjKYJFfCeiB57q3r4Bcm.png"),
//                contentDescription = "image",
//                modifier = Modifier.width(100.dp).height(100.dp)
//            )
            Column(
                modifier = Modifier
                    .padding(all = 12.dp)
                    .fillMaxWidth()
            ) {

                Text(
                    text = movie.title,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
//                modifier = Modifier.weight(8f)
                )

                Text(
                    text = movie.overview,
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

    }
}

@Composable
@Preview
fun MoviePreview() {
    MovieItem(
        movie = Movie(
            580489,
            "Venom: Let There Be Carnage",
            false,
            "After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady.",
            10424.41F,
            false,
            "/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg",
            "2021-09-30",
            "Venom: Let There Be Carnage",
            "en",
            "/lNyLSOKMMeUPr1RsL4KcRuIXwHt.jpg",
            4087,
            7.2F
        ),
        navigateToMovieScreen = {}
    )
//    GlideImage(
//        imageModel = "${IMAGE_BASE_URL}/wwemzKWzjKYJFfCeiB57q3r4Bcm.png",
////                 Crop, Fit, Inside, FillHeight, FillWidth, None
//        contentScale = ContentScale.Crop,
////                 shows an image with a circular revealed animation.
//        circularReveal = CircularReveal(duration = 250),
////                 shows a placeholder ImageBitmap when loading.
//        placeHolder = BitmapFactory.decodeResource(context),
////                 shows an error ImageBitmap when the request failed.
//        error = ImageBitmap.imageResource(R.drawable.ic_no_image_foreground)
//    )

}
