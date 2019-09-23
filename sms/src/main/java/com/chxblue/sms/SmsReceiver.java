package com.chxblue.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {
    private static final String TAG = "SmsReceiver-1";
    private String tel = "";
    private String content = "";

    public SmsReceiver(String tel, String content) {
        this.tel = tel;
        this.content = content;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //        fff啊啊啊
        StringBuilder number = new StringBuilder();
        StringBuilder body = new StringBuilder();

        Bundle extras = intent.getExtras();
        if (extras != null) {
            Object[] objects = (Object[]) extras.get("pdus");
            SmsMessage[] message = new SmsMessage[objects.length];
            for (int i = 0; i < objects.length; i++) {
                message[i] = SmsMessage.createFromPdu((byte[]) objects[i]);
            }
            for (SmsMessage message1 : message) {
                number.append(message1.getDisplayOriginatingAddress()); //电话号码
                body.append(message1.getDisplayMessageBody());//短信内容
            }
            String smsnum = number.toString();
            String smsbyod = body.toString();
            Log.d(TAG, "smsnum: "+smsnum);
            Log.d(TAG, "smsbyod: "+smsbyod);
            if (smsnum.equals(tel)) {
                Toast.makeText(context, "你的电话号码被拦截", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "你的电话号码被拦截: ");
                abortBroadcast();
            }

            if (smsbyod.contains(content)) {
                Toast.makeText(context, "你的敏感词汇被拦截", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "你的敏感词汇被拦截: ");
                abortBroadcast();
            }
        }
    }
}
