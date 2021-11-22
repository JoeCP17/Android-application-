package com.example.project6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chro;
    RadioButton rbtn1 , rbtn2;
    DatePicker date;
    TimePicker time;
    TextView year , month , day , hour , minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setIcon(R.drawable.pie);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("과제5_20191415_김의빈");

        chro = (Chronometer) findViewById(R.id.time);

        rbtn1 = (RadioButton)findViewById(R.id.btn1);
        rbtn2 = (RadioButton)findViewById(R.id.btn2);

        date = (DatePicker)findViewById(R.id.datePicker1);
        time = (TimePicker)findViewById(R.id.timePicker1);

        year = (TextView)findViewById(R.id.tvYear);
        month = (TextView)findViewById(R.id.tvMonth);
        day = (TextView)findViewById(R.id.tvDay);
        hour = (TextView)findViewById(R.id.tvHour);
        minute = (TextView)findViewById(R.id.tvMinute);

        date.setVisibility(View.INVISIBLE);
        time.setVisibility(View.INVISIBLE);
        rbtn1.setVisibility(View.INVISIBLE);
        rbtn2.setVisibility(View.INVISIBLE);

        chro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chro.setBase(SystemClock.elapsedRealtime());
                chro.start();
               rbtn1.setVisibility(View.VISIBLE);
               rbtn2.setVisibility(View.VISIBLE);
            }
        });

        rbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time.setVisibility(View.INVISIBLE);
                date.setVisibility(View.VISIBLE);
            }
        });

        rbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time.setVisibility(View.VISIBLE);
                date.setVisibility(View.INVISIBLE);
            }
        });


        year.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View view) {
                chro.stop();
                chro.setTextColor(Color.BLUE);
                year.setText(Integer.toString(date.getYear()));
                month.setText(Integer.toString(1+date.getMonth()));
                day.setText(Integer.toString(date.getDayOfMonth()));
                hour.setText(Integer.toString(time.getCurrentHour()));
                minute.setText(Integer.toString(time.getCurrentMinute()));
                rbtn1.setVisibility(View.INVISIBLE);
                rbtn2.setVisibility(View.INVISIBLE);
                date.setVisibility(View.INVISIBLE);
                time.setVisibility(View.INVISIBLE);
                return false;
            }
        });




    }
}