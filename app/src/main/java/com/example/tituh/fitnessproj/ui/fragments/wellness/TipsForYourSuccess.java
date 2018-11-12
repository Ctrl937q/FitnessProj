package com.example.tituh.fitnessproj.ui.fragments.wellness;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.MyViewPagerAdapterDots;
import com.example.tituh.fitnessproj.adapters.ViewPagerAdapterForTips;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

public class TipsForYourSuccess extends BaseFragment {

    private ViewPager mViewPager;
    private WellnessTipsForSuccessFirstScreen firstFragmentTips;
    private WellnessTipsForSuccessSecondScreen secondFragemntTips;
    TabLayout tabDotLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.wellness_tips_tab_layout, container, false);
        ((MainActivity) getActivity()).updateActionBarTitle("8 TIPS FOR YOUR SUCCESS");
        ((MainActivity) getActivity()).visibleIconBacktActionBar();

        mViewPager = (ViewPager)rootView.findViewById(R.id.view_pager_tips);
        tabDotLayout = (TabLayout)rootView.findViewById(R.id.tabDots);

        tabDotLayout.setupWithViewPager(mViewPager, true);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        setupViewPager(mViewPager);

        return rootView;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapterForTips viewPagerAdapter = new ViewPagerAdapterForTips(getChildFragmentManager());
        firstFragmentTips = new WellnessTipsForSuccessFirstScreen();
        secondFragemntTips = new WellnessTipsForSuccessSecondScreen();
        viewPagerAdapter.addFragment(firstFragmentTips);
        viewPagerAdapter.addFragment(secondFragemntTips);
        viewPager.setAdapter(viewPagerAdapter);
    }


}
