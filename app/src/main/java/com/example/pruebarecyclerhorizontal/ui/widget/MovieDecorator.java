package com.example.pruebarecyclerhorizontal.ui.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieDecorator extends RecyclerView.ItemDecoration {
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int sixDIP = (int) (6 * view.getResources().getDisplayMetrics().density + 0.5f);
        outRect.left = sixDIP;
        outRect.right = sixDIP;
        int position = parent.getChildAdapterPosition(view);

        Log.d("Position", String.valueOf(position));
        Log.d("Count", String.valueOf(parent.getChildCount()));

        if (position == 0) {
            outRect.left = 2 * sixDIP;
        }
        if (position == parent.getAdapter().getItemCount() - 1) {
            outRect.right = 2 * sixDIP;
        }
    }
}
