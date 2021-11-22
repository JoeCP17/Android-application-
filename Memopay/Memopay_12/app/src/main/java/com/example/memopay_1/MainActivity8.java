package com.example.memopay_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity8 extends AppCompatActivity {

    EditText edt1, edt2, edt3, edt4;
    CheckBox cbox1, cbox2, cbox3, cbox4, cbox5, cbox6, cbox7, cbox8, cbox9, cbox10, cbox11;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        edt1 = findViewById(R.id.name);
        edt2 = findViewById(R.id.hourlywage);
        edt3 = findViewById(R.id.gotowork);
        edt4 = findViewById(R.id.gotohome);

        cbox1 = findViewById(R.id.mon);
        cbox2 = findViewById(R.id.tue);
        cbox3 = findViewById(R.id.wed);
        cbox4 = findViewById(R.id.thr);
        cbox5 = findViewById(R.id.fri);
        cbox6 = findViewById(R.id.sat);
        cbox7 = findViewById(R.id.sun);
        cbox8 = findViewById(R.id.cb1);
        cbox9 = findViewById(R.id.cb2);
        cbox10 = findViewById(R.id.cb3);
        cbox11 = findViewById(R.id.cb4);

        btn1 = findViewById(R.id.Add);
        btn2 = findViewById(R.id.Can);




        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}