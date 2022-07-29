package com.example.matrix_boris_n.ui.favorits;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matrix_boris_n.R;
import com.example.matrix_boris_n.databinding.FragmentBenefitsBinding;
import com.example.matrix_boris_n.databinding.FragmentFavoritsBinding;
import com.example.matrix_boris_n.factory.ViewModelFactory;
import com.example.matrix_boris_n.ui.benefits.adapter.CategoriesAdapter;
import com.example.matrix_boris_n.ui.benefits.adapter.ElementsAdapter;
import com.example.matrix_boris_n.ui.benefits.viewmodel.BenefitsViewModel;
import com.example.matrix_boris_n.ui.card.CardFragment;

public class FavoritesFragment extends Fragment implements ElementsAdapter.OnElementCLickListener {

    private FragmentFavoritsBinding binding;

    private BenefitsViewModel viewModel;
    private CategoriesAdapter adapter;
    public FavoritesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavoritsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this, ViewModelFactory.getInstance(requireActivity().getApplication())).get(BenefitsViewModel.class);
        binding.categories.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new CategoriesAdapter();
        adapter.onElementCLickListener = this;
        binding.categories.setAdapter(adapter);
        viewModel.categories.observe(getViewLifecycleOwner(), categories -> adapter.setCategories(categories));
        viewModel.elements.observe(getViewLifecycleOwner(), elements -> adapter.setElements(elements));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public void onClick(View view, int index) {
        Bundle bundle = new Bundle();
        bundle.putInt(String.valueOf(R.string.element_index), index );
        requireActivity().getSupportFragmentManager().beginTransaction().addToBackStack("t").setReorderingAllowed(true).replace(R.id.fragmentContainerView, CardFragment.class, bundle).commit();
    }
}