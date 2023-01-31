package com.example.moviesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;

public class FavoriteMoviesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MoviesAdapter adapter;
    private FavoriteMoviesViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_movies);
        viewModel = new ViewModelProvider(this).get(FavoriteMoviesViewModel.class);
        initViews();
        adapter = new MoviesAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        viewModel.getFavoriteMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                adapter.setMovies(movies);
            }
        });
        adapter.setListener(new MoviesAdapter.Listener() {
            @Override
            public void onClick(Movie movie) {
                Intent intent = MovieDetailActivity.newIntent(FavoriteMoviesActivity.this, movie);
                startActivity(intent);
            }
        });
    }
    private void initViews(){
        recyclerView = findViewById(R.id.recyclerViewFavoriteMovies);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, FavoriteMoviesActivity.class);
    }
}