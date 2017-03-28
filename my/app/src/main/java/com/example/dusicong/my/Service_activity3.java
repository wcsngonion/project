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

public class Service_activity3 extends AppCompatActivity {

    private Button btnbind;
    private Button btncancel;
    private Button btnstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service2);

        btnbind = (Button) findViewById(R.id.btnbind);
        btncancel = (Button) findViewById(R.id.btncancel);
        btnstatus = (Button) findViewById(R.id.btnstatus);

//        final Intent intent = new Intent(getApplicationContext(), MyService2.class);


        final Intent it1 = new Intent("com.test.intentservice");
        it1.setPackage("com.example.dusicong.my");
        Bundle b1 = new Bundle();
        b1.putString("param", "s1");
        it1.putExtras(b1);

        final Intent it2 = new Intent("com.test.intentservice");
        it2.setPackage("com.example.dusicong.my");
        Bundle b2 = new Bundle();
        b2.putString("param", "s2");
        it2.putExtras(b2);

        final Intent it3 = new Intent("com.test.intentservice");
        it3.setPackage("com.example.dusicong.my");
        Bundle b3 = new Bundle();
        b3.putString("param", "s3");
        it3.putExtras(b3);

        startService(it1);
        startService(it2);
        startService(it3);
    }
}
