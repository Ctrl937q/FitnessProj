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
import com.example.tituh.fitnessproj.adapters.DayWorkoutFragmentRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.model.DayWorkoutModel;
import com.example.tituh.fitnessproj.model.WeekWorkoutModel;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class DayWorkoutFragment extends BaseFragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.day_workout_layout, container, false);

        List<DayWorkoutModel> list = new ArrayList<>();
        list.add(new DayWorkoutModel("3", "OUT OF 12 WEEKS"));
        list.add(new DayWorkoutModel("Day 1", "ASS | LEGGS"));
        list.add(new DayWorkoutModel("Day 2", "ARS | BECK"));
        list.add(new DayWorkoutModel("Day 3", "FULL SHEBANG"));

        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView_workout_day);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new DayWorkoutFragmentRecyclerViewAdapter(list));

        ((MainActivity)getActivity()).updateActionBarTitle("WEEK 3");


        recyclerView.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                recyclerView, new RecyclerTouchListenerStart.ClickListener() {
            @Override
            public void onClick(View view, int position) {          //TODO disabled 0 item click
                if(position == 3){
                    if (null != fragmentInteractionListener) {
                        fragmentInteractionListener.pushFragment(new ExerciseChooseFragment(), true);
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