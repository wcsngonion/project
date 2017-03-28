package com.example.dusicong.my;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Du Sicong on 3/27/2017.
 */

public class MyService3 extends IntentService {
    private final String TAG = "test_service3";

    public MyService3()
    {
        super("Test_Service3");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String action = intent.getExtras().getString("param");
        if(action.equals("s1")) Log.i(TAG,"启动service1");
        if(action.equals("s2")) Log.i(TAG,"启动service2");
        if(action.equals("s3")) Log.i(TAG,"启动service3");

        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate方法被调用");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand方法被调用!");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestory方法被调用!");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind方法被调用");
        return super.onBind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind方法被调用!");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i(TAG, "onRebind方法被调用!");
        super.onRebind(intent);
    }

    @Override
    public void setIntentRedelivery(boolean enabled) {
        super.setIntentRedelivery(enabled);
        Log.i(TAG,"setIntentRedelivery");
    }
}
