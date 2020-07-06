package com.example.labelling;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;

import java.util.ArrayList;

public class SlideActivity extends AppCompatActivity implements View.OnTouchListener, GestureDetector.OnGestureListener {
    ImageFragment fragment;
    TextView textView;
    LinearLayout outerview;

    ViewPager pager;

    GestureDetectorCompat detector;

    ArrayList<ImageFragment> fragments = new ArrayList<>();

    Scroller scroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_1);

        outerview = findViewById(R.id.outerview);

        textView = findViewById(R.id.textView);

        detector = new GestureDetectorCompat(this, this);

        outerview.setOnTouchListener(this);

        //pager = new ViewPager();


        int[] imgs = {R.drawable.iphone, R.drawable.human};
        for(int i = 0; i<imgs.length;i++){
            fragment = new ImageFragment();
            fragment.setImg(imgs[i]);
            fragments.add(fragment);

        }
        setFragment(fragments.get(0));



    }

    // 화면에 보여질 fragment setting
    public void setFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.replace(R.id.imgfragment, fragment);
        fragmentTransaction.commit();
    }

    /////////////////////////////////////////////////////////////////////////

    /*class PageAdapter extends FragmentStatePagerAdapter {
        ArrayList<ImageFragment> fragments = new ArrayList<>();

        public PageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        public void addFragment(ImageFragment imgfrag){
            fragments.add(imgfrag);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

    }*/



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // touch listener
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        detector.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                textView.setText("");
                return true;
            case MotionEvent.ACTION_UP:
                return false;
            case MotionEvent.ACTION_MOVE:
                return true;
        }
        return false;
    }

    public int checkDrag(float sX,float sY,float eX,float eY){
        int move = (int)(sX-eX);
        if(move>0){ //
            Log.d("move", "left to right");
        }else {
            Log.d("move", "right to left");
        }
        return 0;
    }


    // gestureListener /////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean onDown(MotionEvent e) {
        Log.d("Motion", "down");
        textView.append("down\n");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.d("Motion", "onShowPress");
        textView.append("onShowPress\n");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.d("Motion", "onSingleTapUp");
        textView.append("onSingleTapUp\n");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.d("Motion", "onScroll");
        textView.append("onScroll\n");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.d("Motion", "onLongPress");
        textView.append("onLongPress\n");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.d("Motion", "onFling");
        textView.append("onFling\n");
        return false;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
}