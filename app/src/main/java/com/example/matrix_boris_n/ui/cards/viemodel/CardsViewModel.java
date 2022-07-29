package com.example.matrix_boris_n.ui.cards.viemodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.matrix_boris_n.models.DataListObject;

import java.util.ArrayList;
import java.util.List;

public class CardsViewModel extends AndroidViewModel {
    private List<DataListObject> data = new ArrayList<>();

    public CardsViewModel(@NonNull Application application) {
        super(application);
    }

    public void setCardsData(List<DataListObject> data) {
        this.data = data;
    }
}
