package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.DayWorkoutFragmentRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.networking.responses.training.ResultsItem;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class DayWorkoutFragment extends BaseFragment {

    private int week;
    private ArrayList<ResultsItem> resultsItemsArray;
    private ArrayList<ResultsItem> resultsTraining;
    private ArrayList<String> dayArrayList;
    private ArrayList<String> titleArrayList;
    private int mLevel;
    private int mCountWeek;
    private String mWeekClick;
    private ExerciseInfoFragment exerciseInfoFragment;
    private String day;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.day_workout_layout, container, false);
            resultsItemsArray = new ArrayList<>();
            dayArrayList = new ArrayList<>();
            titleArrayList = new ArrayList<>();
            resultsTraining = new ArrayList<>();

            week = getArguments().getInt("position_week");
            resultsItemsArray = getArguments().getParcelableArrayList("array_trainings_for_day_workout");
            mLevel = getArguments().getInt("level");
            mCountWeek = getArguments().getInt("value_week");
            mWeekClick = getArguments().getString("item_click_week");

            filterArrayListDay();

            RecyclerView recyclerView = view.findViewById(R.id.recyclerView_workout_day);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(new DayWorkoutFragmentRecyclerViewAdapter(dayArrayList, titleArrayList, mCountWeek, week));


            fragmentInteractionListener.updateActionBarTitle("WEEK " + mCountWeek);
            fragmentInteractionListener.goneIconAbouttActionBar();
            fragmentInteractionListener.visibleIconBacktActionBar();
            fragmentInteractionListener.goneIconHomeActionBar();
            fragmentInteractionListener.goneIconInfoActionBar();
            fragmentInteractionListener.goneIconShareActionBar();

            recyclerView.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                    recyclerView, new RecyclerTouchListenerStart.ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    if (null != fragmentInteractionListener) {
                        day = dayArrayList.get(position - 1);
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("array_trainings_for_training_info", filterWeekDay(position));
                        bundle.putInt("level", mLevel);
                        bundle.putInt("week_click", week);
                        bundle.putInt("day_click", position);
                        //bundle.putString("title", title);

                        exerciseInfoFragment = new ExerciseInfoFragment();
                        exerciseInfoFragment.setArguments(bundle);

                        fragmentInteractionListener.pushFragment(exerciseInfoFragment, true);

                    }
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));
        }
        fragmentInteractionListener.updateActionBarTitle(mWeekClick);
        fragmentInteractionListener.goneIconAbouttActionBar();
        fragmentInteractionListener.visibleIconBacktActionBar();
        fragmentInteractionListener.goneIconHomeActionBar();
        fragmentInteractionListener.goneIconInfoActionBar();
        fragmentInteractionListener.goneIconShareActionBar();

        return view;
    }


    private void filterArrayListDay() {
        dayArrayList.clear();
        titleArrayList.clear();
        for (int i = 0; i < resultsItemsArray.size(); i++) {
            for (int j = 0; j < resultsItemsArray.get(i).getDays().size(); j++) {
                dayArrayList.add(resultsItemsArray.get(i).getDays().get(j));
                titleArrayList.add(resultsItemsArray.get(i).getTitle());
            }
        }
    }

    private ArrayList<ResultsItem> filterWeekDay(int position) {
        resultsTraining.clear();
        day = dayArrayList.get(position-1);
        for (int i = 0; i < resultsItemsArray.size(); i++) {
            for (int j = 0; j < resultsItemsArray.get(i).getDays().size(); j++) {
                if (resultsItemsArray.get(i).getDays().get(j).equalsIgnoreCase(day)) {
                    resultsTraining.add(resultsItemsArray.get(i));
                }
            }
        }
        return resultsTraining;
    }
}
