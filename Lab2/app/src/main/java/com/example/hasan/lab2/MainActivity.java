package com.example.hasan.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
@BindView(R.id.img_v1)
    ImageView img_v1;
    @BindView(R.id.img_v2)
    ImageView img_v2;
    @BindView(R.id.img_v3)
    ImageView img_v3;
    @BindView(R.id.img_v4)
    ImageView img_v4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
        addListener();
    }

    private void addListener() {
    }

    private void setupUI() {
    img_v1.setImageResource(R.drawable.home);
        img_v2.setImageResource(R.drawable.home);
        img_v3.setImageResource(R.drawable.alarmshape);
        img_v4.setImageResource(R.drawable.personshape);
    }

}
