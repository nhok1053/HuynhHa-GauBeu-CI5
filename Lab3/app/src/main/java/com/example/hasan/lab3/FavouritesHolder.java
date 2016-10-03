package com.example.hasan.lab3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ha San~ on 10/2/2016.
 */

public class FavouritesHolder {
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.tvTitle)
    TextView title;
    @BindView(R.id.minutes)
    TextView minutes;
    public FavouritesHolder(View rootview){
        ButterKnife.bind(this,rootview);

    }
    public void setData(FavouritesItem favouritesItem){
        img.setImageResource(favouritesItem.getImagesResID());
        title.setText(favouritesItem.getTitle());
        minutes.setText(favouritesItem.getMinutes());
    }
}
