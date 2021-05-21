package com.example.uploadimg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class Gallary extends AppCompatActivity {
    public int[] imageId = new int[]{R.drawable.f1,R.drawable.f2,R.drawable.f3,R.drawable.f4,R.drawable.f5,
            R.drawable.f6,R.drawable.f7,R.drawable.f8,R.drawable.f9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);
        GridView gridView = (GridView)findViewById(R.id.gridView);

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public View getView(int position, View converView, ViewGroup parent) {
                ImageView imageView;
                if(converView==null){
                    imageView = new ImageView(Gallary.this);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxWidth(158);
                    imageView.setMaxHeight(150);
                    imageView.setPadding(5, 5, 5, 5);
                }else{
                    imageView = (ImageView)converView;
                }
                imageView.setImageResource(imageId[position]);
                return imageView;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }
            @Override
            public int getCount() {
                return imageId.length;
            }
        };
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = getIntent();
                Bundle bundle = new Bundle();
                bundle.putInt("imageId", imageId[position]);
                intent.putExtras(bundle);
                setResult(0x11, intent);
                finish();
            }
        });
    }
}