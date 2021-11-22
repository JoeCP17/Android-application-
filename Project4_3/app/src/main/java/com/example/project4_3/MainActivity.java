package com.example.project4_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText edit1 , edit2;
    Button btnadd , btnmin , btnmul , btndiv , btnsub;
    TextView textresult;
    String num1 , num2 ;
    Float result ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setIcon(R.drawable.pie);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("초간단 계산기 (수정) 김의빈");

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);

        btnadd = (Button) findViewById(R.id.btnadd);
        btnmin = (Button) findViewById(R.id.btnmin);
        btnmul = (Button) findViewById(R.id.btnmul);
        btndiv = (Button) findViewById(R.id.btndiv);
        btnsub = (Button) findViewById(R.id.btnsub);

        textresult = (TextView) findViewById(R.id.textresult);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.trim().equals("") || num2.trim().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(),"입력값이 비었습니다.",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    result = Float.parseFloat(num1) + Float.parseFloat(num2);
                    textresult.setText("계산결과 : " + result.toString());

                }

            }
        });

        btnmin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if(num1.trim().equals("") || num2.trim().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(),"입력값이 비었습니다.",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    result = Float.parseFloat(num1) - Float.parseFloat(num2);
                    textresult.setText("계산결과 : " + result.toString());

                }
            }
        });

        btnmul.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if(num1.trim().equals("") || num2.trim().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(),"입력값이 비었습니다.",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    result = Float.parseFloat(num1) * Float.parseFloat(num2);
                    textresult.setText("계산결과 : " + result.toString());

                }


            }
        });

        btndiv.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                String zero = "0";

                if(num1.trim().equals("") || num2.trim().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(),"입력값이 비었습니다.",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if (num2.equals(zero)) {
                    Toast toast = Toast.makeText(getApplicationContext(), "0으로 나눌수 없습니다." , Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    result = Float.parseFloat(num1) / Float.parseFloat(num2);
                    textresult.setText("계산결과 : " + result.toString());

                }

            }
        });

        btnsub.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if(num1.trim().equals("") || num2.trim().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(),"입력값이 비었습니다.",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    result = Float.parseFloat(num1) % Float.parseFloat(num2);
                    textresult.setText("계산결과 : " + result.toString());

                }

            }
        });
    }
}