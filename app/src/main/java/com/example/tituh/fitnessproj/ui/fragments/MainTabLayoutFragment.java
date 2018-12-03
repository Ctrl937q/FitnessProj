package com.example.tituh.fitnessproj.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.ViewPagerAdapter;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.about.AboutFragment;
import com.example.tituh.fitnessproj.ui.fragments.community.CommunityFragment;
import com.example.tituh.fitnessproj.ui.fragments.fitness.FitnessFragment;
import com.example.tituh.fitnessproj.ui.fragments.nutrition.NutritionFragment;
import com.example.tituh.fitnessproj.ui.fragments.wellness.WellnessFragment;

public class MainTabLayoutFragment extends BaseFragment {

    private BottomNavigationView mBottomNavigationView;
    private ViewPager mViewPager;
    private MenuItem mPrevMenuItem;

    private AboutFragment mAboutFragment;
    private FitnessFragment mFitnessFragment;
    private NutritionFragment mNutritionFragment;
    private WellnessFragment mWellnessFragment;
    private CommunityFragment mCommunityFragment;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.main_tab_layout_fragment, container, false);

            mBottomNavigationView = view.findViewById(R.id.bottom_navigation_bar);
            mViewPager = view.findViewById(R.id.view_pager);

            mBottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

            mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {

                }

                @Override
                public void onPageSelected(int i) {
                    switch (i) {
                        case 0:
                            fragmentInteractionListener.updateActionBarTitle("ABOUT");
                            break;
                        case 1:
                            fragmentInteractionListener.updateActionBarTitle("TSC BODY");
                            break;
                        case 2:
                            fragmentInteractionListener.updateActionBarTitle("NUTRITION");
                            break;
                        case 3:
                            fragmentInteractionListener.updateActionBarTitle("WELLNESS");
                            break;
                        case 4:
                            fragmentInteractionListener.updateActionBarTitle("COMMUNITY");
                            break;
                    }

                    if (mPrevMenuItem != null) {
                        mPrevMenuItem.setChecked(false);
                    } else {
                        mBottomNavigationView.getMenu().getItem(0).setChecked(false);
                    }
                    mBottomNavigationView.getMenu().getItem(i).setChecked(true);
                    mPrevMenuItem = mBottomNavigationView.getMenu().getItem(i);
                }

                @Override
                public void onPageScrollStateChanged(int i) {

                }
            });

            setupViewPager(mViewPager);
        }

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mAboutFragment = new AboutFragment();
        mFitnessFragment = new FitnessFragment();
        mNutritionFragment = new NutritionFragment();
        mWellnessFragment = new WellnessFragment();
        mCommunityFragment = new CommunityFragment();

        viewPagerAdapter.addFragment(mAboutFragment);
        viewPagerAdapter.addFragment(mFitnessFragment);
        viewPagerAdapter.addFragment(mNutritionFragment);
        viewPagerAdapter.addFragment(mWellnessFragment);
        viewPagerAdapter.addFragment(mCommunityFragment);
        viewPager.setAdapter(viewPagerAdapter);
    }

    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.item_about:
                    mViewPager.setCurrentItem(0);
                    break;
                case R.id.item_fitness:
                    mViewPager.setCurrentItem(1);
                    break;
                case R.id.item_nutrition:
                    mViewPager.setCurrentItem(2);
                    break;
                case R.id.item_wellness:
                    mViewPager.setCurrentItem(3);
                    break;
                case R.id.item_comminity:
                    mViewPager.setCurrentItem(4);
                    break;
            }
            return true;
        }
    };
}
