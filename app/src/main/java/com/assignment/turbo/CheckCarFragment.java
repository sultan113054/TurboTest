package com.assignment.turbo;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.assignment.turbo.databinding.FragmentCheckCarBinding;

import java.util.Random;

public class CheckCarFragment extends Fragment {

    private FragmentCheckCarBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentCheckCarBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] issues = {"Bad O2", "Old cabin Filter", "Dirty Engine Filter"};
        String[] fix = {"Replace Exhaust", "Replace cabin Filter" ,"Replace Engine Filter"};
        Random r = new Random();
        int index=r.nextInt(issues.length );
        String issuestring = String.valueOf( issues [index]);
        String fixtring = String.valueOf( fix [index]);



        binding.txtResult.setText(issuestring);
        binding.txtSuggestion.setText(fixtring);
        binding.btnClearEngine.setOnClickListener(view1 -> {
            Toast.makeText(getActivity(), "Engine is Clearing", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getActivity(), "Engine is cleared", Toast.LENGTH_LONG).show();
                }
            }, 2000);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}