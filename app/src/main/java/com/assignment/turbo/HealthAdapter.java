package com.assignment.turbo;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.turbo.databinding.FragmentHealthItemBinding;

import java.util.List;

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.HealthViewHolder> {

    private List<HealthModel> dataSet;


    public HealthAdapter(List<HealthModel> _dataSet) {
        this.dataSet = _dataSet;
    }

    @Override
    public HealthViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        FragmentHealthItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.fragment_health_item, viewGroup, false);

        return new HealthViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(HealthViewHolder viewHolder, final int position) {

        HealthModel dataModel = dataSet.get(position);
        viewHolder.bind(dataModel);

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class HealthViewHolder extends RecyclerView.ViewHolder {
        public FragmentHealthItemBinding itemRowBinding;

        public HealthViewHolder(FragmentHealthItemBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.model, obj);
            itemRowBinding.executePendingBindings();
        }
    }
}

