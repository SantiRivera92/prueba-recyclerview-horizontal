package com.example.pruebarecyclerhorizontal.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pruebarecyclerhorizontal.R;
import com.example.pruebarecyclerhorizontal.model.Category;
import com.example.pruebarecyclerhorizontal.ui.adapter.viewholder.CategoryViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private final ArrayList<Category> categories = new ArrayList<Category>();
    private final MovieAdapter.OnMovieClickedListener listener;
    private final float itemsToShow;

    public CategoryAdapter(MovieAdapter.OnMovieClickedListener listener, float itemsToShow) {
        this.listener = listener;
        this.itemsToShow = itemsToShow;
    }

    public void clearList() {
        categories.clear();
        notifyDataSetChanged();
    }

    public void addList(List<Category> categories) {
        this.categories.addAll(categories);
        notifyDataSetChanged();
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(v, listener, itemsToShow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bind(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
