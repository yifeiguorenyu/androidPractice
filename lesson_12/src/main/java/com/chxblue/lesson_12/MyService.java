package com.chxblue.lesson_12;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService--1";
    private TelephonyManager tm;
    private MyPhoneListener listener;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        Log.d(TAG, "sevice");
//        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//
//        String[] phoneType = {"未知", "2G", "3G", "4G"};
//        String phoneCategory = phoneType[tm.getPhoneType()];
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
//            return;
//        }
//        String phoneIMEI = tm.getDeviceId();
//        String phoneSoft =tm.getDeviceSoftwareVersion()!=null?tm.getDeviceSoftwareVersion():"未知";
//        String phoneNumber = tm.getLine1Number();
//
//        String phoneSoid = tm.getNetworkCountryIso();
//        String phoneOperid = tm.getNetworkOperator();
//        String phoneOperNuame = tm.getNetworkOperatorName();
//        int pnoneType = tm.getNetworkType();
//        Log.d(TAG, "phoneCategory: "+phoneCategory);
//        Log.d(TAG, "phoneIMEI: "+phoneIMEI);
//        Log.d(TAG, "phoneSoft: "+phoneSoft);
//        Log.d(TAG, "phoneNumber: "+phoneNumber);
//        Log.d(TAG, "phoneSoid: "+phoneSoid);
//        Log.d(TAG, "phoneOperid: "+phoneOperid);
//        Log.d(TAG, "phoneOperNuame: "+phoneOperNuame);
//        Log.d(TAG, "pnoneType: "+pnoneType);
        tm= (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        listener = new MyPhoneListener();
        tm.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        tm.listen(listener,PhoneStateListener.LISTEN_NONE);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return  null;
    }
}
