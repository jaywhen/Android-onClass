package com.jaywhen.simpleadaptertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listView;   //定义ListView对象，用来获取布局文件中的ListView控件
    private String[] name = {"乔布斯","Google","Microsoft"};  //定义一个名字数组，用来为数据源提供姓名
    private String[] desc = {"写代码","开发框架","重启电脑"};
    private int[] icon = new int[] {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>(); //定义一个适配器对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.list_view);
        for(int i = 0; i < name.length; i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("icon", icon[i]);
            listItem.put("name", name[i]);
            listItem.put("desc", desc[i]);
            listMap.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listMap, R.layout.item,
                new String[]{"name", "icon", "desc"},
                new int[]{R.id.name, R.id.icon, R.id.desc});
        listView.setAdapter(simpleAdapter);
    }

}