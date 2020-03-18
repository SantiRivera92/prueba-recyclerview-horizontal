package com.example.pruebarecyclerhorizontal.ui.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import com.example.pruebarecyclerhorizontal.R;
import com.example.pruebarecyclerhorizontal.model.Category;
import com.example.pruebarecyclerhorizontal.ui.adapter.MovieAdapter;
import com.example.pruebarecyclerhorizontal.ui.widget.MovieDecorator;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    private final TextView textView;
    private final RecyclerView recyclerView;

    private final MovieAdapter.OnMovieClickedListener listener;
    private final float itemsToShow;

    public CategoryViewHolder(@NonNull View itemView, MovieAdapter.OnMovieClickedListener onMovieClickedListener, float itemsToShow) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
        recyclerView = itemView.findViewById(R.id.innerRecyclerView);
        this.listener = onMovieClickedListener;
        this.itemsToShow = itemsToShow;
    }

    public void bind(Category category) {
        textView.setText(category.getName());
        MovieAdapter adapter = new MovieAdapter(listener, itemsToShow);
        adapter.addList(category.getMovies());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new MovieDecorator());
    }

}
