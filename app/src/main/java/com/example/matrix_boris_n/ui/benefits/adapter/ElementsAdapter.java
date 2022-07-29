package com.example.matrix_boris_n.ui.benefits.adapter;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matrix_boris_n.R;
import com.example.matrix_boris_n.executor.AppExecutor;
import com.example.matrix_boris_n.executor.FetchImageCallable;
import com.example.matrix_boris_n.models.DataListObject;

import java.util.ArrayList;
import java.util.List;

public class ElementsAdapter extends RecyclerView.Adapter<ElementViewHolder> {

    private List<DataListObject> elements = new ArrayList<>();
    private AppExecutor executor = new AppExecutor();

    @NonNull
    @Override
    public ElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_view_holder_layout, parent, false);
        return new ElementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if(elements.size() > position){

            executor.execute(new FetchImageCallable(elements.get(position).image), new AppExecutor.Callback<Bitmap>() {
                @Override
                public void onComplete(Bitmap result) {
                    if (result != null)
                        holder.bind(elements.get(position), result);
                }

                @Override
                public void onError(Exception e) {

                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public void setElements(List<DataListObject> elements) {
        this.elements = elements;
        notifyDataSetChanged();
    }
}
