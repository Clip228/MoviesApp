package com.example.moviesapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

public class FavoriteMoviesViewModel extends AndroidViewModel {
    private MovieDao movieDao;
    public FavoriteMoviesViewModel(@NonNull Application application) {
        super(application);
        movieDao = MovieDataBase.getInstance(getApplication()).movieDao();
    }

    public LiveData<List<Movie>> getFavoriteMovies(){
        return movieDao.getAllFavoriteMovies();
    }
}
