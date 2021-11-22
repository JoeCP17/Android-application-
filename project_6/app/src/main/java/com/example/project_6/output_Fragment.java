package com.example.project_6;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.project_6.R;


public class output_Fragment extends Fragment {

    private Button btn;
    EditText name , age , birth;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_output_,
                container, false);


        name = (EditText) rootView.findViewById(R.id.Name);
        age = (EditText)rootView.findViewById(R.id.Age);
        birth = (EditText)rootView.findViewById(R.id.birthday);
        btn = (Button) rootView.findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putString("name" , name.getText().toString());
                    bundle.putString("age" , age.getText().toString());
                    bundle.putString("birth" ,birth.getText().toString());

                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                input_Fragment input_fragment=new input_Fragment();
                input_fragment.setArguments(bundle);

                transaction.replace(R.id.frame_result,input_fragment);
                transaction.commit();




                name.setText("");
                age.setText("");
                birth.setText("");

                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(name.getWindowToken() , 0);
                imm.hideSoftInputFromWindow(age.getWindowToken() , 0);
                imm.hideSoftInputFromWindow(birth.getWindowToken() , 0);

            }
        });

        return rootView;

    }



}