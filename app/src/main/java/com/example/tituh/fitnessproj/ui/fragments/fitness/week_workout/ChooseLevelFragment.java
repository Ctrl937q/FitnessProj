package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.ChooseLevelRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.model.ChooseLevelModel;
import com.example.tituh.fitnessproj.networking.responses.training.ResultsItem;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import java.util.ArrayList;

public class ChooseLevelFragment extends BaseFragment {

    private ArrayList<ChooseLevelModel> mModelLevel;
    private ArrayList<ResultsItem> mArrayListResult;
    private ArrayList<String> mWeekArray;
    private int mCountWeek;
    private RecyclerView mRecyclerView;
    private WeekWorkoutFragment mWeekWorkoutFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.week_workout_choose_level_fragment, container, false);

            initialize();

            mModelLevel.add(new ChooseLevelModel(R.drawable.vector_medal_beginner, "BEGINNER"));
            mModelLevel.add(new ChooseLevelModel(R.drawable.vector_medal_intermediate, "INTERMEDIATE"));
            mModelLevel.add(new ChooseLevelModel(R.drawable.vector_medal_advanced, "ADVANCED"));

            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView.setAdapter(new ChooseLevelRecyclerViewAdapter(mModelLevel));

            mRecyclerView.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                    mRecyclerView, new RecyclerTouchListenerStart.ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    if (position == 0) {
                        if (null != fragmentInteractionListener) {
                            int levelBeginner = 0;
                            Bundle bundle = new Bundle();
                            bundle.putParcelableArrayList("array_trainings_for_week_workout", mArrayListResult);
                            bundle.putStringArrayList("array_weeks_for_week_workout", mWeekArray);
                            bundle.putInt("level", levelBeginner);
                            mWeekWorkoutFragment = new WeekWorkoutFragment();
                            mWeekWorkoutFragment.setArguments(bundle);
                            fragmentInteractionListener.pushFragment(mWeekWorkoutFragment, true);
                        }
                    }
                    if (position == 1) {
                        if (null != fragmentInteractionListener) {
                            int levelIntermediate = 1;
                            Bundle bundle = new Bundle();
                            bundle.putParcelableArrayList("array_trainings_for_week_workout", mArrayListResult);
                            bundle.putStringArrayList("array_weeks_for_week_workout", mWeekArray);
                            bundle.putInt("level", levelIntermediate);
                            mWeekWorkoutFragment = new WeekWorkoutFragment();
                            mWeekWorkoutFragment.setArguments(bundle);
                            fragmentInteractionListener.pushFragment(mWeekWorkoutFragment, true);
                        }
                    }

                    if (position == 2) {
                        if (null != fragmentInteractionListener) {
                            int levelAdvanced = 2;
                            Bundle bundle = new Bundle();
                            bundle.putParcelableArrayList("array_trainings_for_week_workout", mArrayListResult);
                            bundle.putStringArrayList("array_weeks_for_week_workout", mWeekArray);
                            bundle.putInt("level", levelAdvanced);
                            mWeekWorkoutFragment = new WeekWorkoutFragment();
                            mWeekWorkoutFragment.setArguments(bundle);
                            fragmentInteractionListener.pushFragment(mWeekWorkoutFragment, true);
                        }

                    }
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));
        }
        fragmentInteractionListener.updateActionBarTitle("12 WEEK");
        fragmentInteractionListener.visibleIconBacktActionBar();
        fragmentInteractionListener.visibleIconAboutActionBar();
        fragmentInteractionListener.goneIconHomeActionBar();
        fragmentInteractionListener.goneIconInfoActionBar();
        fragmentInteractionListener.goneIconShareActionBar();
        return view;
    }

    @Override
    public void onDestroyView() {
        fragmentInteractionListener.updateActionBarTitle("TSC BODY");
        super.onDestroyView();
    }


    private void initialize() {
        mRecyclerView = view.findViewById(R.id.recycler_view_choose_level);
        mArrayListResult = new ArrayList<>();
        mWeekArray = new ArrayList<>();
        mModelLevel = new ArrayList<>();
        mWeekArray = getArguments().getStringArrayList("array_weeks");
        mArrayListResult = getArguments().getParcelableArrayList("array_trainings");
        mCountWeek = getArguments().getInt("count_weeks");
        fragmentInteractionListener.updateActionBarTitle(mCountWeek + " WEEK");
        fragmentInteractionListener.visibleIconBacktActionBar();
        fragmentInteractionListener.visibleIconAboutActionBar();
        fragmentInteractionListener.goneIconHomeActionBar();
        fragmentInteractionListener.goneIconInfoActionBar();
        fragmentInteractionListener.goneIconShareActionBar();
    }

}
