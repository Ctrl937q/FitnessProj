package com.example.tituh.fitnessproj.ui.fragments.fitness;

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
import com.example.tituh.fitnessproj.adapters.FitnessFragmentStartRecyclerViewAdapter;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;

import mehdi.sakout.fancybuttons.FancyButton;

public class ExerciseChooseFragment extends BaseFragment {

    ArrayList<String>arrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.exercise_choose_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView_exercise_choose);
        FancyButton fancyButton = (FancyButton)rootView.findViewById(R.id.button_start_workout);

        fancyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentInteractionListener.pushFragment(new ExersiceDoFragment(), true);
            }
        });

        arrayList = new ArrayList<>();
        arrayList.add("Warm Up 1");
        arrayList.add("CIRCUIT 1 | CIRCUIT 3");

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new ExerciseRecyclerViewAdapter(arrayList));

        return rootView;
    }
}
