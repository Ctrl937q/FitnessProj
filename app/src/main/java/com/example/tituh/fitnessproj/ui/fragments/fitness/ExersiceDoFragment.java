package com.example.tituh.fitnessproj.ui.fragments.fitness;


import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.activities.TimerClass;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import com.example.tituh.fitnessproj.ui.fragments.DialogFragmentExersice;
import com.ohoussein.playpause.PlayPauseView;


public class ExersiceDoFragment extends BaseFragment {


    TextView textViewTime;
    ProgressBar progressBarExersice;
    Button btn_back;
    Button btn_next;
    TimerClass timerClass;
    int timerValue = 45;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.workout_start_layout, container, false);

        textViewTime = (TextView) rootView.findViewById(R.id.text_view_time);
        final PlayPauseView buttonPlayPause = (PlayPauseView) rootView.findViewById(R.id.button_test_start_exercise);
        progressBarExersice = (ProgressBar) rootView.findViewById(R.id.progressBar_exersice);
        btn_back = (Button) rootView.findViewById(R.id.btn_back_exersice);
        btn_next = (Button) rootView.findViewById(R.id.btn_next_exersice);
        timerClass = new TimerClass();

        ((MainActivity) getActivity()).updateActionBarTitle("WORKOUT NAME");

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragmentExersice dialogFragmentExersice = new DialogFragmentExersice(getActivity());
                dialogFragmentExersice.show();
                dialogFragmentExersice.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timerClass.pauseTimer();
                buttonPlayPause.change(true);
            }
        });

        progressBarExersice.setMax(timerValue);
        timerClass.startTimer(timerValue, textViewTime, progressBarExersice);

        buttonPlayPause.change(false);
        buttonPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPlayPause.toggle();
                if (timerClass.ismTimerRunning()) {
                    timerClass.pauseTimer();
                } else {
                    timerClass.startTimer(timerValue, textViewTime, progressBarExersice);
                }
            }
        });




        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).popFragment();
            }
        });
        return rootView;
    }

}
