package com.example.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

public class RunFan extends View {

    Paint paint = new Paint();

    public RunFan(Context context) {
        super(context);
    }

    int t = 10;

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);

        paint.setColor(Color.BLACK);
        RectF oval1 = new RectF(450, 170, 650, 320);
        canvas.drawArc(oval1, t, 30, true, paint);


        canvas.drawArc(oval1, t + 120, 30, true, paint);


        canvas.drawArc(oval1, t +270, 30, true, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //return super.onTouchEvent(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                moveAhead();
                break;
        }

        return true;
    }

    public void moveAhead() {
        t += 5;
        invalidate();
    }
}
