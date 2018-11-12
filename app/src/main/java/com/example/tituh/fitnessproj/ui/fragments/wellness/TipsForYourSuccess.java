package com.example.tituh.fitnessproj.ui.fragments.wellness;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.MyViewPagerAdapterDots;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

public class TipsForYourSuccess extends BaseFragment {

    private ViewPager viewPager;
    private MyViewPagerAdapterDots myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    private PrefManager prefManager;
    LayoutInflater layoutInflater_l;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutInflater_l = inflater;
        View rootView = inflater.inflate(R.layout.tips_for_your_success, container, false);
        ((MainActivity) getActivity()).updateActionBarTitle("8 TIPS FOR YOUR SUCCESS");
        ((MainActivity) getActivity()).visibleIconBacktActionBar();

        prefManager = new PrefManager(getActivity());
        if (!prefManager.isFirstTimeLaunch()) {
            getActivity().finish();
        }
        viewPager = (ViewPager)rootView.findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout)rootView.findViewById(R.id.layoutDots);
        layouts = new int[]{
                R.layout.tips_for_success_first_screen,
                R.layout.tips_for_success_second_screen,
        };
        addBottomDots(0);
        myViewPagerAdapter = new MyViewPagerAdapterDots(layouts, getActivity());
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        return rootView;
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];
        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getActivity());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(45);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }
        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }
}
