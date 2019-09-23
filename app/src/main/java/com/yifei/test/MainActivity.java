package com.yifei.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity-1";
    private RadioGroup rg ;
    private RatingBar rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg= findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_female:
                        Log.d(TAG, "female");
                        break;
                    case R.id.radio_male:
                        Log.d(TAG, "male");
                        break;
                }
            }
        });

        rb= findViewById(R.id.rb);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.d(TAG, "rating="+rating);
            }
        });
    }

    public void rgClick(View view) {
        Log.d(TAG, "view="+view.getId());
    }
}
