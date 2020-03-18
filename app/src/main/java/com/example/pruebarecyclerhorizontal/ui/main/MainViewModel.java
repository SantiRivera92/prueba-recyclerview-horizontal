package com.example.pruebarecyclerhorizontal.ui.main;

import android.graphics.Color;

import com.example.pruebarecyclerhorizontal.model.Category;
import com.example.pruebarecyclerhorizontal.model.Movie;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<Category>> categories;

    public LiveData<List<Category>> getCategories() {
        if (categories == null) {
            categories = new MutableLiveData<>();
            loadCategories();
        }
        return categories;
    }

    private void loadCategories() {
        List<Category> categories = new ArrayList<Category>();
        for (int e = 0; e < 5; e++) {
            String category = "Category " + (e + 1);
            List<Movie> movies = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                int colorKey = 255 / (i + 2);
                int color = Color.argb(255, colorKey, colorKey, colorKey);
                String movie = "Movie " + ((e * 10) + i + 1);
                movies.add(new Movie(movie, color));
            }
            categories.add(new Category(category, movies));
        }
        this.categories.postValue(categories);
    }
}
