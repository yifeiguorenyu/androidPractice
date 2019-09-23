package com.yifei.lesson9;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddActivity extends Activity {
    EditText et_name,et_tel;
    ImageView img_left,img_right,img_peoper;
    Button reset,add;

    private int imgIDs[] = {R.drawable.man1,R.drawable.man2,R.drawable.man3,R.drawable.woman1,R.drawable.woman2,R.drawable.woman3};
    private int idx = 0;

    private List<Person> persons = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
        initEvents();

    }


    public static void come(Context context) {
        Intent intent = new Intent(context, AddActivity.class);
        context.startActivity(intent);
    }

    private  void initView() {
        et_name = findViewById(R.id.et_name);
        et_tel = findViewById(R.id.et_tel);

        img_left = findViewById(R.id.img_left);
        img_right = findViewById(R.id.right);
        img_peoper= findViewById(R.id.peoper);

        reset= findViewById(R.id.reset);
        add = findViewById(R.id.add);
    }

    private void initEvents() {
        img_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idx--;
                if(idx<0)idx=imgIDs.length-1;

                img_peoper.setImageResource(imgIDs[idx]);
            }
        });
        img_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idx++;
                if(idx>=imgIDs.length)idx=0;

                img_peoper.setImageResource(imgIDs[idx]);

            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person(et_name.getText().toString(),et_tel.getText().toString(),imgIDs[idx]);
                persons.add(person);
            }
        });


    }


    public void goback(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("persons", (Serializable) persons);
        startActivity(intent);
    }
}
