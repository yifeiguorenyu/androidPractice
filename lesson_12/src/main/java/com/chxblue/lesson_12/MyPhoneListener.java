package com.chxblue.lesson_12;

import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class MyPhoneListener extends PhoneStateListener {

    TelephonyManager tm;
    MediaRecorder mr;
    private static final String TAG = "MyPhoneListener-1";
    //当电话状态改变时
    @Override
    public void onCallStateChanged(int state, String phoneNumber) {
        super.onCallStateChanged(state, phoneNumber);
        switch (state) {
            case TelephonyManager.CALL_STATE_IDLE://电话空闲
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK://电话接通
                //
                Log.d(TAG, "onCallStateChanged: ");
                mr = new MediaRecorder();
                mr.setAudioSource(MediaRecorder.AudioSource.MIC);//指定录音机的声音源
                mr.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);//设置声音的格式
                //指定文件存放位置及文件名
                File file=new File(Environment.getExternalStorageDirectory(),System.currentTimeMillis()+".3gp");
                String path = file.getAbsolutePath();
                mr.setOutputFile(path);
                mr.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);//设置文件的格式
                try {
                    mr.prepare();
                    mr.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case TelephonyManager.CALL_STATE_RINGING://电话响铃
                break;
            default:
                break;
        }
    }

    @Override
    public void onDataConnectionStateChanged(int state) {
        super.onDataConnectionStateChanged(state);
        switch (state) {
            case TelephonyManager.DATA_ACTIVITY_IN:
                break;
            case TelephonyManager.DATA_ACTIVITY_OUT:
                break;
            case TelephonyManager.DATA_ACTIVITY_NONE:
                break;
            default:
                break;
        }
    }

    @Override
    public void onDataActivity(int direction) {
        super.onDataActivity(direction);
    }
}
