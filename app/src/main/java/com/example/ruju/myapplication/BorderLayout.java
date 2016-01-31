package com.example.ruju.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by thrown on 2016/1/18.
 */
public class BorderLayout extends LinearLayout {
    private String mText = "sex";
    private int mTextSize = 30;

    public BorderLayout(Context context) {
        this(context, null);
    }

    public BorderLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public BorderLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BorderLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setWillNotDraw(false);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        int startX = 0;
        int endX = getWidth() - 2;
        int startY = 0;
        int endY = getHeight() - 2;

        paint.setColor(Color.BLACK); ;
        paint.setTextSize(mTextSize);
        Rect textBound = new Rect();
        paint.getTextBounds(mText, 0, mText.length(), textBound);
        paint.setStrokeWidth(3);
        canvas.drawText(mText, startX+mTextSize, startY+mTextSize/2+10, paint);
        paint.setColor(Color.RED);
        canvas.drawLine(textBound.width()+startX+mTextSize+10, startY, endX, startX, paint);
        canvas.drawLine(startX, endY, endX, endY, paint);
        canvas.drawLine(startX, startY + mTextSize, startX, endY, paint);
        canvas.drawLine(endX, startY, endX, endY, paint);
        super.onDraw(canvas);
    }


}

