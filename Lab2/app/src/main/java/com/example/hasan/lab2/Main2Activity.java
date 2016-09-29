package com.example.hasan.lab2;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView img = (ImageView) findViewById(R.id.add);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                DetailFragment detailFragment = new DetailFragment();

                fragmentTransaction.replace(R.id.frameLayout, detailFragment);

                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
            }
        });
    }




}
