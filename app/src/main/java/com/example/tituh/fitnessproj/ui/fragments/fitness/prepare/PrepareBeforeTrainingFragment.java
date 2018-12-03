package com.example.tituh.fitnessproj.ui.fragments.fitness.prepare;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.ViewPagerAdapter;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout.ChooseLevelFragment;

public class PrepareBeforeTrainingFragment extends BaseFragment implements View.OnClickListener {

    private FitnessPrepareTabFragmentStretch mFirstStretchFragment;
    private FitnessPrepareTabFragmentYoga mSecondYogaFragment;
    private FitnessPrepareTabFragmentIncreaseTheBurn1 mFirstIncreaseTheBurnFragment;
    private FitnessPrepareTabFragmentIncreaseTheBurn2 mSecondIncreaseTheBurnFragment;

    private Button mButton1StartWorkout;
    private Button mButton2StartWorkout;
    private Button mButton3StartWorkout;
    private Button mButton4StartWorkout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fitness_prepare_before_training, container, false);
            fragmentInteractionListener.updateActionBarTitle("PREPARE");
            fragmentInteractionListener.visibleIconBacktActionBar();
            fragmentInteractionListener.goneIconAbouttActionBar();

            ViewPager mViewPagerFirst = view.findViewById(R.id.fitness_prepare_view_pager_1);
            ViewPager mViewPagerSecond = view.findViewById(R.id.fitness_prepare_view_pager_2);
            TabLayout tabLayoutFirst = view.findViewById(R.id.fitness_prepare_tabDots_1);
            TabLayout tabLayoutSecond = view.findViewById(R.id.fitness_prepare_tabDots_2);

            mButton1StartWorkout = view.findViewById(R.id.button1_start_workout);
            mButton2StartWorkout = view.findViewById(R.id.button2_start_workout);
            mButton3StartWorkout = view.findViewById(R.id.button3_start_workout);
            mButton4StartWorkout = view.findViewById(R.id.button4_start_workout);

            mButton1StartWorkout.setOnClickListener(this);
            mButton2StartWorkout.setOnClickListener(this);
            mButton3StartWorkout.setOnClickListener(this);
            mButton4StartWorkout.setOnClickListener(this);

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
        }
        return view;
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1_start_workout:
                fragmentInteractionListener.pushFragment(new ChooseLevelFragment(), false);
                break;
            case R.id.button2_start_workout:
                fragmentInteractionListener.pushFragment(new ChooseLevelFragment(), false);
                break;
            case R.id.button3_start_workout:
                fragmentInteractionListener.pushFragment(new ChooseLevelFragment(), false);
                break;
            case R.id.button4_start_workout:
                fragmentInteractionListener.pushFragment(new ChooseLevelFragment(), false);
                break;
        }
    }


    @Override
    public void onDestroyView() {
        fragmentInteractionListener.updateActionBarTitle("TSC BODY");
        super.onDestroyView();
    }
}
