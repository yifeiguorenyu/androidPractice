package com.yifei.dadishu;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "GameActivity-1";
    private TextView tv_count, tv_countdown;
    private Button btn_restart, btn_start;
    private ImageView[] images = new ImageView[21];
    boolean flag = true;
    int count = 0;

    int oldId = 0;
    int newId = 0;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            images[oldId].setBackgroundResource(R.drawable.tudi);
            newId = (int) (Math.random() * 21);
            images[newId].setBackgroundResource(R.drawable.timg);
            oldId = newId;
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            while (flag) {
                try {
                    Thread.sleep(1000);
                    Message message = Message.obtain();
                    handler.sendMessage(message);
                } catch (Exception e) {
                    Log.d(TAG, "error=" + e.getMessage());
                }
            }
        }
    };

    private int[] ids = new int[]{
            R.id.iv_12, R.id.iv_13, R.id.iv_14,
            R.id.iv_21, R.id.iv_22, R.id.iv_23, R.id.iv_24, R.id.iv_25,
            R.id.iv_31, R.id.iv_32, R.id.iv_33, R.id.iv_34, R.id.iv_35,
            R.id.iv_41, R.id.iv_42, R.id.iv_43, R.id.iv_44, R.id.iv_45,
            R.id.iv_52, R.id.iv_53, R.id.iv_54

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initViews();
        initEvents();
    }

    private void initEvents() {
        btn_start.setOnClickListener(this);
        btn_restart.setOnClickListener(this);
    }

    private void initViews() {
        tv_count = findViewById(R.id.tv_count);
        tv_countdown = findViewById(R.id.tv_time);
        btn_start = findViewById(R.id.btn_start);
        btn_restart = findViewById(R.id.btn_restart);

        for (int i = 0; i < images.length; i++) {
            images[i] = findViewById(ids[i]);
            images[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                new MyCountDown(60 * 1000, 1000).start();
                Thread thread1 = new Thread(runnable);
                thread1.start();
                break;
            case R.id.btn_restart:
                flag = true;
                new MyCountDown(60 * 1000, 1000).start();
                Thread thread = new Thread(runnable);
                thread.start();
                break;
            default:
               if(images[oldId].getId()==view.getId()){
                   count++;
                   tv_count.setText(count+"");
               }

                break;
        }
    }

    private class MyCountDown extends CountDownTimer {

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and
         *                          {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public MyCountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);


        }

        @Override
        public void onTick(long millisUntilFinished) {
            long hour = millisUntilFinished / 1000 / 3600;
            long minute = millisUntilFinished / 1000 % 3600 / 60;
            long second = millisUntilFinished / 1000 % 3600 % 60;
            tv_countdown.setText(hour + ":" + minute + ":" + second);

        }

        @Override
        public void onFinish() {
            tv_countdown.setText("游戏时间到");
            flag = false;
        }


    }
}
