package com.yifei.dadishu;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvInfo;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settime);
        initView();
    }

    private void initView() {
        tvInfo = findViewById(R.id.tv_info);
        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = editText.getText().toString();
                int i = Integer.parseInt(string);
                MyCountTime myCountTime =new MyCountTime(i*1000,1000);
                myCountTime.start();
            }
        });
    }

    private class MyCountTime extends CountDownTimer {

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and
         *                          {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public MyCountTime(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long hout = millisUntilFinished / 1000 / 3600;
            long minute = millisUntilFinished / 1000 % 3600 / 60;
            long second = millisUntilFinished / 1000 % 3600 % 60;
            tvInfo.setText("倒计时:" + hout + ":" + minute + ":" + second);
        }

        @Override
        public void onFinish() {
            tvInfo.setText("及时结束");
        }
    }
}
