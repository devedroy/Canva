package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class P2RotateBallCustomView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_rotate_ball_custom_view);

        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.idP2DrawBallView);

        final P2DrawBallView drawBallView = new P2DrawBallView(this);

        drawBallView.setMinimumWidth(500);
        drawBallView.setMinimumHeight(800);

        View.OnTouchListener onTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                drawBallView.setCurrX(event.getX());
                drawBallView.setCurrY(event.getY());

                drawBallView.setBallColor(Color.BLUE);

                drawBallView.invalidate();

                return true;
            }
        };

        drawBallView.setOnTouchListener(onTouchListener);
        rootLayout.addView(drawBallView);
    }
}