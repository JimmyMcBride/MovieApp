package com.example.movieapp.data.repo.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapp.data.models.Movie

@Database(
    entities = [Movie::class],
    version = 2,
    exportSchema = false
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
