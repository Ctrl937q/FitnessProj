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
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.ExerciseRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.helpers.MarginItemDecoration;
import com.example.tituh.fitnessproj.networking.responses.training.ResultsItem;
import com.example.tituh.fitnessproj.networking.responses.training.WorkoutsItem;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ExerciseInfoFragment extends BaseFragment {

    private ArrayList<ResultsItem> resultTraining;
    private ArrayList<WorkoutsItem> resultsItemsCircuitOneThree;
    private ArrayList<WorkoutsItem> resultsItemsCircuitTwoFour;
    int weekClick;
    int dayClick;
    double time;
    int level;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.exercise_choose_fragment, container, false);

            RecyclerView recyclerView = view.findViewById(R.id.recyclerView_exercise_choose);
            TextView textViewTitle = view.findViewById(R.id.textView_title_exercise_info_fragment);
            Button mButtonStart = view.findViewById(R.id.button_start_workout);
            TextView textViewAllTime = view.findViewById(R.id.textView_training_info_time);
            resultTraining = new ArrayList<>();
            resultsItemsCircuitOneThree = new ArrayList<>();
            resultsItemsCircuitTwoFour = new ArrayList<>();
            resultTraining = getArguments().getParcelableArrayList("array_trainings_for_training_info");
            weekClick = getArguments().getInt("week_click");
            dayClick = getArguments().getInt("day_click");
            level = getArguments().getInt("level");
            time = Double.parseDouble(resultTraining.get(0).getDuration()) / 60;

            textViewTitle.setText("" + resultTraining.get(0).getTitle());
            textViewAllTime.setText("" + (int) time + " minutes");

            filterCircuitOneThree(resultTraining);
            filterCircuitTwoFout(resultTraining);

            Log.d("sadfget", "" + resultsItemsCircuitOneThree.size());
            Log.d("sadfget", "" + resultsItemsCircuitTwoFour.size());

            mButtonStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fragmentInteractionListener.pushFragment(new GetReadyFragment(), false);
                }
            });

            fragmentInteractionListener.updateActionBarTitle("WEEK 2 - DAY 3");
            fragmentInteractionListener.goneIconAbouttActionBar();
            fragmentInteractionListener.visibleIconBacktActionBar();
            fragmentInteractionListener.goneIconHomeActionBar();
            fragmentInteractionListener.goneIconInfoActionBar();
            fragmentInteractionListener.goneIconShareActionBar();

            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(new ExerciseRecyclerViewAdapter(resultsItemsCircuitOneThree, resultsItemsCircuitTwoFour, level));
            recyclerView.addItemDecoration(new MarginItemDecoration(1, 30, 0, 10, 10));

            recyclerView.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                    recyclerView, new RecyclerTouchListenerStart.ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    if (position == 0) {
                    }
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));
        }

        fragmentInteractionListener.updateActionBarTitle("WEEK " + weekClick + " - Day " + dayClick);
        fragmentInteractionListener.goneIconAbouttActionBar();
        fragmentInteractionListener.visibleIconBacktActionBar();
        fragmentInteractionListener.goneIconHomeActionBar();
        fragmentInteractionListener.goneIconInfoActionBar();
        fragmentInteractionListener.goneIconShareActionBar();

        return view;
    }

    private void filterCircuitOneThree(ArrayList<ResultsItem> arrayList) {
        resultsItemsCircuitOneThree.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.get(i).getWorkouts().size(); j++) {
                if (arrayList.get(i).getWorkouts().get(j).getCircuit() == 1) {
                    resultsItemsCircuitOneThree.add(arrayList.get(i).getWorkouts().get(j));
                }
            }

        }
    }


    private void filterCircuitTwoFout(ArrayList<ResultsItem> arrayList) {
        resultsItemsCircuitTwoFour.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.get(i).getWorkouts().size(); j++) {
                if (arrayList.get(i).getWorkouts().get(j).getCircuit() == 2) {
                    resultsItemsCircuitTwoFour.add(arrayList.get(i).getWorkouts().get(j));
                }
            }

        }
    }
}