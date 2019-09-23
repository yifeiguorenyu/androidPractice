package com.chxblue.reciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver-1";
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Log.d(TAG, "onReceive: 1234");
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
