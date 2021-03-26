package com.jaywhen.regitered;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private String phone_str = "";
    private String password_str = "";
    private String gender_str = "woman";
    private String hobby_str = "1";
    private String city_str = "";

    EditText phone_edit, password_edit;
    RadioGroup gender_group;
    RadioButton man_btn, woman_btn;
    CheckBox play_ball, reading, music;
    Button registered;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone_edit = (EditText) findViewById(R.id.editTextPhone);
        password_edit = (EditText) findViewById(R.id.editTextTextPassword);
        gender_group = (RadioGroup)findViewById(R.id.radioGroup);
        gender_group.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) this);
        man_btn = (RadioButton) findViewById(R.id.radioButton10);
        woman_btn = (RadioButton) findViewById(R.id.radioButton11);
        reading = (CheckBox)findViewById(R.id.checkBox);
        play_ball = (CheckBox)findViewById(R.id.checkBox2);
        music = (CheckBox)findViewById(R.id.checkBox3);
        registered = (Button)findViewById(R.id.button);
        spinner = (Spinner)findViewById(R.id.spinner);
        registered.setOnClickListener((View.OnClickListener) this);
        final String[] city = new String[] {"北京", "上海", "广州", "深圳", "重庆"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, city);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                city_str = city[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                phone_str = phone_edit.getText().toString();
                password_str = password_edit.getText().toString();
                hobby_str = "";
                if(reading.isChecked()) {
                    hobby_str += reading.getText().toString() + " ";
                }
                if (play_ball.isChecked()) {
                    hobby_str += play_ball.getText().toString() + " ";
                }
                if (music.isChecked()) {
                    hobby_str += music.getText().toString();
                }
                Intent intent = new Intent(this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("phone", phone_str);
                bundle.putString("password", password_str);
                bundle.putString("gender", gender_str);
                bundle.putString("hobby", hobby_str);
                bundle.putString("city", city_str);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        gender_str = i == R.id.radioButton10 ? "man" : "woman";
    }
}