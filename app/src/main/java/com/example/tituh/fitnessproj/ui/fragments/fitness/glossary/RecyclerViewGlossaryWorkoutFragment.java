package com.example.tituh.fitnessproj.ui.fragments.fitness.glossary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.GlossaryWorkoutsRecyclerViewAdapter;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;

public class RecyclerViewGlossaryWorkoutFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler_view_for_glossary_workouts, container, false);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("WARM UP NAME");
        arrayList.add("WARM UP NAME");
        arrayList.add("WARM UP NAME");
        arrayList.add("WARM UP NAME");
        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view_glossary);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new GlossaryWorkoutsRecyclerViewAdapter(arrayList));
        return rootView;
    }
}
