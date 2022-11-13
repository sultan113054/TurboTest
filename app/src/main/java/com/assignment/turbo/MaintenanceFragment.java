package com.assignment.turbo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.assignment.turbo.databinding.FragmentMaintenanceBinding;


public class MaintenanceFragment extends Fragment {

    private FragmentMaintenanceBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentMaintenanceBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.txtTitle.setText(DataProvider.maintenanceTitleString);
        binding.txtMinor.setText(DataProvider.maintenanceLevelString);
        binding.txtDays.setText(DataProvider.daysString);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}