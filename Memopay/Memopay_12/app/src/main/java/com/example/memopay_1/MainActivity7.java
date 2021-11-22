package com.example.memopay_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity7 extends AppCompatActivity {
    ImageButton plus, back;
    LinearLayout input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        plus=(ImageButton)findViewById(R.id.plus);
        input=(LinearLayout)findViewById(R.id.input);
        back=(ImageButton)findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setVisibility(View.VISIBLE);

            }
        });

    }
}