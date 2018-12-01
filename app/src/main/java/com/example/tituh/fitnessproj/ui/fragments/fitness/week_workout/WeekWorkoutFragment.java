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
import com.example.tituh.fitnessproj.model.WeekWorkoutModel;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class WeekWorkoutFragment extends BaseFragment {


    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.week_workout_activity, container, false);

            List<WeekWorkoutModel> mList = new ArrayList<>();
            mList.add(new WeekWorkoutModel("3", "OUT OF 12 WEEKS"));
            mList.add(new WeekWorkoutModel("WEEK 1"));
            mList.add(new WeekWorkoutModel("WEEK 2"));
            mList.add(new WeekWorkoutModel("WEEK 3"));
            mList.add(new WeekWorkoutModel("WEEK 4"));
            mList.add(new WeekWorkoutModel("WEEK 5"));
            mList.add(new WeekWorkoutModel("WEEK 6"));
            mList.add(new WeekWorkoutModel("WEEK 7"));
            mList.add(new WeekWorkoutModel("WEEK 8"));
            mList.add(new WeekWorkoutModel("WEEK 9"));
            mList.add(new WeekWorkoutModel("WEEK 10"));
            mList.add(new WeekWorkoutModel("WEEK 11"));
            mList.add(new WeekWorkoutModel("WEEK 12"));

            mRecyclerView = view.findViewById(R.id.recyclerView_workout_week);

            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView.setAdapter(new WeekWorkoutFragmentRecyclerViewAdapter(mList));

            fragmentInteractionListener.updateActionBarTitle("INTERMEDIATE");
            fragmentInteractionListener.goneIconAbouttActionBar();
            fragmentInteractionListener.visibleIconBacktActionBar();
            fragmentInteractionListener.goneIconHomeActionBar();
            fragmentInteractionListener.goneIconInfoActionBar();
            fragmentInteractionListener.goneIconShareActionBar();

            mRecyclerView.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                    mRecyclerView, new RecyclerTouchListenerStart.ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    if (position == 3) {
                        if (null != fragmentInteractionListener) {
                            fragmentInteractionListener.pushFragment(new DayWorkoutFragment(), true);
                        }
                    }
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));
        }

        return view;
    }
}
