package com.example.movieapp.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieResponse(
    val page: String,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int,
)
