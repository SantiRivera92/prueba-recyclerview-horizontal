package com.example.pruebarecyclerhorizontal.ui.adapter;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pruebarecyclerhorizontal.R;
import com.example.pruebarecyclerhorizontal.model.Movie;
import com.example.pruebarecyclerhorizontal.ui.adapter.viewholder.MovieViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {


    public interface OnMovieClickedListener {
        void onMovieClicked(Movie movie);

        int getItemSize(double itemsToShow);
    }

    private final ArrayList<Movie> movies = new ArrayList<Movie>();
    private final OnMovieClickedListener listener;
    private final int itemSize;

    public MovieAdapter(OnMovieClickedListener listener, float itemsToShow) {
        this.listener = listener;
        this.itemSize = listener.getItemSize(itemsToShow);
    }

    public void clearList() {
        movies.clear();
        notifyDataSetChanged();
    }

    public void addList(List<Movie> movies) {
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(v, itemSize);
    }



    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(movies.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
