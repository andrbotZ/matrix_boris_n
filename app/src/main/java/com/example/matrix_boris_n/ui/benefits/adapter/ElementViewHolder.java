package com.example.matrix_boris_n.ui.benefits.adapter;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matrix_boris_n.R;
import com.example.matrix_boris_n.executor.AppExecutor;
import com.example.matrix_boris_n.executor.FetchImageCallable;
import com.example.matrix_boris_n.executor.FetchLocalDataCallable;
import com.example.matrix_boris_n.models.DataListObject;
import com.example.matrix_boris_n.models.DataObject;

public class ElementViewHolder extends RecyclerView.ViewHolder {
    private final ImageView imageView;
    private final TextView titleView;
    private final TextView smalltitleView;


    public ElementViewHolder(@NonNull View itemView) {
        super(itemView);
        titleView = itemView.findViewById(R.id.element_title);
        smalltitleView = itemView.findViewById(R.id.element_stitle);
        imageView = itemView.findViewById(R.id.element_image);
    }

    public void bind(DataListObject element, Bitmap result) {
        titleView.setText(element.title);
        smalltitleView.setText(element.sTitle);
        imageView.setImageBitmap(result);
    }
}
