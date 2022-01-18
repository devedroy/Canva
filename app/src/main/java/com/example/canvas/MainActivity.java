package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

   // P1SimpleDrawCircleRectangleMethods cv2;
//    Smile cv2;
//    RunFan cv2;
//   CustomDraw cv2;
   CustomDrawAndReset cv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //cv2 = new P1SimpleDrawCircleRectangleMethods(this);
//        cv2 = new Smile(this);
//        cv2 = new RunFan(this);
//        cv2 = new CustomDraw(this);
        cv2 = new CustomDrawAndReset(this);

        cv2.setBackgroundColor(Color.WHITE);
        setContentView(cv2);
    }


}