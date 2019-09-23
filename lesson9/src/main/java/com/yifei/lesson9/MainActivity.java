package com.yifei.lesson9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity-1";
      ListView lv;
    private List<Person> persons;


    private SimpleAdapter adapter;
    ArrayList<Map<String,Object>> listMap = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        Intent intent = getIntent();
        Log.d(TAG, "onCreate: "+intent);
        if(intent!=null){
            Bundle bundle = intent.getExtras();
            if(bundle!=null){
                persons = (ArrayList<Person>) bundle.getSerializable("persons");
                for (int i=0;i<persons.size();i++){
                    HashMap map = new HashMap();
                    map.put("imgId",persons.get(i).getImgId());
                    map.put("name",persons.get(i).getName());
                    map.put("number",persons.get(i).getNum());
                    listMap.add(map);
                }
                String from[] = {"imgId","name","number"};
                int to[] ={R.id.img,R.id.tv_name,R.id.tv_tel};
                adapter = new SimpleAdapter(this,listMap,R.layout.layout,from,to);
                lv.setAdapter(adapter);
            }
        }
    }

    private void initView() {
        lv= findViewById(R.id.lv_list);
    }

    public void gotoadd(View view) {
        AddActivity.come(this);
    }
}
