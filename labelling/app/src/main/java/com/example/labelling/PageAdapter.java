package com.example.labelling;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

class PageAdapter extends FragmentStatePagerAdapter {
    ArrayList<ImageFragment> fragments = new ArrayList<>();
    Context context;
    public PageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public PageAdapter(@NonNull FragmentManager fm, Context context){
        super(fm);
        this.context=context;
    }

    public void addFragment(ImageFragment imgfrag){
        fragments.add(imgfrag);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
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



}