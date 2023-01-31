package com.example.moviesapp;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie?token=TFMCQKC-5YGM5VG-G0W9TXP-KJDNVJZ&sortField=votes.kp&sortType=-1&field=rating.kp&search=7-10&limit=30")
    Single<MovieResponse> loadMovie(@Query("page") int page);

    @GET("movie?token=TFMCQKC-5YGM5VG-G0W9TXP-KJDNVJZ&field=id&")
    Single<TrailerResponse> loadTrailers(@Query("search") int id);
    @GET("review?field=movieId&token=TFMCQKC-5YGM5VG-G0W9TXP-KJDNVJZ")
    Single<ReviewResponse> loadReview(@Query("search") int id);
}
