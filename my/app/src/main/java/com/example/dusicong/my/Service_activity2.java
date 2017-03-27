package com.example.dusicong.my;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Du Sicong on 3/27/2017.
 */

public class Service_activity2 extends AppCompatActivity {

    private Button btnbind;
    private Button btncancel;
    private Button btnstatus;

    MyService2.MyBinder binder;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("------Service Connected-------");
            binder = (MyService2.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("------Service DisConnected-------");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service2);

        btnbind = (Button) findViewById(R.id.btnbind);
        btncancel = (Button) findViewById(R.id.btncancel);
        btnstatus = (Button) findViewById(R.id.btnstatus);

        final Intent intent = new Intent(getApplicationContext(), MyService2.class);


//        final Intent intent = new Intent("com.example.dusicong.my.MyService");
//        intent.setPackage("com.example.dusicong.my");
//
//        <intent-filter>
//                <action android:name="com.example.dusicong.my.MyService"/>
//            </intent-filter>

        btnbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(intent, conn, Service.BIND_AUTO_CREATE);
            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(conn);
            }
        });

        btnstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "service 的 count 值为： "
                + binder.getCount(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
