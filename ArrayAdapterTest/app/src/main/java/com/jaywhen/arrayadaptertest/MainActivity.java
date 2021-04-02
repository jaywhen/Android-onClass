package com.jaywhen.arrayadaptertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list_view);
        String[] chapterArray = {"ChapterOne", "ChapterTwo", "ChapterThree"};
        ArrayAdapter<String> chapterAdapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, chapterArray);
        listView.setAdapter(chapterAdapter);
    }
}