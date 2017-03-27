package com.example.dusicong.my;

/**
 * Created by Du Sicong on 3/25/2017.
 */

public class DelayOperator {
    //演延时操作，用来模拟下载
    public void delay(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
