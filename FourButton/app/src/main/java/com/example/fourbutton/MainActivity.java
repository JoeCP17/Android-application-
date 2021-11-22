package com.example.fourbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.net.Uri;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.icon);


    }
    public void onButton1Click(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://m.nate.com"));
        startActivity(intent);
    }

    public void onButton2Click (View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:/911"));
        startActivity(intent);
    }

    public void onButton3Click (View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("content://media/internal/images/media"));
        startActivity(intent);
    }

    public void onButton4Click (View view) {
        finish();
    }


}