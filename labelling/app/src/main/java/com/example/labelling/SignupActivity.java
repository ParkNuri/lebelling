package com.example.labelling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
    EditText emailview;
    EditText passwordview;
    EditText checkpassview;
    EditText nameview;
    EditText birthview;
    EditText phoneview;
    EditText jobview;

    Button submit_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        emailview = findViewById(R.id.email);
        passwordview = findViewById(R.id.password);
        checkpassview = findViewById(R.id.password_check);
        nameview = findViewById(R.id.name);
        birthview = findViewById(R.id.birthday);
        phoneview = findViewById(R.id.phone);
        jobview = findViewById(R.id.job);

        submit_btn = findViewById(R.id.submit_btn);

        // email 형식 check
        emailview.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){

                }
            }
        });

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailview.getText().toString();
                passwordview.getText().toString();
                checkpassview.getText().toString();
                nameview.getText().toString();
                birthview.getText().toString();
                phoneview.getText().toString();
                jobview.getText().toString();

            }
        });
    }

    // django db로 보내기
    // 1. signup
    // 2. update userinfo

}