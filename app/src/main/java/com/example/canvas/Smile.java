package com.example.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Smile extends View {

    Paint paint = new Paint();

    public Smile(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(100, 200, 50, paint);

        paint.setColor(Color.BLACK);
        canvas.drawCircle(75, 180, 10, paint);

        paint.setColor(Color.BLACK);
        canvas.drawCircle(125, 180, 10, paint);

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        //canvas.drawArc(, 125, 125, false, paint);
        //canvas.drawArc(75F, 200F, 125F, false, paint);
        canvas.drawArc(75F, 200F, 125F,225F, 0F, 180F, false, paint);

    }
}
