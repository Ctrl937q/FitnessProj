package com.example.tituh.fitnessproj.ui.fragments.community;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

public class CommunityTabFragmentSecondTop extends BaseFragment {




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.community_tab_top_second, container, false);

        }
        return view;
    }
}
