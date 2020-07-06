package com.example.labelling;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity1 extends AppCompatActivity implements View.OnTouchListener {
    ImageFragment fragment;
    TextView textView;
    LinearLayout outerview;

    ViewPager viewpager;

    float startX;
    float startY;
    float endX;
    float endY;

    ArrayList<ImageFragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_1);

        viewpager = findViewById(R.id.viewpager);

        outerview = findViewById(R.id.outerview);

        textView = findViewById(R.id.textView);

        outerview.setOnTouchListener(this);

        FragmentManager manager = getSupportFragmentManager();

        PageAdapter adapter = new PageAdapter(manager, getApplicationContext());

        int[] imgs = {R.drawable.iphone, R.drawable.human};
        for(int i = 0; i<imgs.length;i++){
            fragment = new ImageFragment();
            fragment.setImg(imgs[i]);
            //fragments.add(fragment);
            adapter.addFragment(fragment);
        }

        viewpager.setAdapter(adapter);
        //setFragment(fragments.get(0));

    }

    // 화면에 보여질 fragment setting
    /*public void setFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.imgfragment, fragment);
        fragmentTransaction.commit();
    }*/


    class ViewPager extends androidx.viewpager.widget.ViewPager{

        public ViewPager(@NonNull Context context) {
            super(context);
        }

        @Override
        public void addOnPageChangeListener(@NonNull OnPageChangeListener listener) {
            super.addOnPageChangeListener(listener);
        }
    }


    /////////////////////////////////////////////////////////////////////////

    // touch listener
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                startX = x;
                startY = y;
                textView.setText("");
                return true;
            case MotionEvent.ACTION_UP:
                endX = x;
                endY = y;
                return false;
            case MotionEvent.ACTION_MOVE:

                return true;
        }
        return false;

    }


}