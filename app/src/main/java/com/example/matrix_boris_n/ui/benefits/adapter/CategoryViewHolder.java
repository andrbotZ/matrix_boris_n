package com.example.matrix_boris_n.ui.benefits.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.matrix_boris_n.R;
import com.example.matrix_boris_n.models.DataListObject;

import java.util.List;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private final TextView titleView;
    private final ViewPager2 pager;

    public CategoryViewHolder(@NonNull View itemView, FragmentStateAdapter adapter) {
        super(itemView);
        titleView = itemView.findViewById(R.id.categoryTitle);
        pager = itemView.findViewById(R.id.category_pager);
        pager.setAdapter(adapter);
    }

    public void bind(String title, List<DataListObject> elements) {
        titleView.setText(title);

    }
}
