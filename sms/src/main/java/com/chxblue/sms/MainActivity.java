package com.chxblue.sms;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editNum,editLetter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        editNum = findViewById(R.id.edit_phone);
        editLetter= findViewById(R.id.edit_content);

    }

    public void stop(View view) {
    }

    public void start(View view) {
        String tel = editLetter.getText().toString();
        String context = editNum.getText().toString();
        SmsReceiver receiver = new SmsReceiver(tel,context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        intentFilter.setPriority(1000);
        registerReceiver(receiver,intentFilter);

    }
}
