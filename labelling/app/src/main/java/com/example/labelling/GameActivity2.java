package com.example.labelling;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class GameActivity2 extends AppCompatActivity {
    ImageFragment fragment;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_2);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        fragment = new ImageFragment();
        fragment.setImg(R.drawable.iphone);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.img_fragment, fragment);
        fragmentTransaction.commit();
        //fragmentTransaction.

        btn1.setText("벽");
        btn2.setText("티비");
        btn3.setText("아이폰");
        btn4.setText("해당없음");

    }
}