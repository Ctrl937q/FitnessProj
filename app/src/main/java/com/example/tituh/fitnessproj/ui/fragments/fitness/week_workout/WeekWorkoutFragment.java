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
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.adapters.WeekWorkoutFragmentRecyclerViewAdapter;
import com.example.tituh.fitnessproj.networking.responses.training.ResultsItem;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import java.util.ArrayList;

public class WeekWorkoutFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private ArrayList<ResultsItem> mResultsItemsArrayList;
    private ArrayList<ResultsItem> mFilterWeekItemArray;
    private ArrayList<String> mWeekArray;
    private int mLevel;
    private DayWorkoutFragment mDayWorkoutFragment;
    private String mWeekClick;
    private WeekWorkoutFragmentRecyclerViewAdapter mWeekWorkoutFragmentRecyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.week_workout_activity, container, false);

            initialize();

            mRecyclerView = view.findViewById(R.id.recyclerView_workout_week);

            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            mWeekWorkoutFragmentRecyclerViewAdapter = new WeekWorkoutFragmentRecyclerViewAdapter(mWeekArray,
                    mLevel, getActivity(), fragmentInteractionListener);
            mRecyclerView.setAdapter(mWeekWorkoutFragmentRecyclerViewAdapter);

            mRecyclerView.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                    mRecyclerView, new RecyclerTouchListenerStart.ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    if (null != fragmentInteractionListener) {
                        if (position == 0) {

                        } else {
                            Bundle bundle = new Bundle();
                            bundle.putParcelableArrayList("array_trainings_for_day_workout",
                                    filterWeek(mResultsItemsArrayList, position));
                            bundle.putInt("level", mLevel);
                            bundle.putInt("position_week", position);
                            bundle.putInt("value_week", mWeekArray.size());
                            bundle.putString("item_click_week", mWeekArray.get(position - 1));

                            mDayWorkoutFragment = new DayWorkoutFragment();
                            mDayWorkoutFragment.setArguments(bundle);
                            fragmentInteractionListener.pushFragment(mDayWorkoutFragment, true);
                        }

                    }
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));
        }


        mWeekWorkoutFragmentRecyclerViewAdapter.notifyDataSetChanged();

        if (mLevel == 0) {
            fragmentInteractionListener.updateActionBarTitle("BEGINNER");
        }
        if (mLevel == 1) {
            fragmentInteractionListener.updateActionBarTitle("INTERMEDIATE");
        }
        if (mLevel == 2) {
            fragmentInteractionListener.updateActionBarTitle("ADVANCED");
        }
        fragmentInteractionListener.goneIconAbouttActionBar();
        fragmentInteractionListener.visibleIconBacktActionBar();
        return view;
    }

    private void initialize() {
        mWeekArray = new ArrayList<>();
        mResultsItemsArrayList = new ArrayList<>();
        mFilterWeekItemArray = new ArrayList<>();

        mWeekArray = getArguments().getStringArrayList("array_weeks_for_week_workout");
        mResultsItemsArrayList = getArguments().getParcelableArrayList("array_trainings_for_week_workout");
        mLevel = getArguments().getInt("level");
    }

    private ArrayList<ResultsItem> filterWeek(ArrayList<ResultsItem> allResultArray, int position) {
        mWeekClick = mWeekArray.get(position - 1);
        mFilterWeekItemArray.clear();
        for (int i = 0; i < allResultArray.size(); i++) {
            for (int j = 0; j < allResultArray.get(i).getWeeks().size(); j++) {
                if (allResultArray.get(i).getWeeks().get(j).equalsIgnoreCase(mWeekClick)) {
                    mFilterWeekItemArray.add(allResultArray.get(i));
                }
            }
        }
        return mFilterWeekItemArray;
    }


}
