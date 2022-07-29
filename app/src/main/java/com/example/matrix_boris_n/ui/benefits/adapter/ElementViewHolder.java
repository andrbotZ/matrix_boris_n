package com.example.matrix_boris_n.ui.benefits.adapter;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

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
    private AppExecutor executor = new AppExecutor();

    public ElementViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.element_image);
    }

    public void bind(DataListObject element) {
        executor.execute(new FetchImageCallable(element.image), new AppExecutor.Callback<Bitmap>() {
            @Override
            public void onComplete(Bitmap result) {
                imageView.setImageBitmap(result);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
