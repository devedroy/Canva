package com.example.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class P2DrawBallView extends View {

    private float currX;
    private float currY;

    public P2DrawBallView(Context context) {
        super(context);
    }

    public float getCurrX() {
        return currX;
    }

    public float getCurrY() {
        return currY;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(this.getBallColor());

        canvas.drawCircle(currX, currY, 35, paint);
    }

    private int getBallColor() {
    }

    public void setCurrX(float currX) {
        this.currX = currX;
    }

    public void setCurrY(float currY) {
        this.currY = currY;
    }

    public void setBallColor(int blue) {

    }
}
