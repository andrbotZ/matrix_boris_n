package com.example.matrix_boris_n;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.matrix_boris_n.databinding.ActivityMainBinding;
import com.example.matrix_boris_n.factory.ViewModelFactory;
import com.example.matrix_boris_n.ui.cards.CardsFragment;
import com.example.matrix_boris_n.ui.cards.viemodel.CardsViewModel;
import com.example.matrix_boris_n.ui.welcome.viewmodel.WelcomeViewModel;

public class MainActivity extends AppCompatActivity {


    private WelcomeViewModel welcomeViewModel;
    private ActivityMainBinding binding;
    private CardsViewModel cardsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();
        welcomeViewModel = ViewModelFactory.getInstance(getApplication()).create(WelcomeViewModel.class);
        cardsViewModel = ViewModelFactory.getInstance(getApplication()).create(CardsViewModel.class);

        welcomeViewModel.data.observe(this, data -> {
            if (data != null){
                cardsViewModel.setCardsData(data);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new CardsFragment()).commit();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}