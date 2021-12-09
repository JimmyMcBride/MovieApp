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
    val poster_path: String?,
    val release_date: String?,
    val original_title: String?,
    val original_language: String?,
    val backdrop_path: String?,
    val vote_count: Int?,
    val vote_average: Float?
)
