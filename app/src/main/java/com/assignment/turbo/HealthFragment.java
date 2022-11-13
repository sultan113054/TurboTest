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
import java.util.Random;


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

    //public void onCreate( Bundle savedInstanceState) {
    // super.onCreate(savedInstanceState);

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
        populateData();
    }
    private String returnStringBuilder()
    {
        int min = 0;
        int max = 100;
        //int random= = new Random().nextInt((max - min) + 1) + min;

        int random =  (new Random()).nextInt((max - min) + 1) + min;

        StringBuilder s = new StringBuilder(100);
        s.append(String.valueOf(random));
        s.append("%");

        String singleString = s.toString();
        return singleString;
    }
    private String returnStringBuilder4Miles()
    {
        int min = 10000;
        int max = 95000;
        //int random= = new Random().nextInt((max - min) + 1) + min;

        int random =  (new Random()).nextInt((max - min) + 1) + min;

        StringBuilder s = new StringBuilder(100);
        s.append(String.valueOf(random));
        s.append(" miles");

        String singleString = s.toString();
        return singleString;
    }

    private void populateData() {
        List<HealthModel> dataModelList = new ArrayList<>();



        dataModelList.add(new HealthModel("Oil Life", returnStringBuilder()));
        dataModelList.add(new HealthModel("Tire", returnStringBuilder()));
        dataModelList.add(new HealthModel("Air Filter Quality", returnStringBuilder()));
        dataModelList.add(new HealthModel("Oil Pressure", returnStringBuilder()));
        dataModelList.add(new HealthModel("Oil Life", returnStringBuilder()));
        dataModelList.add(new HealthModel("Tire", "80%"));
        dataModelList.add(new HealthModel("Overall Health", returnStringBuilder()));
        dataModelList.add(new HealthModel("Estimated milage", returnStringBuilder4Miles()));

        HealthAdapter healthAdapter = new HealthAdapter(dataModelList);
        binding.setHealthAdapter(healthAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}