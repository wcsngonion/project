package com.example.dusicong.my;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Du Sicong on 3/28/2017.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private EditText edit_user;
    private EditText edit_pawd;
    private Button btn_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);

        bindViews();
    }

    private void bindViews() {
        edit_user = (EditText) findViewById(R.id.edit_user);
        edit_pawd = (EditText) findViewById(R.id.edit_pawd);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onClick(View v) {

    }
}
