package com.example.matrix_boris_n.ui.benefits;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matrix_boris_n.R;
import com.example.matrix_boris_n.databinding.FragmentBenefitsBinding;
import com.example.matrix_boris_n.factory.ViewModelFactory;
import com.example.matrix_boris_n.models.DataListCat;
import com.example.matrix_boris_n.ui.benefits.adapter.CategoriesAdapter;
import com.example.matrix_boris_n.ui.benefits.viewmodel.BenefitsViewModel;
import com.example.matrix_boris_n.ui.welcome.viewmodel.WelcomeViewModel;

import java.util.List;

public class BenefitsFragment extends Fragment {

    private FragmentBenefitsBinding binding;
    private BenefitsViewModel viewModel;
    private CategoriesAdapter adapter = new CategoriesAdapter();;

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this, ViewModelFactory.getInstance(requireActivity().getApplication())).get(BenefitsViewModel.class);
        binding.categories.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.categories.setAdapter(adapter);
        viewModel.categories.observe(getViewLifecycleOwner(), categories -> adapter.setCategories(categories));
        viewModel.elements.observe(getViewLifecycleOwner(), elements -> adapter.setElements(elements));

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}