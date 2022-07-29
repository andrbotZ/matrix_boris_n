package com.example.matrix_boris_n.ui.welcome.viewmodel;

import android.app.Application;
import android.content.res.Resources;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.matrix_boris_n.interfaces.OnDataChangeListener;
import com.example.matrix_boris_n.interfaces.Repository;
import com.example.matrix_boris_n.ui.welcome.repository.WelcomeRepository;

import com.example.matrix_boris_n.models.CatalogItem;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.Future;

public class WelcomeViewModel  extends AndroidViewModel implements OnDataChangeListener<List<CatalogItem>> {

    private Repository repository = new WelcomeRepository(getApplication().getApplicationContext());

    private MutableLiveData<List<CatalogItem>> catalogList = new MutableLiveData<>();
    public MutableLiveData<Boolean> isRemoteDataReady = new MutableLiveData<>(false);

    public WelcomeViewModel(@NonNull Application application) {
        super(application);
        ((WelcomeRepository)repository).addListener(this);
    }

    public void fetchRemoteData() {
       repository.fetchData("local_data.json");
    }

    public MutableLiveData<List<CatalogItem>> getCatalog() {
        return catalogList;
    }

    @Override
    public void onDataChange(List<CatalogItem> data) {
        if(data != null){
            isRemoteDataReady.setValue(true);
        }
    }
}
