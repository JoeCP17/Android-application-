package com.example.fragement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainfragment);
        menuFragment = new MenuFragment();

    }

    public void onFragmentChanged(int index) {

        if (index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,menuFragment).commit();
        } else if (index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,mainFragment).commit();

        }
    }
    }
