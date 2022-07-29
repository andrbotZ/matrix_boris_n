package com.example.matrix_boris_n.factory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.matrix_boris_n.ui.cards.viemodel.CardsViewModel;
import com.example.matrix_boris_n.ui.welcome.viewmodel.WelcomeViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private static volatile ViewModelFactory instance;
    private final Application app;

    private ViewModelFactory(Application app){
        this.app = app;
    }
    HashMap<String,ViewModel> viewModels = new HashMap<>();

    public static ViewModelFactory getInstance(Application app){
        if (instance == null){
            instance = new ViewModelFactory(app);
        }
        return instance;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        try {

            if (!viewModels.containsKey(modelClass.getSimpleName())){
                switch (modelClass.getSimpleName()){
                    case"WelcomeViewModel":
                         ViewModel wvm = new WelcomeViewModel(app);
                        viewModels.put(WelcomeViewModel.class.getSimpleName(), wvm);
                        break;
                    case"CardsViewModel":
                        ViewModel cvm = new CardsViewModel(app);
                        viewModels.put(CardsViewModel.class.getSimpleName(), cvm);
                        break;
                }
            }
            return (T) viewModels.get(modelClass.getSimpleName());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
