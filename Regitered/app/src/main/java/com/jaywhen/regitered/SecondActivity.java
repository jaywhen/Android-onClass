package com.jaywhen.regitered;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        String phone = bundle.getString("phone");
        String password = bundle.getString("password");
        String gender = bundle.getString("gender");
        String hobby = bundle.getString("hobby");
        String city = bundle.getString("city");
        TextView show = (TextView) findViewById(R.id.textView);
        show.setText("Phone: " + phone+ "\n" + "Password: " + password + "\n" + "Gender: " + gender + "\n" + "Hobby: " + hobby + "\n" + "City: " + city);
    }
}