package com.assignment.turbo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Random;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

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
         int min = 50;
         int max = 300;
         //int random= = new Random().nextInt((max - min) + 1) + min;

        int random =  (new Random()).nextInt((max - min) + 1) + min;


        StringBuilder s = new StringBuilder(100);
        s.append("Next estimated maintenance at ");
        s.append(String.valueOf(random));
        s.append(" miles");

        // binding.txtTitle.setText("Next estimated maintenance at 1000 miles.");
        binding.txtTitle.setText(s);


        String[] myArrayOfStrings = {"Minor", "Major" };
        Random r = new Random();
        String myRandString = String.valueOf( myArrayOfStrings [r.nextInt(myArrayOfStrings.length )]);

        binding.txtMinor.setText(myRandString);

         min = 1;
         max = 50;
        //int random= = new Random().nextInt((max - min) + 1) + min;

         random =  (new Random()).nextInt((max - min) + 1) + min;


        StringBuilder s2 = new StringBuilder(100);

        s2.append(String.valueOf(random));


        binding.txtDays.setText("30");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}