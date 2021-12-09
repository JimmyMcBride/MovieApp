package com.example.movieapp.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movieapp.utils.Constants.DATABASE_TABLE
import com.squareup.moshi.JsonClass

@Entity(tableName = DATABASE_TABLE)
@JsonClass(generateAdapter = true)
data class Movie(
    @PrimaryKey val id: Int,
    val title: String,
    val adult: Boolean,
    val overview: String,
    val popularity: Float,
    val video: Boolean,
    @ColumnInfo(name = "poster_path") val posterPath: String?,
    @ColumnInfo(name = "release_date") val releaseDate: String?,
//    @ColumnInfo(name = "genre_ids") val genreIds: List<Int>,
    @ColumnInfo(name = "original_title") val originalTitle: String?,
    @ColumnInfo(name = "original_language") val originalLanguage: String?,
    @ColumnInfo(name = "backdrop_path") val backdropPath: String?,
    @ColumnInfo(name = "vote_count") val voteCount: Int?,
    @ColumnInfo(name = "vote_average") val voteAverage: Float?
)
