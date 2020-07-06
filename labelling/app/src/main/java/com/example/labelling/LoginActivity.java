package com.example.labelling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText emailview;
    EditText passwordview;
    Button login_btn;
    Button join_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailview = findViewById(R.id.email_text);
        passwordview = findViewById(R.id.password_text);

        login_btn = findViewById(R.id.login_btn);
        join_btn = findViewById(R.id.join_btn);

        login_btn.setOnClickListener(this);
        join_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_btn:
                Intent login_intent = new Intent(this.getApplicationContext(), GameActivity1.class);
                //Intent login_intent = new Intent(this.getApplicationContext(), SlideActivity.class);
                login_intent.putExtra("email", emailview.getText().toString());
                login_intent.putExtra("password", passwordview.getText().toString());
                // db접근 아이디/비번 확인
                startActivity(login_intent);
                break;
            case R.id.join_btn:
                Intent join_intent = new Intent(this.getApplicationContext(), SignupActivity.class);
                startActivity(join_intent);
                break;
        }
    }

    // django db 접근 아이디비번 유효 확인
}