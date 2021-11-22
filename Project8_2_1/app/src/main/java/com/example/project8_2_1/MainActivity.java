package com.example.project8_2_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    myPictureView myPicture;
    Button btnprev,btnNext;
    int curNum =1 ;
    File[] imageFiles;
    String imageFname;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("과제8_20191415_김의빈");

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        btnprev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        textView = (TextView) findViewById(R.id.textView1);
        myPicture = (myPictureView) findViewById(R.id.myPictureView);

        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures").listFiles();
        imageFname = imageFiles[0].toString();
        myPicture.imagePath = imageFname;

        btnprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curNum <= 1) {
                curNum = imageFiles.length;
                imageFname = imageFiles[curNum-1].toString();
                myPicture.imagePath = imageFname;
                myPicture.invalidate();
                textView.setText(String.valueOf(curNum) + "/" + String.valueOf(imageFiles.length));
                }
                else
                {
                    curNum -- ;
                    imageFname = imageFiles[curNum-1].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    textView.setText(String.valueOf(curNum) + "/" + String.valueOf(imageFiles.length));
                }
            }

        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curNum >= imageFiles.length)
                {
                    curNum = 1 ;
                    imageFname = imageFiles[curNum-1].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    textView.setText(String.valueOf(curNum) + "/" + String.valueOf(imageFiles.length));
                }
                else
                {
                    curNum++;
                    imageFname = imageFiles[curNum-1].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    textView.setText(String.valueOf(curNum) + "/" + String.valueOf(imageFiles.length));
                }
            }
        });
    }
}