package com.example.tituh.fitnessproj.ui.fragments.fitness.prepare;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.ViewPagerAdapterForStretchAndYoga;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

public class PrepareBeforeTrainingFragment extends BaseFragment {

    FitnessPrepareTabFragmentStretch firstFragment;
    FitnessPrepareTabFragmentYoga secondFragemnt;
    CardView cardView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fitness_prepare_before_training, container, false);
        ((MainActivity) getActivity()).updateActionBarTitle("PREPARE");
        ((MainActivity) getActivity()).visibleIconBacktActionBar();
        ((MainActivity) getActivity()).goneIconAbouttActionBar();

        ViewPager mViewPagerFirst = rootView.findViewById(R.id.fitness_prepare_view_pager_1);
        TabLayout tabLayout = (TabLayout)rootView.findViewById(R.id.fitness_prepare_tabDots_1);
        tabLayout.setupWithViewPager(mViewPagerFirst, true);


        mViewPagerFirst.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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


        setupViewPager(mViewPagerFirst);
        return rootView;
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapterForStretchAndYoga viewPagerAdapter = new ViewPagerAdapterForStretchAndYoga(getChildFragmentManager());
        firstFragment = new FitnessPrepareTabFragmentStretch();
        secondFragemnt = new FitnessPrepareTabFragmentYoga();
        viewPagerAdapter.addFragment(firstFragment);
        viewPagerAdapter.addFragment(secondFragemnt);
        viewPager.setAdapter(viewPagerAdapter);

    }

}
