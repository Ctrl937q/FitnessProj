package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.adapters.WeekWorkoutFragmentRecyclerViewAdapter;
import com.example.tituh.fitnessproj.networking.responses.training.ResultsItem;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import com.example.tituh.fitnessproj.ui.fragments.nutrition.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class WeekWorkoutFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private ArrayList<ResultsItem> resultsItemsArrayList;
    private ArrayList<ResultsItem> filterWeekItemArray;
    private ArrayList<String> weekArray;
    private int mLevel;
    private DayWorkoutFragment dayWorkoutFragment;
    private String weekClick;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.week_workout_activity, container, false);

            initialize();

            mRecyclerView = view.findViewById(R.id.recyclerView_workout_week);

            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView.setAdapter(new WeekWorkoutFragmentRecyclerViewAdapter(weekArray, mLevel, getActivity()));

            mRecyclerView.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                    mRecyclerView, new RecyclerTouchListenerStart.ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    if (null != fragmentInteractionListener) {
                        if (position == 0) {

                        } else {
                            Bundle bundle = new Bundle();
                            bundle.putParcelableArrayList("array_trainings_for_day_workout",
                                    filterWeek(resultsItemsArrayList, position));
                            bundle.putInt("level", mLevel);
                            bundle.putInt("position_week", position);
                            bundle.putInt("value_week", weekArray.size());
                            bundle.putString("item_click_week", weekArray.get(position - 1));

                            dayWorkoutFragment = new DayWorkoutFragment();
                            dayWorkoutFragment.setArguments(bundle);
                            fragmentInteractionListener.pushFragment(dayWorkoutFragment, true);
                        }

                    }
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));
        }

        fragmentInteractionListener.updateActionBarTitle("INTERMEDIATE");
        fragmentInteractionListener.goneIconAbouttActionBar();
        fragmentInteractionListener.visibleIconBacktActionBar();
        fragmentInteractionListener.goneIconHomeActionBar();
        fragmentInteractionListener.goneIconInfoActionBar();
        fragmentInteractionListener.goneIconShareActionBar();

        return view;
    }

    private void initialize() {
        weekArray = new ArrayList<>();
        resultsItemsArrayList = new ArrayList<>();
        filterWeekItemArray = new ArrayList<>();

        weekArray = getArguments().getStringArrayList("array_weeks_for_week_workout");
        resultsItemsArrayList = getArguments().getParcelableArrayList("array_trainings_for_week_workout");
        mLevel = getArguments().getInt("level");

        fragmentInteractionListener.updateActionBarTitle("INTERMEDIATE");
        fragmentInteractionListener.goneIconAbouttActionBar();
        fragmentInteractionListener.visibleIconBacktActionBar();
        fragmentInteractionListener.goneIconHomeActionBar();
        fragmentInteractionListener.goneIconInfoActionBar();
        fragmentInteractionListener.goneIconShareActionBar();
    }

    private ArrayList<ResultsItem> filterWeek(ArrayList<ResultsItem> allResultArray, int position) {
        weekClick = weekArray.get(position - 1);
        filterWeekItemArray.clear();
        for (int i = 0; i < allResultArray.size(); i++) {
            for (int j = 0; j < allResultArray.get(i).getWeeks().size(); j++) {
                if (allResultArray.get(i).getWeeks().get(j).equalsIgnoreCase(weekClick)) {
                    filterWeekItemArray.add(allResultArray.get(i));
                }
            }
        }
        return filterWeekItemArray;
    }


}
