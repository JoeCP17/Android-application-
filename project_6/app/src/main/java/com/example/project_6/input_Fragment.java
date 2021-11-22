package com.example.project_6;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class input_Fragment extends Fragment {

    private TextView nameText , ageText , birthText ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_input_,
                container, false);


        nameText = (TextView)  rootView.findViewById(R.id.textView);
        ageText = (TextView)  rootView.findViewById(R.id.textView2);
        birthText = (TextView)  rootView.findViewById(R.id.textView3);

        if (getArguments()!=null){
            String name,age,birth;
            name=getArguments().getString("name");
            age=getArguments().getString("age");
            birth=getArguments().getString("birth");

            nameText.setText(name);
            ageText.setText(age);
            birthText.setText(birth);
        }



        return rootView;
    }

}