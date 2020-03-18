package com.example.pruebarecyclerhorizontal.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pruebarecyclerhorizontal.R;
import com.example.pruebarecyclerhorizontal.model.Category;
import com.example.pruebarecyclerhorizontal.model.Movie;
import com.example.pruebarecyclerhorizontal.ui.adapter.CategoryAdapter;
import com.example.pruebarecyclerhorizontal.ui.adapter.MovieAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

public class MainFragment extends Fragment implements MovieAdapter.OnMovieClickedListener {

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    private MainViewModel mViewModel;
    private RecyclerView recyclerView;
    private CategoryAdapter adapter;

    private int usableWidth;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        // Posted as runnable so we can get the width.
        view.post(new Runnable() {
            @Override
            public void run() {
                float gridItems = Float.valueOf(getResources().getString(R.string.grid_items));
                usableWidth = view.getWidth();
                adapter = new CategoryAdapter(MainFragment.this, gridItems);
                recyclerView.setAdapter(adapter);
                if (mViewModel == null) {
                    mViewModel = new ViewModelProvider(MainFragment.this).get(MainViewModel.class);
                }
                mViewModel.getCategories().observe(getViewLifecycleOwner(), new Observer<List<Category>>() {
                    @Override
                    public void onChanged(List<Category> categories) {
                        adapter.addList(categories);
                    }
                });
            }
        });

    }

    @Override
    public void onMovieClicked(Movie movie) {
        Snackbar.make(recyclerView, movie.getName(), Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public int getItemSize(double itemsToShow) {
        int width = usableWidth;
        // We are going to have N margins of 16 dip, where N is the absolute value of itemsToShow. For that we are just going to cast that to an integer.
        int marginsToShow = (int) (itemsToShow);
        int marginsInDIP = marginsToShow * 16;
        // Now that we have the value of the margins in DIP, time to convert to pixels
        int marginsInPixels = (int) (marginsInDIP * getResources().getDisplayMetrics().density + 0.5f);
        // Now that we have the margins, we are going to remove that from the width we can use
        width -= marginsInPixels;
        // Now we only have to divide the usable width by the number of items we want to show
        int itemWidth = (int) (width / itemsToShow);
        // Voilá
        return itemWidth;
    }


}
