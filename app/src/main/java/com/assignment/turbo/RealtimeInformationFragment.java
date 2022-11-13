package com.assignment.turbo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.assignment.turbo.databinding.FragmentRealtimeInformationBinding;

import java.util.ArrayList;
import java.util.List;


public class RealtimeInformationFragment extends Fragment {

    private FragmentRealtimeInformationBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentRealtimeInformationBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateData();
    }

    private void populateData() {
        List<RealtimeInfoModel> dataModelList = new ArrayList<>();

        dataModelList.add(new RealtimeInfoModel(R.drawable.temperature, "Oil Temperature", "190.4"));
        dataModelList.add(new RealtimeInfoModel(R.drawable.coolant_tempearature1, "Coolant Temperature", "73.0 F"));
        dataModelList.add(new RealtimeInfoModel(R.drawable.boost, "Boost", "19.7 psi"));
        dataModelList.add(new RealtimeInfoModel(R.drawable.oil_pressure, "Oil Pressure", "150 psi"));


        RealtimeInfoAdapter realtimeInfoAdapter = new RealtimeInfoAdapter(dataModelList);
        binding.setRealtimeInfoAdapter(realtimeInfoAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}