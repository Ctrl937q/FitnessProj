package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.ChooseLevelRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.model.ChooseLevelModel;
import com.example.tituh.fitnessproj.networking.ApiClient;
import com.example.tituh.fitnessproj.networking.responses.OnGetTrainingResponseListener;
import com.example.tituh.fitnessproj.networking.responses.training.ResultsItem;
import com.example.tituh.fitnessproj.networking.responses.training.TrainingResponse;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import java.util.ArrayList;
import java.util.List;

public class ChooseLevelFragment extends BaseFragment {

    private ArrayList<ChooseLevelModel> mModelLevel;

    TrainingResponse trainingResponse1;
    List<ResultsItem> arrayListResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.week_workout_choose_level_fragment, container, false);

            RecyclerView recyclerView = view.findViewById(R.id.recycler_view_choose_level);

            fragmentInteractionListener.updateActionBarTitle("12 WEEK");
            fragmentInteractionListener.visibleIconBacktActionBar();
            fragmentInteractionListener.visibleIconAboutActionBar();
            fragmentInteractionListener.goneIconHomeActionBar();
            fragmentInteractionListener.goneIconInfoActionBar();
            fragmentInteractionListener.goneIconShareActionBar();

            arrayListResult = new ArrayList<>();

            ApiClient apiClient = new ApiClient();
            apiClient.getTrainings(new OnGetTrainingResponseListener() {
                @Override
                public void onGetTrainingsResponse(@Nullable String message, boolean success, @Nullable TrainingResponse trainingResponse) {
                    trainingResponse1 = trainingResponse;
                    trainingResponse1.getResults();
                    arrayListResult = trainingResponse1.getResults();
                }
            });


            mModelLevel = new ArrayList<>();

            mModelLevel.add(new ChooseLevelModel(R.drawable.vector_medal_beginner, "BEGINNER"));
            mModelLevel.add(new ChooseLevelModel(R.drawable.vector_medal_intermediate, "INTERMEDIATE"));
            mModelLevel.add(new ChooseLevelModel(R.drawable.vector_medal_advanced, "ADVANCED"));

            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(new ChooseLevelRecyclerViewAdapter(mModelLevel));

            recyclerView.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                    recyclerView, new RecyclerTouchListenerStart.ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    if (position == 1) {
                        if (null != fragmentInteractionListener) {
                            Bundle bundle = new Bundle();
                            bundle.putParcelableArrayList("message", (ArrayList<? extends Parcelable>) arrayListResult);
                            WeekWorkoutFragment weekWorkoutFragment = new WeekWorkoutFragment();
                            weekWorkoutFragment.setArguments(bundle);
                            fragmentInteractionListener.pushFragment(weekWorkoutFragment, true);
                        }
                    }
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));
        }
        fragmentInteractionListener.updateActionBarTitle("12 WEEK");
        fragmentInteractionListener.visibleIconBacktActionBar();
        fragmentInteractionListener.visibleIconAboutActionBar();
        fragmentInteractionListener.goneIconHomeActionBar();
        fragmentInteractionListener.goneIconInfoActionBar();
        fragmentInteractionListener.goneIconShareActionBar();
        return view;
    }

    @Override
    public void onDestroyView() {
        fragmentInteractionListener.updateActionBarTitle("TSC BODY");
        super.onDestroyView();
    }
}
