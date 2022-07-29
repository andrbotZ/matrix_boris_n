package com.example.matrix_boris_n.ui.card;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matrix_boris_n.R;
import com.example.matrix_boris_n.databinding.FragmentCardBinding;
import com.example.matrix_boris_n.databinding.FragmentCardsBinding;
import com.example.matrix_boris_n.executor.AppExecutor;
import com.example.matrix_boris_n.executor.FetchImageCallable;
import com.example.matrix_boris_n.factory.ViewModelFactory;
import com.example.matrix_boris_n.models.DataListCat;
import com.example.matrix_boris_n.models.DataListObject;
import com.example.matrix_boris_n.ui.benefits.viewmodel.BenefitsViewModel;

import java.util.List;

public class CardFragment extends Fragment {

    private FragmentCardBinding binding;
    private BenefitsViewModel viewModel;
    private int element_index = -1;
    private List<DataListCat> categories;
    private AppExecutor executor = new AppExecutor();

    public CardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this, ViewModelFactory.getInstance(requireActivity().getApplication())).get(BenefitsViewModel.class);
        Bundle arg = getArguments();
        if(arg != null){
            element_index = arg.getInt(String.valueOf(R.string.element_index));
        }
        viewModel.categories.observe(getViewLifecycleOwner(), new Observer<List<DataListCat>>() {
            @Override
            public void onChanged(List<DataListCat> dataListCats) {
                categories = dataListCats;
            }
        });
        viewModel.elements.observe(getViewLifecycleOwner(), dataListObjects -> {
            if(!dataListObjects.isEmpty() && element_index > -1){
                DataListObject item = dataListObjects.get(element_index);
                binding.id.setText(String.valueOf(item.id));
                if(!categories.isEmpty()){
                    binding.category.setText(categories.get((int) item.catId).cTitle);
                }

                executor.execute(new FetchImageCallable(dataListObjects.get(element_index).image), new AppExecutor.Callback<Bitmap>() {
                    @Override
                    public void onComplete(Bitmap result) {
                        if (result != null){
                           binding.image.setImageBitmap(result);
                        }
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });

            }

        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}