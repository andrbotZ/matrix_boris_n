package com.example.matrix_boris_n.ui.welcome.repository;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import com.example.matrix_boris_n.R;
import com.example.matrix_boris_n.executor.AppExecutor;
import com.example.matrix_boris_n.executor.FetchImagesCallable;
import com.example.matrix_boris_n.executor.FetchLocalDataCallable;
import com.example.matrix_boris_n.interfaces.OnDataChangeListener;
import com.example.matrix_boris_n.interfaces.Repository;
import com.example.matrix_boris_n.models.DataListObject;
import com.example.matrix_boris_n.models.DataObject;

import java.io.InputStream;
import java.util.ArrayList;

public class WelcomeRepository implements Repository<DataObject> {

    private final Context context;
    private ArrayList<OnDataChangeListener<DataObject>> listeners = new ArrayList<>();
    private AppExecutor executor = new AppExecutor();

    public WelcomeRepository(Context context) {
        this.context = context;
    }

    @Override
    public void addListener(@NonNull OnDataChangeListener<DataObject> listener) {
        if(!listeners.contains(listener)){
            listeners.add(listener);
        }
    }

    @Override
    public void removeListener(@NonNull OnDataChangeListener<DataObject> listener) {
        if(!listeners.contains(listener)){
            listeners.remove(listener);
        }
    }

    @Override
    public void fetchData(String name) {
        try{
            InputStream stream = context.getResources().openRawResource(R.raw.local_data);
            executor.execute(new FetchLocalDataCallable(stream), new AppExecutor.Callback<DataObject>() {
                @Override
                public void onComplete(DataObject result) {

                    downloadImages(result);

                }

                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                }
            });



        }catch (Resources.NotFoundException ex){
            ex.printStackTrace();
        }
    }

    private void downloadImages(DataObject data) {
        if (!data.elements.isEmpty()) {
            executor.execute(new FetchImagesCallable(data), new AppExecutor.Callback<DataObject>() {
                    @Override
                    public void onComplete(DataObject result) {
                        if (result != null)
                            broadcastToListeners(result);

                    }
                    @Override
                    public void onError(Exception e) {
                        e.printStackTrace();
                    }
                });
        }
    }

    private void broadcastToListeners(DataObject result) {
        if(listeners.size() > 0 && result != null){
            for (OnDataChangeListener<DataObject> listener:listeners) {
                listener.onDataChange(result);
            }
        }
    }
}
