package com.example.dusicong.my;

import android.content.DialogInterface;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by Du Sicong on 3/26/2017.
 */

public class gesture_demo extends AppCompatActivity {

    private EditText editText;
    private GestureOverlayView gesture;

    private MyGestureListener mgListener;
    private GestureDetector mDetector;
    private final static String TAG = "MyGesture";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gesture_demo);

        mgListener = new MyGestureListener();
        mDetector = new GestureDetector(this, mgListener);

        //获取手势编辑组件后，设置相关参数
        gesture = (GestureOverlayView) findViewById(R.id.gesture);
        gesture.setGestureColor(Color.GREEN);
        gesture.setGestureStrokeWidth(5);
        gesture.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener(){

            @Override
            public void onGesturePerformed(GestureOverlayView overlay, final Gesture gesture) {
                View saveDialog = getLayoutInflater().inflate(R.layout.dialog_save, null, false);
                ImageView img_show = (ImageView) saveDialog.findViewById(R.id.img_show);
                final EditText edit_name = (EditText) saveDialog.findViewById(R.id.edit_name);
                Bitmap bitmap = gesture.toBitmap(128, 128, 10, 0xffff0000);
                img_show.setImageBitmap(bitmap);
                new AlertDialog.Builder(gesture_demo.this).setView(saveDialog)
                        .setPositiveButton("save", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                GestureLibrary gestureLib = GestureLibraries.fromFile("/mnt/sdcard/mygestures");
                                gestureLib.addGesture(edit_name.getText().toString(), gesture);
                                gestureLib.save();
                            }
                        }).setNegativeButton("cancel", null).show();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mDetector.onTouchEvent(event);
    }

    //实现SimpleOnGestureListener接口可以不用重写所有的手势
    private class MyGestureListener implements GestureDetector.OnGestureListener{

        @Override
        public boolean onDown(MotionEvent e) {
            Log.d(TAG, "onDown:按下");
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            Log.d(TAG, "onShowPress:手指按下一段时间,不过还没到长按");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.d(TAG, "onSingleTapUp:手指离开屏幕的一瞬间");
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d(TAG, "onScroll:在触摸屏上滑动");
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.d(TAG, "onLongPress:长按并且没有松开");
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d(TAG, "onFling:迅速滑动，并松开");
            return false;
        }
    }
}
