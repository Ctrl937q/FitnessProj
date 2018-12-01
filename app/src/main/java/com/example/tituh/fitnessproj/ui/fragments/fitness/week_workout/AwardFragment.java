package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

public class AwardFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null) {
            view = inflater.inflate(R.layout.award_fragment, container, false);

            fragmentInteractionListener.goneIconAbouttActionBar();
            fragmentInteractionListener.visibilityIconShareActionBar();
            fragmentInteractionListener.goneIconInfoActionBar();
            fragmentInteractionListener.goneIconHomeActionBar();
            fragmentInteractionListener.visibleIconBacktActionBar();

            Button buttonMainMenu = view.findViewById(R.id.button_main_manu_award);

            buttonMainMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fragmentInteractionListener.popFragment();
                    fragmentInteractionListener.popFragment();
                }
            });

        }
        return view;
    }
}
