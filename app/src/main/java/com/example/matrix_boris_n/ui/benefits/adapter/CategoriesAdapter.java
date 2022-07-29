package com.example.matrix_boris_n.ui.benefits.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matrix_boris_n.R;
import com.example.matrix_boris_n.models.DataListCat;
import com.example.matrix_boris_n.models.DataListObject;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private List<DataListCat> categories = new ArrayList<>();
    private List<DataListObject> elements = new ArrayList<>();

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_view_holder_layout, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        if(!categories.isEmpty()){
            for (DataListCat cat: categories) {
                if(cat.catId == position + 1){
                    holder.bind(cat.cTitle);
                    break;
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void setCategories(List<DataListCat> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    public void setElements(List<DataListObject> elements) {
        this.elements = elements;
        notifyDataSetChanged();
    }
}
