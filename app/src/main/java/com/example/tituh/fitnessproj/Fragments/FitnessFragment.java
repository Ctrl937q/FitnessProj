package com.example.tituh.fitnessproj.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tituh.fitnessproj.Adapters.FitnessFragmentStartRecyclerViewAdapter;
import com.example.tituh.fitnessproj.Model.FitnessStartModel;
import com.example.tituh.fitnessproj.R;

import java.util.ArrayList;
import java.util.List;

public class FitnessFragment extends Fragment {

    RecyclerView recyclerView_fitness_fragment;
    List<FitnessStartModel> listFitStarModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fitness_fragment, container, false);
        recyclerView_fitness_fragment = (RecyclerView)rootView.findViewById(R.id.recycler_view_fitness_fragment);

        listFitStarModel = new ArrayList<>();

        listFitStarModel.add(new FitnessStartModel("PREPARE", "LEARN MORE", FitnessStartModel.ONE_TYPE));
        listFitStarModel.add(new FitnessStartModel("12 WEEK WORKOUT GUIDE", "LEARN MORE", FitnessStartModel.ONE_TYPE));
        listFitStarModel.add(new FitnessStartModel("GLOSSARY", FitnessStartModel.TWO_TYPE));

        recyclerView_fitness_fragment.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView_fitness_fragment.setAdapter(new FitnessFragmentStartRecyclerViewAdapter(listFitStarModel));

        return rootView;
    }
}