package com.example.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class P1FanSurfaceView extends SurfaceView implements Runnable {

    Canvas canvas;
    SurfaceHolder surfaceHolder;
    Paint paint;
    Thread t = null;
    boolean isRotating;
    int x = 0;
    Rect r1;

    public P1FanSurfaceView(Context context) {
        super(context);

        surfaceHolder = getHolder();
        paint = new Paint();

        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                startThread1();
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });
    }

    public void startThread1() {
        isRotating = true;
        t = new Thread(this);
        t.start();
    }

    public void stopThread() {
        isRotating = false;
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (isRotating) {
            if (surfaceHolder.getSurface().isValid()) {

                canvas = surfaceHolder.lockCanvas();

                synchronized (this) {
                    canvas.drawColor(Color.YELLOW);
                    paint.setColor(Color.GREEN);

                    canvas.drawArc(400, 400, 1100, 1100, x, 30, true, paint);
                    canvas.drawArc(400, 400, 1100, 1100, x + 120, 30, true, paint);
                    canvas.drawArc(400, 400, 1100, 1100, x + 240, 30, true, paint);

                    r1 = new Rect(400, 400, 1100, 1100);
                    x = x + 10;

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        if (canvas != null) {
                            surfaceHolder.unlockCanvasAndPost(canvas);
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x1 = (int) event.getX();
        int y1 = (int) event.getY();

        if (r1.contains(x1, y1)) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startThread1();
                    break;
                case MotionEvent.ACTION_UP:
                    stopThread();
                    break;
            }
        }
        return true;
//        return super.onTouchEvent(event);
            }
}
