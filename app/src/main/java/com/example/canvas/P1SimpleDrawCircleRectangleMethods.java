package com.example.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class P1SimpleDrawCircleRectangleMethods extends View {

    Paint paint = new Paint();

    public P1SimpleDrawCircleRectangleMethods(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.CYAN);
        //paint.setStrokeWidth(10);

        canvas.drawRect(130, 130, 350,200, paint);

        //paint.setStrokeWidth(0);
        paint.setColor(Color.BLUE);
        canvas.drawRect(130, 200, 350, 270, paint);

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        canvas.drawCircle(240, 235, 35, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawRect(130, 270, 350, 340, paint);

    }
}
