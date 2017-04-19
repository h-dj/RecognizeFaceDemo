package com.example.h_dj.recognizefacedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import static android.content.ContentValues.TAG;

/**
 * Created by H_DJ on 2017/4/18.
 */

public class DrawView extends ImageView {


    private Paint paint; //画笔
    private Rect mRect;
    private String score; //图片匹配度

    private Paint TextPaint;

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#ff0000"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        TextPaint = new Paint();
        TextPaint.setAntiAlias(true);
        TextPaint.setStrokeWidth(20);
        TextPaint.setColor(Color.parseColor("#ff0000"));
        TextPaint.setTextAlign(Paint.Align.CENTER);
        TextPaint.setTextSize(60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mRect != null) {
            canvas.drawRect(mRect, paint);
        }

        if (score != null) {
            canvas.drawText(score, 200, 100, TextPaint);
        }
        super.onDraw(canvas);

    }

    public void setRect(Rect rect) {
        Log.i(TAG, "setRect: ");
        mRect = rect;
        invalidate();
    }

    public void setText(String score) {
        Log.i(TAG, "setText: " + score);
        this.score = "相似度:\n" + score;
        invalidate();
    }
}
