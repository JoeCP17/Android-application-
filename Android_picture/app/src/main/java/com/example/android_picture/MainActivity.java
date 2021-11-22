package com.example.android_picture;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView1 , textView2 ;
    Switch switchstart;
    RadioGroup Rgroup;
    RadioButton radiooreo , radiopie , radioq10 ;
    Button buttonend , buttonreturn ;
    ImageView imageView1 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진보기(김의빈)");
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        textView1 =(TextView) findViewById(R.id.textView);
        textView2 =(TextView) findViewById(R.id.textView2);
        switchstart =(Switch) findViewById(R.id.switchstart);
        Rgroup = (RadioGroup) findViewById(R.id.Rgroup);
        radiooreo = (RadioButton) findViewById(R.id.radiooreo);
        radiopie = (RadioButton) findViewById(R.id.radiopie);
        radioq10 = (RadioButton) findViewById(R.id.radioq10);
        buttonend = (Button) findViewById(R.id.buttonend);
        buttonreturn = (Button) findViewById(R.id.buttonreturn);

        imageView1 = (ImageView)findViewById(R.id.imageView1);

        switchstart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switchstart.isChecked()==true) {
                    textView2.setVisibility(android.view.View.VISIBLE);
                    Rgroup.setVisibility(android.view.View.VISIBLE);
                    buttonend.setVisibility(android.view.View.VISIBLE);
                    buttonreturn.setVisibility(android.view.View.VISIBLE);
                    imageView1.setVisibility(android.view.View.VISIBLE);
                }
                else {
                    textView2.setVisibility(android.view.View.INVISIBLE);
                    Rgroup.setVisibility(android.view.View.INVISIBLE);
                    buttonend.setVisibility(android.view.View.INVISIBLE);
                    buttonreturn.setVisibility(android.view.View.INVISIBLE);
                    imageView1.setVisibility(android.view.View.INVISIBLE);
                }
            }

        });

        Rgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (Rgroup.getCheckedRadioButtonId()) {
                    case R.id.radiooreo:
                        imageView1.setImageResource(R.drawable.oreo);
                        break;
                    case R.id.radiopie:
                        imageView1.setImageResource(R.drawable.pie);
                        break;

                    case R.id.radioq10:
                        imageView1.setImageResource(R.drawable.q10);
                        break;
                }
            }
        });

        buttonend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchstart.setChecked(false);
                radiooreo.setChecked(false);
                radiopie.setChecked(false);
                radioq10.setChecked(false);
                imageView1.setImageBitmap(null);
            }
        });




    }
}