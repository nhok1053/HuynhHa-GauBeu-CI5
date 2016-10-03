package com.example.hasan.lab3;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Ha San~ on 10/2/2016.
 */

public class OnMeasure extends RelativeLayout {
    public OnMeasure(Context context) {
        super(context);

    }

    public OnMeasure(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public OnMeasure(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int newWidthSize = widthSize / 2;

        int newWidthMode = MeasureSpec.EXACTLY;

        int newWidthMeasureSpec = MeasureSpec.makeMeasureSpec(newWidthSize, newWidthMode);

        super.onMeasure(newWidthMeasureSpec, heightMeasureSpec);
    }
}
