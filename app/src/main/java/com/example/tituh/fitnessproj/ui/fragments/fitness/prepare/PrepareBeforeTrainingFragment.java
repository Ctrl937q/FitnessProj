package com.example.tituh.fitnessproj.ui.fragments.fitness.prepare;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.ViewPagerAdapter;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

public class PrepareBeforeTrainingFragment extends BaseFragment {

    FitnessPrepareTabFragmentStretch mFirstStretchFragment;
    FitnessPrepareTabFragmentYoga mSecondYogaFragment;
    FitnessPrepareTabFragmentIncreaseTheBurn1 mFirstIncreaseTheBurnFragment;
    FitnessPrepareTabFragmentIncreaseTheBurn2 mSecondIncreaseTheBurnFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fitness_prepare_before_training, container, false);
        ((MainActivity) getActivity()).updateActionBarTitle("PREPARE");
        ((MainActivity) getActivity()).visibleIconBacktActionBar();
        ((MainActivity) getActivity()).goneIconAbouttActionBar();

        ViewPager mViewPagerFirst = rootView.findViewById(R.id.fitness_prepare_view_pager_1);
        ViewPager mViewPagerSecond = rootView.findViewById(R.id.fitness_prepare_view_pager_2);
        TabLayout tabLayoutFirst = (TabLayout)rootView.findViewById(R.id.fitness_prepare_tabDots_1);
        TabLayout tabLayoutSecond = (TabLayout)rootView.findViewById(R.id.fitness_prepare_tabDots_2);
        tabLayoutFirst.setupWithViewPager(mViewPagerFirst, true);
        tabLayoutSecond.setupWithViewPager(mViewPagerSecond, true);

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


        mViewPagerSecond.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

        setupViewPagerFirst(mViewPagerFirst);
        setupViewPagerSecond(mViewPagerSecond);
        return rootView;
    }


    private void setupViewPagerFirst(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mFirstStretchFragment = new FitnessPrepareTabFragmentStretch();
        mSecondYogaFragment = new FitnessPrepareTabFragmentYoga();
        viewPagerAdapter.addFragment(mFirstStretchFragment);
        viewPagerAdapter.addFragment(mSecondYogaFragment);
        viewPager.setAdapter(viewPagerAdapter);
    }


    private void setupViewPagerSecond(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mFirstIncreaseTheBurnFragment = new FitnessPrepareTabFragmentIncreaseTheBurn1();
        mSecondIncreaseTheBurnFragment = new FitnessPrepareTabFragmentIncreaseTheBurn2();
        viewPagerAdapter.addFragment(mFirstIncreaseTheBurnFragment);
        viewPagerAdapter.addFragment(mSecondIncreaseTheBurnFragment);
        viewPager.setAdapter(viewPagerAdapter);
    }


}
