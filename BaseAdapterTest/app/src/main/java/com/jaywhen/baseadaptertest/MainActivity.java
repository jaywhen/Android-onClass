package com.jaywhen.baseadaptertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private MyAdapter myAdapter;
    private List<Map<String, Object>> list =
            new ArrayList<Map<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        mListView =
                (ListView) findViewById(R.id.listView);
        myAdapter = new MyAdapter(list, this);
        mListView.setAdapter(myAdapter);
    }

    private void initData() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("img", R.drawable.java);
        map.put("title", "Java");
        map.put("button", "学习");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("img", R.drawable.js);
        map.put("title", "JavaScript");
        map.put("button", "学习");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("img", R.drawable.react);
        map.put("title", "React");
        map.put("button", "学习");
        list.add(map);
    }
}