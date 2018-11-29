package com.example.tituh.fitnessproj.ui.fragments.fitness;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.FitnessFragmentStartRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.model.FitnessStartModel;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import com.example.tituh.fitnessproj.ui.fragments.fitness.glossary.GlossaryFragment;
import com.example.tituh.fitnessproj.ui.fragments.fitness.prepare.PrepareBeforeTrainingFragment;
import com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout.ChooseLevelFragment;

import java.util.ArrayList;
import java.util.List;

public class FitnessFragment extends BaseFragment {

    private RecyclerView mRecyclerViewFitnessFragment;
    private List<FitnessStartModel> mListFitStarModel;
    int[]drawableMassive;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fitness_fragment, container, false);

        ((MainActivity) getActivity()).visibleIconAboutActionBar();
        ((MainActivity) getActivity()).goneIconBacktActionBar();
        ((MainActivity) getActivity()).goneIconHomeActionBar();
        ((MainActivity) getActivity()).goneIconShareActionBar();
        ((MainActivity) getActivity()).goneIconInfoActionBar();

        mRecyclerViewFitnessFragment = (RecyclerView) rootView.findViewById(R.id.recycler_view_fitness_fragment);

        mListFitStarModel = new ArrayList<>();
        drawableMassive = new int[]{R.drawable.prepare_image, R.drawable.image_week_workout};

        mListFitStarModel.add(new FitnessStartModel("PREPARE",
                "ABOUT WORKOUT", FitnessStartModel.ONE_TYPE, drawableMassive));
        mListFitStarModel.add(new FitnessStartModel("12 WEEK WORKOUT GUIDE FOR TONING & STRETCHING",
                "LET'S's SWEAT", FitnessStartModel.ONE_TYPE, drawableMassive));
        mListFitStarModel.add(new FitnessStartModel("WORKOUT GLOSSARY",
                FitnessStartModel.TWO_TYPE));

        mRecyclerViewFitnessFragment.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerViewFitnessFragment.setAdapter(new FitnessFragmentStartRecyclerViewAdapter(mListFitStarModel));

        mRecyclerViewFitnessFragment.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                mRecyclerViewFitnessFragment, new RecyclerTouchListenerStart.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                if(position == 0){
                    fragmentInteractionListener.pushFragment(new PrepareBeforeTrainingFragment(), true, getClass().getName());
                }
                if (position == 1) {
                    fragmentInteractionListener.pushFragment(new ChooseLevelFragment(), true, getClass().getName());
                }

                if (position == 2) {
                    if (null != fragmentInteractionListener) {
                        fragmentInteractionListener.pushFragment(new GlossaryFragment(), true, getClass().getName());
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