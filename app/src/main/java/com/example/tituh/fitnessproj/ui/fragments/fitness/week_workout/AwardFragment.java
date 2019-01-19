package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.model.db.TrainingRepository;
import com.example.tituh.fitnessproj.networking.threads.ExecutorsPool;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;

public class AwardFragment extends BaseFragment {

    private TextView textViewAwardCompleted;
    private String key;
    private int level;
    private int weekclick;
    private int position;
    private int dayClick;
    private ArrayList<Integer> arrayListProgressWeek;
    private String week;
    private int id;
    private String day;

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.award_fragment, container, false);
            textViewAwardCompleted = view.findViewById(R.id.text_view_completed_award);
            fragmentInteractionListener.updateActionBarTitle(getArguments().getString("title"));
            arrayListProgressWeek = new ArrayList<>();
            level = getArguments().getInt("level");
            key = getArguments().getString("key");
            weekclick = getArguments().getInt("week_click");
            dayClick = getArguments().getInt("day_click");
            position = weekclick - 1;
            week = getArguments().getString("week");
            id = getArguments().getInt("trainingId");
            day = getArguments().getString("day");

            final TrainingRepository trainingRepository = new TrainingRepository(getContext());
            ExecutorsPool.runCommonBgTask(new Runnable() {
                public void run() {
                    trainingRepository.addTraining(week, TrainingRepository.COMPLEXITY_ARR[level], 36, id);
                    Log.d("sadsadasdasd12edfsa", "" + id);
                }
            });

            textViewAwardCompleted.setText("You have competed \n" + getArguments().getString("week") + " - " + getArguments().getString("day"));
            Button buttonMainMenu = view.findViewById(R.id.button_main_manu_award);
            buttonMainMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fragmentInteractionListener.popFragment();
                    fragmentInteractionListener.popFragment();
                    fragmentInteractionListener.popFragment();
                    fragmentInteractionListener.popFragment();
                }
            });
        }

        fragmentInteractionListener.visibilityIconShareActionBar();
        fragmentInteractionListener.goneIconInfoActionBar();
        fragmentInteractionListener.goneIconHomeActionBar();

        return view;
    }
}
