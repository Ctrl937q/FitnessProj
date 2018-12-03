package com.example.tituh.fitnessproj.ui.fragments.about;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

public class AboutFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            Log.d("asdasdasdsadsa", "AboutFragment");
            view = inflater.inflate(R.layout.about_fragment, container, false);
        }
        Log.d("asdasdasdsadsa", "AboutFragment");
        return view;
    }
}
