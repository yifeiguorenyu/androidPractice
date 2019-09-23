package com.chxblue.send;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.brocastText);
    }

    public void sendBrocast(View view) {

    Intent intent = new Intent();
    intent.putExtra("msg",editText.getText().toString());
   // intent.setPackage("com.chxblue.reciver");
    intent.setAction("com.chxblue.reciver.MyReceiver.yifei");
    sendBroadcast(intent);
    }
}
