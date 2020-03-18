package com.example.pruebarecyclerhorizontal.ui.adapter.viewholder;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pruebarecyclerhorizontal.R;
import com.example.pruebarecyclerhorizontal.model.Movie;
import com.example.pruebarecyclerhorizontal.ui.adapter.MovieAdapter;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private final View parent;
    private final TextView textView;
    private final ImageView imageView;

    public MovieViewHolder(@NonNull View itemView, int width) {
        super(itemView);
        parent = itemView;
        textView = itemView.findViewById(R.id.child_textView);
        imageView = itemView.findViewById(R.id.child_imageView);
        ((ConstraintLayout.LayoutParams) imageView.getLayoutParams()).width = width;
    }

    public void bind(final Movie movie, final MovieAdapter.OnMovieClickedListener listener) {
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onMovieClicked(movie);
            }
        });
        textView.setText(movie.getName());
        imageView.setImageDrawable(new ColorDrawable(movie.getColor()));
    }
}
