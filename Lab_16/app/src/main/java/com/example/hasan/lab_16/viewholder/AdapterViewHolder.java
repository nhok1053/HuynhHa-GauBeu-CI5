package com.example.hasan.lab_16.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hasan.lab_16.R;
import com.example.hasan.lab_16.models.Lists;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ha San~ on 10/29/2016.
 */

public class AdapterViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_title)
    TextView tv;

    public AdapterViewHolder(View view) {
        super(view);
        ButterKnife.bind(this,view);
    }
    public void bind(Lists categoryLists){
        tv.setText(categoryLists.getTitle());
    }

}
