package com.example.tituh.fitnessproj.ui.fragments.fitness.glossary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.GlossaryWorkoutsRecyclerViewAdapter;
import com.example.tituh.fitnessproj.networking.ApiClient;
import com.example.tituh.fitnessproj.networking.responses.OnGetTrainingResponseListener;
import com.example.tituh.fitnessproj.networking.responses.training.ResultsItem;
import com.example.tituh.fitnessproj.networking.responses.training.TrainingResponse;
import com.example.tituh.fitnessproj.networking.responses.training.WorkoutsItem;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewGlossaryWorkoutFragment extends BaseFragment {

    List<ResultsItem> arrayResults;
    List<WorkoutsItem> workoutsItems;
    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.recycler_view_for_glossary_workouts, container, false);
            recyclerView = view.findViewById(R.id.recycler_view_glossary);
            progressBar = view.findViewById(R.id.progressBarGlossary);
            arrayResults = new ArrayList<>();
            workoutsItems = new ArrayList<>();
            ApiClient apiClient = new ApiClient();
            apiClient.getTrainings(new OnGetTrainingResponseListener() {
                @Override
                public void onGetTrainingsResponse(@Nullable String message, boolean success, @Nullable TrainingResponse trainingResponse) {
                    if(trainingResponse!=null) {
                        arrayResults = trainingResponse.getResults();
                        for (int i = 0; i < arrayResults.size(); i++) {
                            workoutsItems.addAll(arrayResults.get(i).getWorkouts());
                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                        recyclerView.setAdapter(new GlossaryWorkoutsRecyclerViewAdapter(workoutsItems, getActivity()));
                        progressBar.setVisibility(View.GONE);
                    }
                }
            });
        }
        return view;
    }
}
