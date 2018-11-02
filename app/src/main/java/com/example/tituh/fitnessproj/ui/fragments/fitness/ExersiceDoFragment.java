package com.example.tituh.fitnessproj.ui.fragments.fitness;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.activities.MaterialPlayPauseButton;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import org.w3c.dom.Text;

import java.util.Locale;

public class ExersiceDoFragment extends BaseFragment {

    long startTimeills = 45000;
    CountDownTimer mCountDownTimer;
    long mTimeLeftInills = startTimeills;
    boolean mTimerRunning;

    TextView textViewTime;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.workout_start_layout, container, false);

        textViewTime = (TextView)rootView.findViewById(R.id.text_view_time);
        MaterialPlayPauseButton buttonPlayPause = (MaterialPlayPauseButton) rootView.findViewById(R.id.button_test_start_exercise);

        buttonPlayPause.setColor(Color.BLACK);
        buttonPlayPause.setAnimDuration(300);

        buttonPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
    //            buttonStartPause.setText("Start");
            }
        }.start();
        mTimerRunning = true;
    //    buttonStartPause.setText("pause");
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
    //    buttonStartPause.setText("Start");

    }

    private void updateCountDownText() {
        //int minutes = (int) (mTimeLeftInills / 1000) / 60;
        int seconds = (int) (mTimeLeftInills / 1000) % 60;
        //String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds); - with minutes
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d", seconds);
        textViewTime.setText(timeLeftFormatted);
    }
}
