package com.assignment.turbo;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;


import com.assignment.turbo.databinding.FragmentRealtimeInfoItemBinding;

import java.util.List;

public class RealtimeInfoAdapter extends RecyclerView.Adapter<RealtimeInfoAdapter.RealtimeInfoHolder> {

    private List<RealtimeInfoModel> dataSet;


    public RealtimeInfoAdapter(List<RealtimeInfoModel> _dataSet) {
        this.dataSet = _dataSet;
    }

    @Override
    public RealtimeInfoHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        FragmentRealtimeInfoItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.fragment_realtime_info_item, viewGroup, false);

        return new RealtimeInfoHolder(binding);
    }

    @Override
    public void onBindViewHolder(RealtimeInfoHolder viewHolder, final int position) {

        RealtimeInfoModel dataModel = dataSet.get(position);
        viewHolder.bind(dataModel);

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class RealtimeInfoHolder extends RecyclerView.ViewHolder {
        public FragmentRealtimeInfoItemBinding itemRowBinding;

        public RealtimeInfoHolder(FragmentRealtimeInfoItemBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(RealtimeInfoModel obj) {
            itemRowBinding.setVariable(BR.model, obj);
            itemRowBinding.executePendingBindings();
            itemRowBinding.imgInfo.setImageResource(obj.icon);

        }
    }
}

