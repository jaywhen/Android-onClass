package com.example.camera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SeeView extends AppCompatActivity {
    //用于保存照片路径
    private String path;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_view);
        iv = findViewById(R.id.id_image);
        //获取到拍照后的照片路径
        path = getIntent().getStringExtra("picPath");
        try {
            FileInputStream fis = new FileInputStream(path);
            //通过文件输入流获取到图片
            Bitmap bm = BitmapFactory.decodeStream(fis);
            //创建一个矩阵对象
            Matrix matrix = new Matrix();
            matrix.setRotate(90);//调整角度
            //创建一个新的图片 调整其矩阵方向
            bm = Bitmap.createBitmap(bm, 0, 0,
                    bm.getWidth(), bm.getHeight(), matrix, true);
            iv.setImageBitmap(bm);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
