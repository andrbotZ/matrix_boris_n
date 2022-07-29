package com.example.matrix_boris_n.ui.benefits.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.matrix_boris_n.models.DataListCat;
import com.example.matrix_boris_n.models.DataListObject;

import java.util.List;

public class BenefitsViewModel extends AndroidViewModel {
    public MutableLiveData<List<DataListCat>> categories = new MutableLiveData<>();
    public MutableLiveData<List<DataListObject>> elements= new MutableLiveData<>();

    public BenefitsViewModel(@NonNull Application application) {
        super(application);
    }

    public void setCategories(List<DataListCat> categories) {
        this.categories.setValue(categories);
    }

    public void setElements(List<DataListObject> elements) {
        this.elements.setValue(elements);
    }
}
