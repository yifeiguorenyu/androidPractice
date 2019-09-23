package com.yifei.caipuke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.ToggleButton;

public class SwitchActivity extends AppCompatActivity {

    ImageView iv;
    Switch aSwitch;
    ToggleButton tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        initView();
        initEvents();
    }

    private void initEvents() {
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    iv.setImageResource(R.drawable.fangpian);
                }else {
                    iv.setImageResource(R.drawable.black);
                }
            }
        });
    }

    private void initView() {
        iv = findViewById(R.id.iv);
        aSwitch = findViewById(R.id.switc);
        tb = findViewById(R.id.tb);
    }
}
