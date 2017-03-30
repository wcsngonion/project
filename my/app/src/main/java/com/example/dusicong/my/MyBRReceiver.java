package com.example.dusicong.my;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.view.WindowManager;

import static android.support.v7.appcompat.R.style.Theme_AppCompat_Dialog;


/**
 * Created by Du Sicong on 3/28/2017.
 */

public class MyBRReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(
                new ContextThemeWrapper(context, Theme_AppCompat_Dialog));
        dialogBuilder.setTitle("warning: ");
        dialogBuilder.setMessage("您的账号在别处登录，请重新登陆~");
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("ok",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCollector.finishAll();
                        Intent intent = new Intent(context, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                });
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setType(
                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT
        );
        alertDialog.show();
    }
}
