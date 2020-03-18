package com.example.pruebarecyclerhorizontal.model;

public class Movie {

    private final String name;
    private final int color;

    public Movie(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
