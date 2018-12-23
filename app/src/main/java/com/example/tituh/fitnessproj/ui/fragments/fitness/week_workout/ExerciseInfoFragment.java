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

    private ArrayList<ResultsItem> mResultTraining;
    private ArrayList<WorkoutsItem> mResultsItemsCircuitOneThree;
    private ArrayList<WorkoutsItem> mResultsItemsCircuitTwoFour;
    GetReadyFragment mGetReadyFragment;
    private int mWeekClick;
    private int mDayClick;
    private double mTime;
    private int mLevel;
    private String mDay;
    private String mWeek;
    private String mKeyShared;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.exercise_choose_fragment, container, false);

            RecyclerView recyclerView = view.findViewById(R.id.recyclerView_exercise_choose);
            TextView textViewTitle = view.findViewById(R.id.textView_title_exercise_info_fragment);
            Button mButtonStart = view.findViewById(R.id.button_start_workout);
            TextView textViewAllTime = view.findViewById(R.id.textView_training_info_time);
            mResultTraining = new ArrayList<>();
            mResultsItemsCircuitOneThree = new ArrayList<>();
            mResultsItemsCircuitTwoFour = new ArrayList<>();
            mResultTraining = getArguments().getParcelableArrayList("array_trainings_for_training_info");
            mWeekClick = getArguments().getInt("week_click");
            mDayClick = getArguments().getInt("day_click");
            mLevel = getArguments().getInt("level");
            mTime = Double.parseDouble(mResultTraining.get(0).getDuration()) / 60;

            mWeek = getArguments().getString("week");
            mDay = getArguments().getString("day");
            mKeyShared = mLevel + mWeek + mDay;

            textViewTitle.setText("" + mResultTraining.get(0).getTitle());
            textViewAllTime.setText("" + (int) mTime + " minutes");

            filterCircuitOneThree(mResultTraining);
            filterCircuitTwoFout(mResultTraining);

            mButtonStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("array_trainings_one_three", mResultsItemsCircuitOneThree);
                    bundle.putParcelableArrayList("array_trainings_two_four", mResultsItemsCircuitTwoFour);
                    bundle.putInt("level", mLevel);
                    bundle.putString("title", mResultTraining.get(0).getTitle());
                    bundle.putString("week", getArguments().getString("week"));
                    bundle.putString("day", getArguments().getString("day"));
                    bundle.putString("key", mKeyShared);
                    bundle.putInt("day_click", mDayClick);
                    bundle.putInt("week_click", mWeekClick);
                    bundle.putInt("trainingId", mResultTraining.get(0).getId());
                    mGetReadyFragment = new GetReadyFragment();
                    mGetReadyFragment.setArguments(bundle);
                    fragmentInteractionListener.pushFragment(mGetReadyFragment, true);

                }
            });
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(new ExerciseRecyclerViewAdapter(mResultsItemsCircuitOneThree, mResultsItemsCircuitTwoFour, mLevel, getActivity()));
            recyclerView.addItemDecoration(new MarginItemDecoration(1, 10, 0, 10, 10));
        }

        fragmentInteractionListener.updateActionBarTitle("WEEK " + mWeekClick + " - Day " + mDayClick);

        return view;
    }

    private void filterCircuitOneThree(ArrayList<ResultsItem> arrayList) {
        mResultsItemsCircuitOneThree.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.get(i).getWorkouts().size(); j++) {
                if (arrayList.get(i).getWorkouts().get(j).getCircuit() == 1) {
                    mResultsItemsCircuitOneThree.add(arrayList.get(i).getWorkouts().get(j));
                }
            }
        }
        Collections.sort(mResultsItemsCircuitOneThree, new Comparator<WorkoutsItem>() {
            @Override
            public int compare(WorkoutsItem workoutsItem, WorkoutsItem t1) {
                return workoutsItem.getPosition() - t1.getPosition();
            }
        });
    }

    private void filterCircuitTwoFout(ArrayList<ResultsItem> arrayList) {
        mResultsItemsCircuitTwoFour.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.get(i).getWorkouts().size(); j++) {
                if (arrayList.get(i).getWorkouts().get(j).getCircuit() == 2) {
                    mResultsItemsCircuitTwoFour.add(arrayList.get(i).getWorkouts().get(j));
                }
            }
        }
        Collections.sort(mResultsItemsCircuitTwoFour, new Comparator<WorkoutsItem>() {
            @Override
            public int compare(WorkoutsItem workoutsItem, WorkoutsItem t1) {
                return workoutsItem.getPosition() - t1.getPosition();
            }
        });
    }
}