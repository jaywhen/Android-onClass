package com.jaywhen.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int year, month, day;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                builder.setTitle("Warning!");
                builder.setMessage("请确认数据保存后再退出!");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "exit!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Cancel ...", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

        DatePicker datePicker;
        datePicker = findViewById(R.id.date);
        Calendar calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MainActivity.this.year = year;
                MainActivity.this.month = monthOfYear;
                MainActivity.this.day = dayOfMonth;
                textView = findViewById(R.id.textView);
                String dateMsg = MainActivity.this.year + "." + MainActivity.this.month + "." + MainActivity.this.day;
                textView.setText(dateMsg);
            }
        });

    }
}