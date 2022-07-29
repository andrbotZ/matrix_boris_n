package com.example.matrix_boris_n.ui.benefits;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matrix_boris_n.R;
import com.example.matrix_boris_n.databinding.FragmentBenefitsBinding;

public class BenefitsFragment extends Fragment {

    private FragmentBenefitsBinding binding;

    public BenefitsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBenefitsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}