package com.example.moviesapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM favorite_movies")
    LiveData<List<Movie>> getAllFavoriteMovies();

    @Query("SELECT * FROM favorite_movies WHERE id = :id")
    LiveData<Movie> getFavoriteMovie(int id);

    @Insert
    Completable insertMovie(Movie movie);

    @Query("DELETE FROM favorite_movies WHERE id = :id")
    Completable removeMovie(int id);
}
