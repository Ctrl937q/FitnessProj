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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.week_workout_activity, container, false);

        List<WeekWorkoutModel> list = new ArrayList<>();
        list.add(new WeekWorkoutModel("3", "OUT OF 12 WEEKS"));
        list.add(new WeekWorkoutModel("WEEK 1"));
        list.add(new WeekWorkoutModel("WEEK 2"));
        list.add(new WeekWorkoutModel("WEEK 3"));
        list.add(new WeekWorkoutModel("WEEK 4"));
        list.add(new WeekWorkoutModel("WEEK 5"));
        list.add(new WeekWorkoutModel("WEEK 6"));
        list.add(new WeekWorkoutModel("WEEK 7"));
        list.add(new WeekWorkoutModel("WEEK 8"));
        list.add(new WeekWorkoutModel("WEEK 9"));
        list.add(new WeekWorkoutModel("WEEK 10"));
        list.add(new WeekWorkoutModel("WEEK 11"));
        list.add(new WeekWorkoutModel("WEEK 12"));

        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView_workout_week);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new WeekWorkoutFragmentRecyclerViewAdapter(list));

        ((MainActivity)getActivity()).updateActionBarTitle("INTERMEDIATE");
        ((MainActivity)getActivity()).goneIconAbouttActionBar();
        ((MainActivity)getActivity()).visibleIconBacktActionBar();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                recyclerView, new RecyclerTouchListenerStart.ClickListener() {
            @Override
            public void onClick(View view, int position) {          //TODO disabled 0 item click
                if(position == 3){
                    if (null != fragmentInteractionListener) {
                        fragmentInteractionListener.pushFragment(new DayWorkoutFragment(), true);
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
