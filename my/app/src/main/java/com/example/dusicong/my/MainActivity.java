package com.example.dusicong.my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txttitle;
    private ProgressBar pgbar;
    private Button btnupdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asynctask_demo);

        txttitle =(TextView) findViewById(R.id.txttitle);
        pgbar = (ProgressBar) findViewById(R.id.pgbar);
        btnupdate = (Button) findViewById(R.id.btnupdate);

        btnupdate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                MyAsyncTask myTask = new MyAsyncTask(txttitle, pgbar);
                myTask.execute(1);

            }
        });
    }


}
