package com.example.project8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button btnPrev , btnNext;
    myPictureView myPicture;
    int curNum=1;
    File[] imageFiles;
    String imageFname;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setIcon(R.drawable.pie);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("과제8_20191415_김의빈");

        ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        textview = (TextView)findViewById(R.id.textview1);
        myPicture = (myPictureView)findViewById(R.id.myPictureView);


        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Pictures").listFiles();
        imageFname = imageFiles[0].toString();
        myPicture.imagePath = imageFname;

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curNum <= 1){
                    curNum = imageFiles.length;
                    imageFname = imageFiles[curNum-1].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    textview.setText(String.valueOf(curNum) + "/" +String.valueOf(imageFiles.length));

                }else {
                    curNum--;
                    imageFname = imageFiles[curNum-1].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    textview.setText(String.valueOf(curNum) + "/" +String.valueOf(imageFiles.length));

                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curNum>=imageFiles.length){
                    curNum=1;
                    imageFname=imageFiles[curNum-1].toString();
                    myPicture.imagePath=imageFname;
                    myPicture.invalidate();
                    textview.setText(String.valueOf(curNum)+"/"+String.valueOf(imageFiles.length));

                }else {
                    curNum++;
                    imageFname = imageFiles[curNum-1].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    textview.setText(String.valueOf(curNum)+"/"+String.valueOf(imageFiles.length));
                }
            }
        });

    }
}