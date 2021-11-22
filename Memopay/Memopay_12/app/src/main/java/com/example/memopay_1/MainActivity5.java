package com.example.memopay_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity5 extends AppCompatActivity {
    TabLayout tabs;
    LinearLayout cont1, cont2;
    TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8;
    RadioGroup rdog1, rdog2;
    RadioButton rdob1, rdob2, rdob3, rdob4;
    EditText edit1;
    Button btn1, btn2;
    Spinner spr1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        cont1 = findViewById(R.id.container1);
        cont2 = findViewById(R.id.container2);

        txt1 = findViewById(R.id.Text1);
        txt2 = findViewById(R.id.Text2);
        txt3 = findViewById(R.id.Text3);
        txt4 = findViewById(R.id.Text4);
        txt5 = findViewById(R.id.Text5);
        txt6 = findViewById(R.id.Text6);
        txt7 = findViewById(R.id.Text7);
        txt8 = findViewById(R.id.Text8);

        rdog1 = findViewById(R.id.Riog1);
        rdog2 = findViewById(R.id.Riog2);

        rdob1 = findViewById(R.id.Riob1);
        rdob2 = findViewById(R.id.Riob2);
        rdob3 = findViewById(R.id.Riob3);
        rdob4 = findViewById(R.id.Riob4);

        edit1 = findViewById(R.id.Edit1);

        btn1 = findViewById(R.id.Btn1);
        btn2 = findViewById(R.id.Btn2);

        spr1 = findViewById(R.id.Spr1);

        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("급여"));
        tabs.addTab(tabs.newTab().setText("일정"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                if (position == 0) {
                    cont1.setVisibility(View.VISIBLE);
                    cont2.setVisibility(View.INVISIBLE);
                } else if (position == 1) {
                    cont1.setVisibility(View.INVISIBLE);
                    cont2.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        rdog1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String result;
                if (i == R.id.Riob1){
                    txt3.setVisibility(View.VISIBLE);
                    spr1.setVisibility(View.VISIBLE);
                    txt4.setVisibility(View.VISIBLE);
                    txt5.setVisibility(View.VISIBLE);
                } else {
                    txt3.setVisibility(View.INVISIBLE);
                    spr1.setVisibility(View.INVISIBLE);
                    txt4.setVisibility(View.INVISIBLE);
                    txt5.setVisibility(View.INVISIBLE);
                }
            }
        });
        rdog2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String result;
                if (i == R.id.Riob1){
                    txt8.setVisibility(View.VISIBLE);
                    edit1.setVisibility(View.VISIBLE);
                } else {
                    txt8.setVisibility(View.INVISIBLE);
                    edit1.setVisibility(View.INVISIBLE);
                }
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}