package com.chxblue.mycapture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_result);
        String path = getIntent().getStringExtra("picPath");
        ImageView imageView = findViewById(R.id.pic);
        Bitmap bm = BitmapFactory.decodeFile(path);
        imageView.setImageBitmap(bm);
    }

}
