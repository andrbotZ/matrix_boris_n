package com.example.matrix_boris_n.ui.welcome.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.matrix_boris_n.interfaces.OnDataChangeListener;
import com.example.matrix_boris_n.interfaces.Repository;
import com.example.matrix_boris_n.models.DataObject;
import com.example.matrix_boris_n.ui.welcome.repository.WelcomeRepository;

public class WelcomeViewModel  extends AndroidViewModel implements OnDataChangeListener<DataObject> {

     @NonNull
    private final Repository<DataObject> repository = new WelcomeRepository(getApplication().getApplicationContext());

    public final MutableLiveData<DataObject> data = new MutableLiveData<>();

    public WelcomeViewModel(@NonNull Application application) {
        super(application);
        repository.addListener(this);
    }

    public void fetchRemoteData() {
       repository.fetchData("local_data.json");
    }


    @Override
    public void onDataChange(DataObject data) {
        if(data != null){
            this.data.setValue(data);
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        repository.removeListener(this);
    }
}
