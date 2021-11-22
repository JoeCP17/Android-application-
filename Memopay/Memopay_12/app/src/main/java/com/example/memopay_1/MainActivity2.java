package com.example.memopay_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView text1, text2, text3, text4, text5, text6;
    EditText edit1, edit2, edit3, edit4;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text1 = (TextView) findViewById(R.id.Text1);
        text2 = (TextView) findViewById(R.id.Text2);
        text3 = (TextView) findViewById(R.id.Text3);
        text4 = (TextView) findViewById(R.id.Text4);
        text5 = (TextView) findViewById(R.id.Text5);
        text6 = (TextView) findViewById(R.id.Text6);

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        edit3 = (EditText) findViewById(R.id.Edit3);
        edit4 = (EditText) findViewById(R.id.Edit4);

        btn1 = (Button) findViewById(R.id.Btn1);
        btn2 = (Button) findViewById(R.id.Btn2);

    }
}