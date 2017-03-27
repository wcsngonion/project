package com.example.dusicong.my;

import android.content.Context;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Du Sicong on 3/26/2017.
 */

public class gesture_recognisation extends AppCompatActivity {
    private GestureOverlayView gesture;
    private GestureLibrary gestureLibrary;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gesture_demo);

        mContext = gesture_recognisation.this;
        gestureLibrary = GestureLibraries.fromFile("mnt/sdcard/mygestures");
        if (gestureLibrary.load()) {
            Toast.makeText(mContext, "gesture lib loaded successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "gesture lib loading failed", Toast.LENGTH_SHORT).show();
        }

        //获取手势编辑组建后， 设置相关参数
        gesture = (GestureOverlayView) findViewById(R.id.gesture);
        gesture.setGestureColor(Color.GREEN);
        gesture.setGestureStrokeWidth(5);
        gesture.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener(){
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
                //识别用户刚绘制的手势
                ArrayList<Prediction> predictions = gestureLibrary.recognize(gesture);
                ArrayList<String> result = new ArrayList<String>();
                //遍历所有找到的prediction对象
                for(Prediction pred : predictions){
                    if(pred.score > 2.0){
                        result.add("与手势【" + pred.name + "】相似度为" + pred.score);
                    }
                }
                if(result.size() > 0){
                    ArrayAdapter<Object> adapter = new ArrayAdapter<Object>(mContext,
                            android.R.layout.simple_dropdown_item_1line, result.toArray());
                    new AlertDialog.Builder(mContext).setAdapter(adapter, null).setPositiveButton("ok", null).show();
                }else{
                    Toast.makeText(mContext, "无法找到匹配的手势", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
