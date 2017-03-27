package com.example.dusicong.my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Button_demo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listener);
    }

    public void myclick(View source){
        Toast.makeText(getApplicationContext(),"按钮被点击了",Toast.LENGTH_SHORT).show();
    }
}
