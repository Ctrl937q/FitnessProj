package com.example.tituh.fitnessproj.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyViewPagerAdapterDots extends PagerAdapter {

    private LayoutInflater layoutInflater_l;
    private Context context;
    private int[] layouts;

    public MyViewPagerAdapterDots(int[] layouts, Context context) {
        this.layouts = layouts;
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater_l = LayoutInflater.from(context);
        View view = layoutInflater_l.inflate(layouts[position], container, false);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}