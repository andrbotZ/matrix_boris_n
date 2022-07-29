package com.example.matrix_boris_n.ui.benefits.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matrix_boris_n.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private final TextView titleView;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
       titleView = itemView.findViewById(R.id.categoryTitle);
    }

    public void bind(String title) {
        titleView.setText(title);
    }
}
