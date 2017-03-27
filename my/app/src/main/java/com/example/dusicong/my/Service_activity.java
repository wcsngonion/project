package com.example.dusicong.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Du Sicong on 3/27/2017.
 */

public class Service_activity extends AppCompatActivity {

    private Button start;
    private Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service);

        start = (Button) findViewById(R.id.service_btn1);
        stop = (Button) findViewById(R.id.service_btn2);

        final Intent intent = new Intent(getApplicationContext(), MyService.class);


//        final Intent intent = new Intent("com.example.dusicong.my.MyService");
//        intent.setPackage("com.example.dusicong.my");
//
//        <intent-filter>
//                <action android:name="com.example.dusicong.my.MyService"/>
//            </intent-filter>

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });
    }
}
