package com.example.memopay_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity6 extends AppCompatActivity {

    ImageButton ibtn1;
    TextView txt1, txt2;
    ListView list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        ibtn1 = findViewById(R.id.back);
        txt1 = findViewById(R.id.placeadd);
        txt2 = findViewById(R.id.placeedit);
        list1 = findViewById(R.id.workplace);

        ibtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity8.class);
                startActivity(intent1);
            }
        });

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity5.class);
                startActivity(intent1);
            }
        });



    }
}