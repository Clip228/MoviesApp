package com.example.moviesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TrailersAdapter extends RecyclerView.Adapter<TrailersAdapter.TrailersHolder> {

    private List<Trailer> trailerList = new ArrayList();
    private OnTrailerClickListener onTrailerClickListener;

    public void setOnTrailerClickListener(OnTrailerClickListener onTrailerClickListener) {
        this.onTrailerClickListener = onTrailerClickListener;
    }

    public void setTrailerList(List<Trailer> trailerList) {
        this.trailerList = trailerList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TrailersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.trailers_item,
                parent,
                false
        );
        return new TrailersHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailersHolder holder, int position) {
        Trailer trailer = trailerList.get(position);
        holder.textViewTittle.setText(trailer.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onTrailerClickListener != null){
                    onTrailerClickListener.onTrailerClick(trailer);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return trailerList.size();
    }

    public static class TrailersHolder extends RecyclerView.ViewHolder {
        private final TextView textViewTittle;
        public TrailersHolder(@NonNull View itemView) {
            super(itemView);
            textViewTittle = itemView.findViewById(R.id.textViewTrailersTittle);
        }
    }
    interface OnTrailerClickListener{
        void onTrailerClick(Trailer trailer);
    }
}
