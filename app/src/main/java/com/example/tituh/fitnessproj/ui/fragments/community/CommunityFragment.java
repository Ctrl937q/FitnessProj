package com.example.tituh.fitnessproj.ui.fragments.community;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.ViewPagerAdapter;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

public class CommunityFragment extends BaseFragment {

    CommunityTabFragmentFirstTop mCommunityTabFragmentFirstTop;
    CommunityTabFragmentSecondTop mCommunityTabFragmentSecondTop;
    CommunityTabFragmentFirstBot mCommunityTabFragmentFirstBot;
    CommunityTabFragmentSecondBot mCommunityTabFragmentSecondBot;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.community_fragment, container, false);
            fragmentInteractionListener.updateActionBarTitle("WELLNESS");

            ViewPager mViewPagerFirst = view.findViewById(R.id.commutity_view_pager_1);
            TabLayout tabLayoutFirst = view.findViewById(R.id.community_tabDots_1);
            ViewPager mViewPagerSecond = view.findViewById(R.id.commutity_view_pager_2);
            TabLayout tabLayoutSecond = view.findViewById(R.id.community_tabDots_2);



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
        mCommunityTabFragmentFirstTop = new CommunityTabFragmentFirstTop();
        mCommunityTabFragmentSecondTop = new CommunityTabFragmentSecondTop();
        viewPagerAdapter.addFragment(mCommunityTabFragmentFirstTop);
        viewPagerAdapter.addFragment(mCommunityTabFragmentSecondTop);
        viewPager.setAdapter(viewPagerAdapter);
    }




    private void setupViewPagerSecond(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mCommunityTabFragmentFirstBot = new CommunityTabFragmentFirstBot();
        mCommunityTabFragmentSecondBot = new CommunityTabFragmentSecondBot();
        viewPagerAdapter.addFragment(mCommunityTabFragmentFirstBot);
        viewPagerAdapter.addFragment(mCommunityTabFragmentSecondBot);
        viewPager.setAdapter(viewPagerAdapter);
    }

}
