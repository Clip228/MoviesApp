package com.example.moviesapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewHolder> {
    private List<Review> reviewList = new ArrayList();

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.review_item,
                parent,
                false
        );
        return new ReviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewHolder holder, int position) {
        int background = R.color.purple_200;
        Review review = reviewList.get(position);
        holder.textViewAuthor.setText(review.getAuthor());
        holder.textViewReview.setText(review.getReview());
        if (review.getType().equals("Позитивный")){
            background = R.color.positive;
        }else if (review.getType().equals("Нейтральный")){
            background = R.color.neutral;
        }else {
            background = R.color.negative;
        }
        int color = ContextCompat.getColor(holder.itemView.getContext(), background);
        holder.itemView.setBackgroundColor(color);
        Log.d("MyLog", review.getType());
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    public static class ReviewHolder extends RecyclerView.ViewHolder{
        private TextView textViewAuthor;
        private TextView textViewReview;
        public ReviewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAuthor = itemView.findViewById(R.id.textViewNameAuthor);
            textViewReview = itemView.findViewById(R.id.textViewReview);
        }
    }
}
