package com.example.tituh.fitnessproj.ui.fragments.fitness;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import com.ohoussein.playpause.PlayPauseView;

import java.util.Locale;

public class ExersiceDoFragment extends BaseFragment {

    long startTimeills = 45000;
    CountDownTimer mCountDownTimer;
    long mTimeLeftInills = startTimeills;
    boolean mTimerRunning;
    TextView textViewTime;
    ProgressBar progressBarExersice;
    Button btn_back;
    Button btn_next;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.workout_start_layout, container, false);

        textViewTime = (TextView)rootView.findViewById(R.id.text_view_time);
        final PlayPauseView buttonPlayPause = (PlayPauseView) rootView.findViewById(R.id.button_test_start_exercise);
        progressBarExersice = (ProgressBar)rootView.findViewById(R.id.progressBar_exersice);
        btn_back = (Button)rootView.findViewById(R.id.btn_back_exersice);
        btn_next = (Button)rootView.findViewById(R.id.btn_next_exersice);

        ((MainActivity)getActivity()).updateActionBarTitle("WORKOUT NAME");

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).popFragment();
            }
        });

        progressBarExersice.setMax(45);

        startTimer();
        buttonPlayPause.change(false);

        buttonPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPlayPause.toggle();
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });
        return rootView;
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInills, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInills = l;
                updateCountDownText();
                long valueProgressBar = 45 - mTimeLeftInills/1000;
                progressBarExersice.setProgress((int)valueProgressBar);
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
            }
        }.start();
        mTimerRunning = true;
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;

    }

    private void updateCountDownText() {
        //int minutes = (int) (mTimeLeftInills / 1000) / 60;
        int seconds = (int) (mTimeLeftInills / 1000) % 60;
        //String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds); - with minutes
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d", seconds);
        textViewTime.setText(timeLeftFormatted);
    }
}
