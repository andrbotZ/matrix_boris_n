package com.example.matrix_boris_n.ui.welcome.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.matrix_boris_n.interfaces.OnDataChangeListener;
import com.example.matrix_boris_n.interfaces.Repository;
import com.example.matrix_boris_n.ui.welcome.repository.WelcomeRepository;

import com.example.matrix_boris_n.models.DataListObject;

import java.util.List;

public class WelcomeViewModel  extends AndroidViewModel implements OnDataChangeListener<List<DataListObject>> {

     @NonNull
    private final Repository<List<DataListObject>> repository = new WelcomeRepository(getApplication().getApplicationContext());

    private final MutableLiveData<List<DataListObject>> catalogList = new MutableLiveData<>();
    public MutableLiveData<Boolean> isRemoteDataReady = new MutableLiveData<>(false);

    public WelcomeViewModel(@NonNull Application application) {
        super(application);
        repository.addListener(this);
    }

    public void fetchRemoteData() {
       repository.fetchData("local_data.json");
    }

    public MutableLiveData<List<DataListObject>> getCatalog() {
        return catalogList;
    }

    @Override
    public void onDataChange(List<DataListObject> data) {
        if(data != null){
            isRemoteDataReady.setValue(true);
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        repository.removeListener(this);
    }
}
