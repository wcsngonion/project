package com.example.dusicong.my;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Du Sicong on 3/27/2017.
 */

public class MyService2 extends Service {
    private final String TAG = "test_service2";
    private int count = 0;
    private boolean quit;

    public class MyBinder extends Binder {
        public int getCount(){
            return count;
        }
    }
    private MyBinder binder = new MyBinder();

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate方法被调用");
        super.onCreate();

        new Thread(){
            public void run(){
                while (!quit){
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    count++;
                }
            }
        }.start();
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
        this.quit = true;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind方法被调用");
        return binder;
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
}
