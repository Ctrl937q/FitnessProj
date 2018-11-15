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
import android.widget.Button;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.ExerciseRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import java.util.ArrayList;

public class ExerciseChooseFragment extends BaseFragment {

    private ArrayList<String>mArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.exercise_choose_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView_exercise_choose);
        Button mButtonStart = (Button) rootView.findViewById(R.id.button_start_workout);

        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentInteractionListener.pushFragment(new GetReadyFragment(), true);
            }
        });

        ((MainActivity)getActivity()).updateActionBarTitle("WEEK 2 - DAY 3");
        mArrayList = new ArrayList<>();
        mArrayList.add("Warm Up Name");
        mArrayList.add("CIRCUIT 1 | CIRCUIT 3");
        mArrayList.add("CIRCUIT 1 | CIRCUIT 3");
        mArrayList.add("CIRCUIT 1 | CIRCUIT 3");
        mArrayList.add("CIRCUIT 1 | CIRCUIT 3");
        mArrayList.add("CIRCUIT 1 | CIRCUIT 3");

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new ExerciseRecyclerViewAdapter(mArrayList));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                recyclerView, new RecyclerTouchListenerStart.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (position == 0) {
                    Log.d("wweqeqw", " + ");
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return rootView;
    }
}