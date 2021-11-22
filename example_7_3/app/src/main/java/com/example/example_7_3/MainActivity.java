package com.example.example_7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name , email ;
    EditText edname , edemail;
    TextView toastText;
    View dialogView , toastView;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("과제7_20191415_김의빈");

        name = (EditText) findViewById(R.id.tvName);
        email = (EditText) findViewById(R.id.tvEmail);

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View)View.inflate(MainActivity.this,R.layout.dialog1,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.mipmap.ic_menu_allfriends);
                dlg.setView(dialogView);
                edname = (EditText) dialogView.findViewById(R.id.edit1);
                edemail = (EditText) dialogView.findViewById(R.id.edit2);

                edname.setText(name.getText());
                edemail.setText(email.getText());
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        name.setText(edname.getText());
                        email.setText(edemail.getText());
                    }
                });

                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = new Toast(MainActivity.this);
                        toastView = (View) View.inflate(MainActivity.this,R.layout.toast1,null);
                        toastText = (TextView)toastView.findViewById(R.id.textView);
                        toastText.setText("취소했습니다.");
                        toast.setView(toastView);
                        Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        int xoffset=(int)(Math.random()*display.getWidth());
                        int yoffset=(int)(Math.random()*display.getHeight());
                        toast.setGravity(Gravity.TOP | Gravity.LEFT,xoffset,yoffset);
                        toast.show();

                    }
                });
                dlg.show();

            }
        });







    }
}