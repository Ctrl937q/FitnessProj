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
import com.example.tituh.fitnessproj.adapters.DayWorkoutFragmentRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.networking.responses.training.ResultsItem;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import java.util.ArrayList;

public class DayWorkoutFragment extends BaseFragment {

    private int mWeek;
    private ArrayList<ResultsItem> mResultsItemsArray;
    private ArrayList<ResultsItem> mResultsTraining;
    private ArrayList<String> mDayArrayList;
    private ArrayList<String> mTitleArrayList;
    private int mLevel;
    private int mCountWeek;
    private String mWeekClick;
    private ExerciseInfoFragment mExerciseInfoFragment;
    private String mDay;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.day_workout_layout, container, false);
            mResultsItemsArray = new ArrayList<>();
            mDayArrayList = new ArrayList<>();
            mTitleArrayList = new ArrayList<>();
            mResultsTraining = new ArrayList<>();

            mWeek = getArguments().getInt("position_week");

            mResultsItemsArray = getArguments().getParcelableArrayList("array_trainings_for_day_workout");
            mLevel = getArguments().getInt("level");
            mCountWeek = getArguments().getInt("value_week");
            mWeekClick = getArguments().getString("item_click_week");
            filterArrayListDay();

            RecyclerView recyclerView = view.findViewById(R.id.recyclerView_workout_day);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(new DayWorkoutFragmentRecyclerViewAdapter(mDayArrayList, mTitleArrayList, mCountWeek, mWeek, getActivity(), mLevel,mWeekClick));

            recyclerView.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                    recyclerView, new RecyclerTouchListenerStart.ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    if(position == 0){

                    }else if (null != fragmentInteractionListener) {
                        mDay = mDayArrayList.get(position - 1);
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("array_trainings_for_training_info", filterWeekDay(position));
                        bundle.putInt("level", mLevel);
                        bundle.putInt("week_click", mWeek);
                        bundle.putInt("day_click", position);
                        bundle.putString("week", mWeekClick);
                        bundle.putString("day", filterWeekDay(position).get(0).getDays().get(0));
                        mExerciseInfoFragment = new ExerciseInfoFragment();

                        mExerciseInfoFragment.setArguments(bundle);
                        fragmentInteractionListener.pushFragment(mExerciseInfoFragment, true);

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
        mDayArrayList.clear();
        mTitleArrayList.clear();
        for (int i = 0; i < mResultsItemsArray.size(); i++) {
            for (int j = 0; j < mResultsItemsArray.get(i).getDays().size(); j++) {
                mDayArrayList.add(mResultsItemsArray.get(i).getDays().get(j));
                mTitleArrayList.add(mResultsItemsArray.get(i).getTitle());
            }
        }
    }

    private ArrayList<ResultsItem> filterWeekDay(int position) {
        mResultsTraining.clear();
        mDay = mDayArrayList.get(position-1);
        for (int i = 0; i < mResultsItemsArray.size(); i++) {
            for (int j = 0; j < mResultsItemsArray.get(i).getDays().size(); j++) {
                if (mResultsItemsArray.get(i).getDays().get(j).equalsIgnoreCase(mDay)) {
                    mResultsTraining.add(mResultsItemsArray.get(i));
                }
            }
        }
        return mResultsTraining;
    }
}
