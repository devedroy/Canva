package com.example.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class CustomDraw extends View {

    Paint paint;
    Path mPath;

    boolean b;

    public CustomDraw(Context context) {
        super(context);

        paint = new Paint();
        mPath = new Path();

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20f);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);

        canvas.drawColor(Color.YELLOW);
        canvas.drawPath(mPath, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //return super.onTouchEvent(event);

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(event.getX(), event.getY());
                break;

            case MotionEvent.ACTION_MOVE:
               // b = true;
                mPath.lineTo(event.getX(), event.getY());
                break;
        }

        invalidate();

        return true;
    }

//    public void moveAhead() {
//        t += 5;
//        invalidate();
//    }
}
