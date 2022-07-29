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
    public OnElementCLickListener onElementCLickListener;

    @NonNull
    @Override
    public ElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_view_holder_layout, parent, false);
        return new ElementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if(elements.size() > position){

            holder.bind(elements.get(position));
            holder.itemView.setOnClickListener(v -> {

                if (onElementCLickListener != null){
                    onElementCLickListener.onClick(v, position);
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
    public interface OnElementCLickListener {
        void onClick(View view, int index);
    }
}


