package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.ExerciseRecyclerViewAdapter;
import com.example.tituh.fitnessproj.helpers.MarginItemDecoration;
import com.example.tituh.fitnessproj.networking.responses.training.ResultsItem;
import com.example.tituh.fitnessproj.networking.responses.training.WorkoutsItem;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ExerciseInfoFragment extends BaseFragment {

    private ArrayList<ResultsItem> resultTraining;
    private ArrayList<WorkoutsItem> resultsItemsCircuitOneThree;
    private ArrayList<WorkoutsItem> resultsItemsCircuitTwoFour;
    GetReadyFragment getReadyFragment;
    private int mWeekClick;
    private int mDayClick;
    private double mTime;
    private int mLevel;
    private String day;
    private String week;
    private String keyShared;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.exercise_choose_fragment, container, false);

            RecyclerView recyclerView = view.findViewById(R.id.recyclerView_exercise_choose);
            TextView textViewTitle = view.findViewById(R.id.textView_title_exercise_info_fragment);
            Button mButtonStart = view.findViewById(R.id.button_start_workout);
            TextView textViewAllTime = view.findViewById(R.id.textView_training_info_time);
            resultTraining = new ArrayList<>();
            resultsItemsCircuitOneThree = new ArrayList<>();
            resultsItemsCircuitTwoFour = new ArrayList<>();
            resultTraining = getArguments().getParcelableArrayList("array_trainings_for_training_info");
            mWeekClick = getArguments().getInt("week_click");
            mDayClick = getArguments().getInt("day_click");
            mLevel = getArguments().getInt("level");
            mTime = Double.parseDouble(resultTraining.get(0).getDuration()) / 60;

            week = getArguments().getString("week");
            day = getArguments().getString("day");
            keyShared = mLevel + week + day;

            textViewTitle.setText("" + resultTraining.get(0).getTitle());
            textViewAllTime.setText("" + (int) mTime + " minutes");

            filterCircuitOneThree(resultTraining);
            filterCircuitTwoFout(resultTraining);

            mButtonStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("array_trainings_one_three", resultsItemsCircuitOneThree);
                    bundle.putParcelableArrayList("array_trainings_two_four", resultsItemsCircuitTwoFour);
                    bundle.putInt("level", mLevel);
                    bundle.putString("title", resultTraining.get(0).getTitle());
                    bundle.putString("week", getArguments().getString("week"));
                    bundle.putString("day", getArguments().getString("day"));
                    bundle.putString("key", keyShared);
                    bundle.putInt("day_click", mDayClick);
                    bundle.putInt("week_click", mWeekClick);
                    getReadyFragment = new GetReadyFragment();
                    getReadyFragment.setArguments(bundle);
                    fragmentInteractionListener.pushFragment(getReadyFragment, true);

                }
            });

            fragmentInteractionListener.updateActionBarTitle("WEEK 2 - DAY 3");
            fragmentInteractionListener.goneIconAbouttActionBar();
            fragmentInteractionListener.visibleIconBacktActionBar();
            fragmentInteractionListener.goneIconHomeActionBar();
            fragmentInteractionListener.goneIconInfoActionBar();
            fragmentInteractionListener.goneIconShareActionBar();

            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(new ExerciseRecyclerViewAdapter(resultsItemsCircuitOneThree, resultsItemsCircuitTwoFour, mLevel, getActivity()));
            recyclerView.addItemDecoration(new MarginItemDecoration(1, 10, 0, 10, 10));

        }

        fragmentInteractionListener.updateActionBarTitle("WEEK " + mWeekClick + " - Day " + mDayClick);
        fragmentInteractionListener.goneIconAbouttActionBar();
        fragmentInteractionListener.visibleIconBacktActionBar();
        fragmentInteractionListener.goneIconHomeActionBar();
        fragmentInteractionListener.goneIconInfoActionBar();
        fragmentInteractionListener.goneIconShareActionBar();

        return view;
    }

    private void filterCircuitOneThree(ArrayList<ResultsItem> arrayList) {
        resultsItemsCircuitOneThree.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.get(i).getWorkouts().size(); j++) {
                if (arrayList.get(i).getWorkouts().get(j).getCircuit() == 1) {
                    resultsItemsCircuitOneThree.add(arrayList.get(i).getWorkouts().get(j));
                }
            }
        }
        Collections.sort(resultsItemsCircuitOneThree, new Comparator<WorkoutsItem>() {
            @Override
            public int compare(WorkoutsItem workoutsItem, WorkoutsItem t1) {
                return workoutsItem.getPosition() - t1.getPosition();
            }
        });
    }

    private void filterCircuitTwoFout(ArrayList<ResultsItem> arrayList) {
        resultsItemsCircuitTwoFour.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.get(i).getWorkouts().size(); j++) {
                if (arrayList.get(i).getWorkouts().get(j).getCircuit() == 2) {
                    resultsItemsCircuitTwoFour.add(arrayList.get(i).getWorkouts().get(j));
                }
            }
        }
        Collections.sort(resultsItemsCircuitTwoFour, new Comparator<WorkoutsItem>() {
            @Override
            public int compare(WorkoutsItem workoutsItem, WorkoutsItem t1) {
                return workoutsItem.getPosition() - t1.getPosition();
            }
        });
    }
}