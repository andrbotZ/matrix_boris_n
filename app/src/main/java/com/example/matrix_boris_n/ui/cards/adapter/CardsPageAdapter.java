package com.example.matrix_boris_n.ui.cards.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.matrix_boris_n.ui.card.CardFragment;

public class CardsPageAdapter extends FragmentStateAdapter {
    public CardsPageAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new CardFragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
