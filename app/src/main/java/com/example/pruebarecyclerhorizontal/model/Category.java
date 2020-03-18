package com.example.pruebarecyclerhorizontal.model;

import java.util.List;

public class Category {

    private final String name;
    private final List<Movie> movies;

    public Category(String name, List<Movie> movies) {
        this.name = name;
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
