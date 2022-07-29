package com.example.matrix_boris_n.factory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.matrix_boris_n.ui.welcome.viewmodel.WelcomeViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private static volatile ViewModelFactory instance;
    private final Application app;

    private ViewModelFactory(Application app){
        this.app = app;
    }

    public static ViewModelFactory getInstance(Application app){
        if (instance == null){
            instance = new ViewModelFactory(app);
        }
        return instance;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass == WelcomeViewModel.class) return (T) new WelcomeViewModel(app);
        return null;
    }
}
