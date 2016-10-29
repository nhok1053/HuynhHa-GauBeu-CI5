package com.example.hasan.lab_16.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hasan.lab_16.R;
import com.example.hasan.lab_16.models.Lists;
import com.example.hasan.lab_16.viewholder.AdapterViewHolder;

/**
 * Created by Ha San~ on 10/29/2016.
 */

public class Adapter extends RecyclerView.Adapter<AdapterViewHolder> {


    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Infalte view
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.title_layout, parent, false);
        // create view holder
        AdapterViewHolder adapter = new AdapterViewHolder(view);

        return adapter;
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {
        Lists lists = Lists.LISTS.get(position);
        holder.bind(lists);
    }

    @Override
    public int getItemCount() {
        return Lists.LISTS.size();
    }
}
