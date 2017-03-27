package com.example.dusicong.my;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Du Sicong on 3/25/2017.
 */

public class MyAsyncTask extends AsyncTask<Integer, Integer, String> {
    private TextView txt;
    private ProgressBar pgbar;

    public MyAsyncTask(TextView txt, ProgressBar pgbar){
        super();
        this.txt = txt;
        this.pgbar = pgbar;
    }

    @Override
    protected String doInBackground(Integer... params) {
        DelayOperator dop = new DelayOperator();
        int i = 0;
        for ( i = 10; i <= 100; i += 10){
            dop.delay();
            publishProgress(i);
        }
        return i + params[0] +"";
    }

    //该方法运行在UI线程中， 可对UI空间进行设置
    @Override
    protected void onPreExecute(){
        txt.setText("开始执行异步线程~");
    }

    //在doInBackground方法中，每次调用publishProgress方法都会触发该方法
    //运行在UI线程中， 可对UI控件进行操作
    @Override
    protected void onProgressUpdate (Integer... values){
        int value = values[0];
        pgbar.setProgress(value);
    }
}
