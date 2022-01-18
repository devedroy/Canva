package com.example.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

public class CustomDrawAndReset extends View {

    Paint p;
    Path mPath;

    boolean b;

    Bitmap bitmap_light, bitmap_dark;

    int draw_dark = R.drawable.ic_cached_dark;
    int draw_light = R.drawable.ic_cached_light;


    public CustomDrawAndReset(Context context) {
        super(context);

        p = new Paint();

        bitmap_dark = getBitFromVector1(context, draw_dark);
        bitmap_light = getBitFromVector1(context, draw_light);

        mPath = new Path();

        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(20f);
    }

    public static Bitmap getBitFromVector1(Context context, int drawableId) {

        Drawable drawable = ContextCompat.getDrawable(context, drawableId);

        drawable = (DrawableCompat.wrap(drawable)).mutate();

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);

        drawable.setBounds(0, 0, 80, 80);
        drawable.draw(canvas);

        return bitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
       // super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);
        canvas.drawPath(mPath, p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //return super.onTouchEvent(event);

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(event.getX(), event.getY());

            case MotionEvent.ACTION_MOVE:
                b = true;
                mPath.lineTo(event.getX(), event.getY());

            case MotionEvent.ACTION_UP:
                int x = (int) event.getX();
                int y = (int) event.getY();

                if ((x >= 10 & x <= 110) & (y >= 10 & y <= 120)) {
                    b = false;
                    mPath.reset();
                }
        }
        invalidate();

        return true;
    }
}
