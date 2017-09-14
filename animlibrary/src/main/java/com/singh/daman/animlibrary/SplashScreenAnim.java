package com.singh.daman.animlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Daman on 9/12/2017.
 */

public class SplashScreenAnim extends View {

    Paint paint = new Paint();
    Paint paint2 = new Paint();
    private int colorArc;
    private float rotate;
    private RectF oval = new RectF();
    private int sweepAngle = 100;
    private int startAngle2 = 240;

    public SplashScreenAnim(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setStyle(Paint.Style.FILL);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setFlags(Paint.ANTI_ALIAS_FLAG);
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.DotsZoomProgress, 0, 0);
        try {
            colorArc = array.getColor(R.styleable.DotsZoomProgress_inner_color, Color.parseColor("#5C6BC0"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            array.recycle();
        }
        paint.setColor(colorArc);

        post(animator);

    }


    @Override
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.rotate(rotate, getWidth() / 2, getHeight() / 2);
        oval.set(getWidth() / 8, getHeight() / 8, getWidth() - getWidth() / 8, getHeight() - getHeight() / 8);
        canvas.drawArc(oval, startAngle2, sweepAngle, false, paint2);
        canvas.drawRect(getWidth() / 6, getHeight() / 6, getWidth() - getWidth() / 6, getHeight() - getHeight() / 6, paint);
        canvas.restore();
    }

    Runnable animator = new Runnable() {
        @Override
        public void run() {
            rotate += 4;
            if (startAngle2 >= 1) {
                startAngle2 -= 15;
            } else {
                startAngle2 = 360;
            }
            invalidate();
            postDelayed(this, 30);
        }
    };
}
