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


        binding.txtResult.setText(DataProvider.issueString);
        binding.txtSuggestion.setText(DataProvider.fixString);

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