package com.example.hasan.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {
    @BindView(R.id.lv_lab3)
    ListView list_favourites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {

        list_favourites.setAdapter(new FavouritesAdpter(this,R.layout.favourites, Arrays.asList(FavouritesItem.Array)));
    }
}
