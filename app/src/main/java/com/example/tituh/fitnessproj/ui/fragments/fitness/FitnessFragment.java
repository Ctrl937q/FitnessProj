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
import android.widget.ProgressBar;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.FitnessFragmentStartRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.model.FitnessStartModel;
import com.example.tituh.fitnessproj.networking.ApiClient;
import com.example.tituh.fitnessproj.networking.responses.OnGetTrainingResponseListener;
import com.example.tituh.fitnessproj.networking.responses.training.ResultsItem;
import com.example.tituh.fitnessproj.networking.responses.training.TrainingResponse;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import com.example.tituh.fitnessproj.ui.fragments.fitness.glossary.GlossaryFragment;
import com.example.tituh.fitnessproj.ui.fragments.fitness.prepare.PrepareBeforeTrainingFragment;
import com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout.ChooseLevelFragment;
import com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout.WeekWorkoutFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class FitnessFragment extends BaseFragment {

    private RecyclerView mRecyclerViewFitnessFragment;
    private List<FitnessStartModel> mListFitStarModel;
    private int[] mDrawableMassive;
    private ArrayList<ResultsItem> mResultsItemsArrayList;
    private HashSet<String> mArrayWithoutDuplicates;
    private ArrayList<String> mStringArrayWeek;
    private ProgressBar mProgressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fitness_fragment, container, false);
            initialize();
            ApiClient apiClient = new ApiClient();
            apiClient.getTrainings(new OnGetTrainingResponseListener() {
                @Override
                public void onGetTrainingsResponse(@Nullable String message, boolean success, @Nullable TrainingResponse trainingResponse) {
                    mResultsItemsArrayList.addAll(trainingResponse.getResults());
                    sortDeleteDuplicates(mResultsItemsArrayList);
                    mRecyclerViewFitnessFragment.setAdapter(new FitnessFragmentStartRecyclerViewAdapter(mListFitStarModel, mStringArrayWeek.size()));
                    mProgressBar.setVisibility(View.GONE);
                }
            });

            mListFitStarModel.add(new FitnessStartModel("PREPARE",
                    "ABOUT WORKOUT", FitnessStartModel.ONE_TYPE, mDrawableMassive));
            mListFitStarModel.add(new FitnessStartModel(" WEEK WORKOUT GUIDE FOR TONING & STRETCHING",
                    "LET'S's SWEAT", FitnessStartModel.ONE_TYPE, mDrawableMassive));
            mListFitStarModel.add(new FitnessStartModel("WORKOUT GLOSSARY",
                    FitnessStartModel.TWO_TYPE));

            mRecyclerViewFitnessFragment.setLayoutManager(new LinearLayoutManager(getActivity()));

            mRecyclerViewFitnessFragment.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                    mRecyclerViewFitnessFragment, new RecyclerTouchListenerStart.ClickListener() {
                @Override
                public void onClick(View view, final int position) {
                    if (position == 0) {
                        fragmentInteractionListener.pushFragment(new PrepareBeforeTrainingFragment(), true);
                    }
                    if (position == 1) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("array_trainings",  mResultsItemsArrayList);
                        bundle.putStringArrayList("array_weeks",  mStringArrayWeek);
                        bundle.putInt("count_weeks", mStringArrayWeek.size());
                        ChooseLevelFragment chooseLevelFragment = new ChooseLevelFragment();
                        chooseLevelFragment.setArguments(bundle);
                        fragmentInteractionListener.pushFragment(chooseLevelFragment, true);

                    }

                    if (position == 2) {
                        if (null != fragmentInteractionListener) {
                            fragmentInteractionListener.pushFragment(new GlossaryFragment(), true);
                        }
                    }
                }

                @Override
                public void onLongClick(View view, int position) {
                }
            }));
        }
        fragmentInteractionListener.visibleIconAboutActionBar();
        fragmentInteractionListener.goneIconBacktActionBar();
        fragmentInteractionListener.goneIconHomeActionBar();
        fragmentInteractionListener.goneIconShareActionBar();
        fragmentInteractionListener.goneIconInfoActionBar();

        return view;
    }


    private int extractInt(String s) {
        String num = s.replaceAll("\\D", "");
        return num.isEmpty() ? 0 : Integer.parseInt(num);
    }

    private void initialize(){
        mRecyclerViewFitnessFragment = view.findViewById(R.id.recycler_view_fitness_fragment);
        mProgressBar = view.findViewById(R.id.progress_bar_fitness_fragment);
        mListFitStarModel = new ArrayList<>();
        mResultsItemsArrayList = new ArrayList<>();
        mDrawableMassive = new int[]{R.drawable.prepare_image, R.drawable.image_week_workout};
        mArrayWithoutDuplicates = new HashSet<>();
        mStringArrayWeek = new ArrayList<>();
        fragmentInteractionListener.visibleIconAboutActionBar();
        fragmentInteractionListener.goneIconBacktActionBar();
        fragmentInteractionListener.goneIconHomeActionBar();
        fragmentInteractionListener.goneIconShareActionBar();
        fragmentInteractionListener.goneIconInfoActionBar();
    }

    private ArrayList<String> sortDeleteDuplicates(ArrayList<ResultsItem>resultsItemsArrayList){
        for (int i = 0; i < resultsItemsArrayList.size(); i++) {
            for (int j = 0; j < resultsItemsArrayList.get(i).getWeeks().size(); j++) {
                String week;
                week = resultsItemsArrayList.get(i).getWeeks().get(j);
                mArrayWithoutDuplicates.add(week);
            }
        }
        mStringArrayWeek.addAll(mArrayWithoutDuplicates);
        Collections.sort(mStringArrayWeek, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return extractInt(o1) - extractInt(o2);
            }
        });

        return mStringArrayWeek;
    }

}