package com.example.matrix_boris_n.ui.welcome;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matrix_boris_n.databinding.FragmentWelcomeBinding;
import com.example.matrix_boris_n.factory.ViewModelFactory;
import com.example.matrix_boris_n.ui.welcome.viewmodel.WelcomeViewModel;

public class WelcomeFragment extends Fragment {

    private FragmentWelcomeBinding binding;
    private WelcomeViewModel viewModel;

    public WelcomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this, ViewModelFactory.getInstance(requireActivity().getApplication())).get(WelcomeViewModel.class);
        viewModel.isRemoteDataReady.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isReady) {
               if(isReady){
                   binding.loading.cancelAnimation();
               }
            }
        });
        viewModel.fetchRemoteData();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}