package com.example.tituh.fitnessproj.ui.fragments.wellness;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.FitnessFragmentStartRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.adapters.WellnessFragmentRecyclerViewAdapter;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import com.example.tituh.fitnessproj.ui.fragments.fitness.WeekWorkoutFragment;
import com.example.tituh.fitnessproj.ui.fragments.fitness.glossary.GlossaryFragment;

import java.util.ArrayList;

public class WellnessFragment extends BaseFragment {

    RecyclerView mRecyclerViewWellnessFragment;
    ArrayList<String> mArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.wellness_fragment, container, false);
        ((MainActivity) getActivity()).updateActionBarTitle("Wellness");
        ((MainActivity) getActivity()).visibleIconAboutActionBar();
        ((MainActivity) getActivity()).goneIconBacktActionBar();
        mRecyclerViewWellnessFragment = (RecyclerView) rootView.findViewById(R.id.recycler_view_wellness);

        mArrayList = new ArrayList<>();
        mArrayList.add("Daily Habits");
        mArrayList.add("Protein Powder Guide");
        mArrayList.add("8 Tips For Your Success");

        mRecyclerViewWellnessFragment.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerViewWellnessFragment.setAdapter(new WellnessFragmentRecyclerViewAdapter(mArrayList));

        mRecyclerViewWellnessFragment.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                mRecyclerViewWellnessFragment, new RecyclerTouchListenerStart.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                if (position == 0) {
                    if (null != fragmentInteractionListener) {
                        fragmentInteractionListener.pushFragment(new DailyHabitsFragment(), true);
                        //fragmentInteractionListener.pushFragment(new WeekWorkoutFragment(), true);
                    }
                }

                if (position == 1) {
                    if (null != fragmentInteractionListener) {
                        fragmentInteractionListener.pushFragment(new ProteinPowderGuideFragment(), true);

                    }
                }
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));

        return rootView;
    }
}