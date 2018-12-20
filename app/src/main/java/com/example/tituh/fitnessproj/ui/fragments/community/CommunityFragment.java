package com.example.tituh.fitnessproj.ui.fragments.community;

import android.content.Intent;
import android.net.Uri;
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

public class CommunityFragment extends BaseFragment implements View.OnClickListener {

    private CommunityTabFragmentFirstTop mCommunityTabFragmentFirstTop;
    private CommunityTabFragmentSecondTop mCommunityTabFragmentSecondTop;
    private CommunityTabFragmentFirstBot mCommunityTabFragmentFirstBot;
    private CommunityTabFragmentSecondBot mCommunityTabFragmentSecondBot;
    private Button buttonGoToCommunity;
    private Button buttonConnectWithUs;
    private Button btnAccessNow;

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
            buttonGoToCommunity = view.findViewById(R.id.btn_community_go_to_community);
            buttonConnectWithUs = view.findViewById(R.id.btn_community_connect_us);
            btnAccessNow = view.findViewById(R.id.btn_access_now);
            buttonGoToCommunity.setOnClickListener(this);
            buttonConnectWithUs.setOnClickListener(this);
            btnAccessNow.setOnClickListener(this);

            tabLayoutFirst.setupWithViewPager(mViewPagerFirst, true);
            tabLayoutSecond.setupWithViewPager(mViewPagerSecond, true);

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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_community_go_to_community:
                goToFacebook();
                break;
            case R.id.btn_community_connect_us:
                goToFacebook();
            case R.id.btn_access_now:
                goToFacebook();
                break;
        }

    }

    private void goToFacebook(){
        Uri address = Uri.parse("https://www.facebook.com/TheSkinnyConfidential");
        Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
        if (openlinkIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(openlinkIntent);
        }
    }

}
