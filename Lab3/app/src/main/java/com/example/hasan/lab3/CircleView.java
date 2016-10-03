package com.example.hasan.lab3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import butterknife.BindColor;
import butterknife.ButterKnife;

/**
 * Created by Ha San~ on 10/3/2016.
 */

public class CircleView extends View {
    @BindColor(R.color.colorAccent)
    int colorAccent;

    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    @BindColor(R.color.colorPrimaryDark)
    int colorOrange;
    public CircleView(Context context) {

        super(context);
        ButterKnife.bind(this, this);
    }

    public CircleView(Context context, AttributeSet attrs) {

        super(context, attrs);
        ButterKnife.bind(this, this);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ButterKnife.bind(this, this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint(0);
        int x = 50, y = 50;
        paint.setColor(colorAccent);
        canvas.drawCircle(x,y, 50, paint);
        x += 60;
        paint.setColor(colorPrimary);
        canvas.drawCircle(x, y, 50, paint);



    }
    }

