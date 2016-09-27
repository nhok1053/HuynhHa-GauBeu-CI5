package com.example.hasan.session6;

import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.imgTop) ImageView imgTop;
    @BindView(R.id.img_LargeLeft) ImageView img_LargeLeft;
    @BindView(R.id.img_Centre1) ImageView img_Centre1;
    @BindView(R.id.img_Centre2) ImageView img_Centre2;
    @BindView(R.id.img_LargeRight) ImageView img_LargeRight;
    @BindView(R.id.img_SmallBottom1) ImageView img_SmallBottom1;
    @BindView(R.id.img_SmallBottom2) ImageView img_SmallBottom2;
    @BindView(R.id.img_SmallBottom3) ImageView img_SmallBottom3;
    @BindView(R.id.img_SmallBottom4) ImageView img_SmallBottom4;
    @BindView(R.id.img_SmallBottom5) ImageView img_SmallBottom5;
    @BindView(R.id.img_Recently1) ImageView img_Recently1;
    @BindView(R.id.img_Recently2) ImageView img_Recently2;
    @BindView(R.id.img_r1) ImageView img_r1;
    @BindView(R.id.img_r2) ImageView img_r2;
    @BindView(R.id.img_r3) ImageView img_r3;
    @BindView(R.id.img_r4) ImageView img_r4;
    @BindView(R.id.img_r5) ImageView img_r5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
        imgTop.setImageResource(R.drawable.ovalavatar);
        img_LargeLeft.setImageResource(R.drawable.bitmap4);
        img_Centre2.setImageResource(R.drawable.bitmap2);
        img_LargeRight.setImageResource(R.drawable.bitmap7);
        img_SmallBottom1.setImageResource(R.drawable.bitmap1);
        img_SmallBottom2.setImageResource(R.drawable.bitmap1);
        img_SmallBottom3.setImageResource(R.drawable.bitmap8);
        img_SmallBottom4.setImageResource(R.drawable.bitmap6);
        img_SmallBottom5.setImageResource(R.drawable.play);
        img_Recently1.setImageResource(R.drawable.bitmap11);
        img_Recently2.setImageResource(R.drawable.bitmap12);
        img_r1.setImageResource(R.drawable.albums);
        img_r2.setImageResource(R.drawable.heart);
        img_r3.setImageResource(R.drawable.musicnote);
        img_r4.setImageResource(R.drawable.radioo);
        img_r5.setImageResource(R.drawable.search);
    }

}
