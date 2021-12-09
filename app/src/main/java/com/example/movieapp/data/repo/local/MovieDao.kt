package com.example.movieapp.data.repo.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapp.data.models.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_table ORDER BY id ASC")
    fun getAllMovies(): Flow<List<Movie>>

    @Query("SELECT * FROM movie_table WHERE id=:movieId")
    fun getSelectedMovie(movieId: Int): Flow<Movie>

    @Query("SELECT * FROM movie_table WHERE title LIKE :searchQuery OR overview LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovie(movie: Movie)
}