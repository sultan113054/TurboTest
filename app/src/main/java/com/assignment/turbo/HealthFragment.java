package com.assignment.turbo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.assignment.turbo.databinding.FragmentHealthBinding;

import java.util.ArrayList;
import java.util.List;


public class HealthFragment extends Fragment {

    private FragmentHealthBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentHealthBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateData();
    }

    private void populateData() {
        List<HealthModel> dataModelList = new ArrayList<>();

        dataModelList.add(new HealthModel("Oil Life", "50%"));
        dataModelList.add(new HealthModel("Tire", "80%"));
        dataModelList.add(new HealthModel("Air Filter Quality", "75%"));
        dataModelList.add(new HealthModel("Oil Pressure", "90%"));
        dataModelList.add(new HealthModel("Oil Life", "50%"));
        dataModelList.add(new HealthModel("Tire", "80%"));
        dataModelList.add(new HealthModel("Overall Health", "80%"));
        dataModelList.add(new HealthModel("Estimated milage", "25,000 miles"));

        HealthAdapter healthAdapter = new HealthAdapter(dataModelList);
        binding.setHealthAdapter(healthAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}