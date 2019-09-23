package com.yifei.caipuke;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            pb.setProgress(progress);
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            while (progress<=100){
                try {
                    Thread.sleep(1000);
                    progress++;
                    handler.sendMessage(Message.obtain());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    int progress=0;




    ProgressBar pb;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar);
        initView();
    }

    private void initView() {
        pb = findViewById(R.id.pb);
        tv = findViewById(R.id.tv);
    }

    public void load(View view) {
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
