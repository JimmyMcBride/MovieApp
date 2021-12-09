package com.example.movieapp.di

import android.content.Context
import androidx.room.Room
import com.example.movieapp.data.repo.local.MovieDatabase
import com.example.movieapp.data.repo.remote.MovieApiService
import com.example.movieapp.utils.Constants.BASE_URL
import com.example.movieapp.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        MovieDatabase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideDao(database: MovieDatabase) = database.movieDao()

    @Singleton
    @Provides
    fun providesRetrofit(): MovieApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(MovieApiService::class.java)
}