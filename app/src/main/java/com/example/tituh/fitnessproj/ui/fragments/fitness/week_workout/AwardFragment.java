package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

public class AwardFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.award_fragment, container, false);
        ((MainActivity) getActivity()).goneIconAbouttActionBar();
        ((MainActivity) getActivity()).visibilityIconShareActionBar();
        ((MainActivity) getActivity()).goneIconInfoActionBar();
        ((MainActivity) getActivity()).goneIconHomeActionBar();
        ((MainActivity) getActivity()).visibleIconBacktActionBar();

        Button buttonMainMenu = rootView.findViewById(R.id.button_main_manu_award);

        buttonMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack(fragmentManager.getBackStackEntryAt(
                        fragmentManager.getBackStackEntryCount() - 2).getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);*/
                fragmentInteractionListener.popFragment();
                fragmentInteractionListener.popFragment();

            }
        });
        return rootView;
    }
}
