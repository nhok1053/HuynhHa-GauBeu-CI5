package com.example.hasan.lab3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Ha San~ on 10/2/2016.
 */

public class FavouritesAdpter extends ArrayAdapter<FavouritesItem> {
    public FavouritesAdpter(Context context, int resource, List<FavouritesItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.favourites, parent, false);

        }
        FavouritesItem favouritesItem = getItem(position);
        new FavouritesHolder(convertView).setData(favouritesItem);
        return convertView;
    }
}
