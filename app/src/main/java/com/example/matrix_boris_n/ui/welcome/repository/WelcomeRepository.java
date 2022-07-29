package com.example.matrix_boris_n.ui.welcome.repository;

import android.content.Context;
import android.content.res.Resources;

import androidx.annotation.NonNull;

import com.example.matrix_boris_n.R;
import com.example.matrix_boris_n.executor.AppExecutor;
import com.example.matrix_boris_n.executor.FetchLocalDataCallable;
import com.example.matrix_boris_n.interfaces.OnDataChangeListener;
import com.example.matrix_boris_n.interfaces.Repository;
import com.example.matrix_boris_n.models.DataListObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class WelcomeRepository implements Repository<List<DataListObject>> {

    private final Context context;
    private ArrayList<OnDataChangeListener<List<DataListObject>>> listeners = new ArrayList<>();
    private AppExecutor executor = new AppExecutor();

    public WelcomeRepository(Context context) {
        this.context = context;
    }

    @Override
    public void addListener(@NonNull OnDataChangeListener<List<DataListObject>> listener) {
        if(!listeners.contains(listener)){
            listeners.add(listener);
        }
    }

    @Override
    public void removeListener(@NonNull OnDataChangeListener<List<DataListObject>> listener) {
        if(!listeners.contains(listener)){
            listeners.remove(listener);
        }
    }

    @Override
    public void fetchData(String name) {
        try{
            InputStream stream = context.getResources().openRawResource(R.raw.local_data);
            executor.execute(new FetchLocalDataCallable(stream), new AppExecutor.Callback<List<DataListObject>>() {
                @Override
                public void onComplete(List<DataListObject> result) {
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

    private void broadcastToListeners(List<DataListObject> result) {
        if(listeners.size() > 0 && result != null){
            for (OnDataChangeListener<List<DataListObject>> listener:listeners) {
                listener.onDataChange(result);
            }
        }
    }
}
