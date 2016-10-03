package com.example.hasan.lab3;

import android.content.Context;
import android.content.res.TypedArray;
import android.media.Image;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ha San~ on 10/2/2016.
 */

public class Viewcompoundturn1 extends RelativeLayout {
    @BindView(R.id.textView2)
    TextView tv_value;
    @BindView(R.id.textView)
    TextView tv_number;
    @BindView(R.id.imageView)
    ImageView iv_Des;
    @BindView(R.id.imageView2)
    ImageView iv_plus;
    int number;

    public Viewcompoundturn1(Context context) {
        super(context);
        initFromContext(context, null);
    }

    public Viewcompoundturn1(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFromContext(context, attrs);
    }

    public Viewcompoundturn1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFromContext(context, attrs);
    }

    private void initFromContext(Context context, AttributeSet attrs) {
        View rootView = inflate(context, R.layout.viewcompound_turn1, this);
        ButterKnife.bind(this, rootView);
//        setupUI();
        addListener();
        number = Integer.parseInt(tv_number.getText().toString());
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Viewcompoundturn1);
            String value = typedArray.getString(R.styleable.Viewcompoundturn1_labell);
            int num = typedArray.getInt(R.styleable.Viewcompoundturn1_value,-1);
            typedArray.recycle();
            tv_number.setText(num+"");
            tv_value.setText(value);
        }
    }

    private void addListener() {
        iv_Des.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number - 1;
                tv_number.setText(number + "");
            }
        });
        iv_plus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + 1;
                tv_number.setText(number + "");
            }
        });
    }

//    private void setupUI() {
//        tv_number.setText(number);
//    }
}
