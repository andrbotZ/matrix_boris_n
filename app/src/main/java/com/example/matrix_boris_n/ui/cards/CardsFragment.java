package com.example.matrix_boris_n.ui.cards;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.matrix_boris_n.R;
import com.example.matrix_boris_n.databinding.FragmentCardsBinding;
import com.example.matrix_boris_n.ui.cards.adapter.CardsPageAdapter;
import com.example.matrix_boris_n.utility.Constants;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CardsFragment extends Fragment {


    private FragmentCardsBinding binding;
    private RecyclerView.Adapter pageAdapter;

    public CardsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCardsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pageAdapter = new CardsPageAdapter(this);
        binding.cardsPager.setAdapter(pageAdapter);
        new TabLayoutMediator(binding.tabLayout, binding.cardsPager, (tab, position) -> {
            tab.setText(Constants.tabNames.get(Constants.tabNames.size() - position - 1));

        }).attach();

        binding.cardsPager.setUserInputEnabled(false);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
