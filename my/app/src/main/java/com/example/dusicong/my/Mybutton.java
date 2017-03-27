package com.example.dusicong.my;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

/**
 * Created by Du Sicong on 3/24/2017.
 */

public class Mybutton extends AppCompatButton {
    private static String TAG = "hehe";
    public Mybutton(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    @Override
    public boolean onKeyDown(int keycode, KeyEvent event){
        super.onKeyDown(keycode, event);
        Log.i(TAG, "自定义按钮的onKeyDown 方法被调用");
        return true;
    }

    @Override
    public boolean onKeyUp(int keycode, KeyEvent event){
        super.onKeyUp(keycode, event);
        Log.i(TAG, "自定义按钮的onKeyUp 方法被调用");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        super.onTouchEvent(event);
        Log.i(TAG, "自定义按钮的onTouchEvent 方法被调用");
        return true;
    }
}
