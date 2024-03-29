package com.example.example5_5;

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
    Button btnadd , btnmin , btnmul , btndiv ;
    TextView textresult;
    String num1 , num2 ;
    Integer result ;
    Button[] numButtons=new Button[10];
    Integer[] numBtnlds = {R.id.btn0 ,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,
            R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8 , R.id.btn9};

    int i;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setIcon(R.drawable.pie);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("과제4_20191415_김의빈");

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);

        btnadd = (Button) findViewById(R.id.btnAdd);
        btnmin = (Button) findViewById(R.id.btnMin);
        btnmul = (Button) findViewById(R.id.btnMul);
        btndiv = (Button) findViewById(R.id.btnDiv);


        textresult = (TextView) findViewById(R.id.textRes);


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
                    result = Integer.parseInt(num1) + Integer.parseInt(num2);
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
                    result = Integer.parseInt(num1) - Integer.parseInt(num2);
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
                    result = Integer.parseInt(num1) * Integer.parseInt(num2);
                    textresult.setText("계산결과 : " + result.toString());

                }


            }
        });

        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1=edit1.getText().toString();
                num2=edit2.getText().toString();
                result=Integer.parseInt(num1)/Integer.parseInt(num2);
                textresult.setText("계산결과: "+result.toString());
            }
        });
        for(i=0;i<numBtnlds.length;i++)
            numButtons[i]=(Button)findViewById(numBtnlds[i]);

        for(i=0;i<numBtnlds.length;i++)
        {
            final int index;
            index=i;
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(edit1.isFocused()==true)
                    {
                        num1=edit1.getText().toString()+numButtons[index].getText().toString();
                        edit1.setText(num1);
                    }
                    else if(edit2.isFocused()==true)
                    {
                        num2=edit2.getText().toString()+numButtons[index].getText().toString();
                        edit2.setText(num2);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"선택하세요..",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}