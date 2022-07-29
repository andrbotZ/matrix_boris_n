package com.example.matrix_boris_n.ui.welcome.repository;

import android.content.Context;
import android.content.res.Resources;

import androidx.annotation.NonNull;

import com.example.matrix_boris_n.executor.AppExecutor;
import com.example.matrix_boris_n.executor.FetchLocalDataCallable;
import com.example.matrix_boris_n.interfaces.OnDataChangeListener;
import com.example.matrix_boris_n.interfaces.Repository;
import com.example.matrix_boris_n.models.CatalogItem;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class WelcomeRepository implements Repository<List<CatalogItem>> {

    private final Context context;
    private ArrayList<OnDataChangeListener<List<CatalogItem>>> listeners = new ArrayList<>();
    private AppExecutor executor = new AppExecutor();

    public WelcomeRepository(Context context) {
        this.context = context;
    }

    @Override
    public void addListener(@NonNull OnDataChangeListener<List<CatalogItem>> listener) {
        if(!listeners.contains(listener)){
            listeners.add(listener);
        }
    }

    @Override
    public void removeListener(@NonNull OnDataChangeListener<List<CatalogItem>> listener) {
        if(!listeners.contains(listener)){
            listeners.remove(listener);
        }
    }

    @Override
    public void fetchData(String name) {
        try{
            int file_identifier = context.getResources().getIdentifier(name, "raw", context.getPackageName());
            InputStream stream = context.getResources().openRawResource(file_identifier);
            executor.execute(new FetchLocalDataCallable(stream), new AppExecutor.Callback<List<CatalogItem>>() {
                @Override
                public void onComplete(List<CatalogItem> result) {
                    broadcastToListeners(result);
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

    private void broadcastToListeners(List<CatalogItem> result) {
        if(listeners.size() > 0 && result != null){
            for (OnDataChangeListener<List<CatalogItem>> listener:listeners) {
                listener.onDataChange(result);
            }
        }
    }
}
