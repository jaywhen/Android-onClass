package com.jaywhen.fuzz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LifeCycleActivity extends AppCompatActivity {

    private static String TAG = "LIFECYCLE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d(TAG, "(1) onCreate()");

        Log.v(TAG, "Verbose");
        Log.d(TAG, "Debug");
        Log.i(TAG, "Info");
        Log.w(TAG, "Warn");
        Log.e(TAG, "Error");

        Button btn = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LifeCycleActivity.this, "You cliked Quit App",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "(2) onStart()");
    }

    // 在 onStart() 后被调用，用于恢复 onSaveInstanceState() 保存的用户界面消息
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "(3) onRestoreInstanceState()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "(4) onResume()");
    }

    // 在onPause ()后被调用，保存界面信息
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "(5) onSaveInstanceState()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "(6) onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "(7) onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "(8) onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "(9) onDestroy()");
    }
}