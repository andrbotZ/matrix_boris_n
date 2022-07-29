package com.example.matrix_boris_n.ui.welcome;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.matrix_boris_n.models.CatalogItem;

import java.util.List;

public class WelcomeViewModel  extends ViewModel {

    private MutableLiveData<List<CatalogItem>> catalogList = new MutableLiveData<>();


    public void fetchRemoteData() {

    }

    public MutableLiveData<List<CatalogItem>> getCatalog() {
        return catalogList;
    }
}
