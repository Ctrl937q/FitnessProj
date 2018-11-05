package com.example.tituh.fitnessproj.ui.activities;

import android.os.CountDownTimer;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import com.example.tituh.fitnessproj.ui.fragments.fitness.ExersiceDoFragment;
import com.example.tituh.fitnessproj.ui.fragments.fitness.GroceryListFragment;

import java.util.Locale;

public class TimerClass  {

    private CountDownTimer mCountDownTimer;

    private long startTimeInMills = 46000;
    private long startTimeInMillsDialog = 10000;
    private long startTimeInMillsTest = 10000;
    private long startTimeInMillsCircle = 10000;


    private long mTimeLeftInMills = startTimeInMills;
    private long mTimeLeftInMillsDialog = startTimeInMillsDialog;
    private long mTimeLeftInMillsTest = startTimeInMillsTest;
    private long mTimeLeftInMillsCircle = startTimeInMillsCircle;

    private boolean mTimerRunning;
    private boolean mTimerRunningDialog;
    private boolean mTimerRunningCircle;


    public void startTimer(final int value, final TextView textView, final ProgressBar progressBar) {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMills, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMills = l;
                updateCountDownText(textView);
                long valueProgressBar = value - mTimeLeftInMills / 1000;
                progressBar.setProgress((int) valueProgressBar);
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
            }
        }.start();
        mTimerRunning = true;
    }


    public void startTimerCircle(final int value, final TextView textView) {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillsCircle, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMillsCircle = l;
                updateCountDownTextCircle(textView);
                long valueProgressBar = value - mTimeLeftInMillsCircle / 1000;
            }

            @Override
            public void onFinish() {
                mTimerRunningCircle = false;

            }
        }.start();
        mTimerRunningCircle = true;
    }


    public void startTimerDialog(final TextView textView) {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillsDialog, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMillsDialog = l;
                updateCountDownTextDialog(textView);
            }

            @Override
            public void onFinish() {
                mTimerRunningDialog = false;
            }
        }.start();
        mTimerRunningDialog = true;
    }


    public void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
    }

    public void pauseTimerDialog() {
        mCountDownTimer.cancel();
        mTimerRunningDialog = false;
    }

    private void updateCountDownText(TextView textView) {
        //int minutes = (int) (mTimeLeftInills / 1000) / 60;
        int seconds = (int) (mTimeLeftInMills / 1000) % 60;
        //String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds); - with minutes
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d", seconds);
        textView.setText(timeLeftFormatted);
    }

    private void updateCountDownTextCircle(TextView textView) {
        //int minutes = (int) (mTimeLeftInills / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillsCircle / 1000) % 60;
        //String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds); - with minutes
        String timeLeftFormatted = String.format(Locale.getDefault(), "%1d", seconds);
        textView.setText(timeLeftFormatted);
    }


    private void updateCountDownTextDialog(TextView textView) {
        //int minutes = (int) (mTimeLeftInills / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillsDialog / 1000) % 60;
        //String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds); - with minutes
        String timeLeftFormatted = String.format(Locale.getDefault(), "%1d", seconds);
        textView.setText(timeLeftFormatted);
    }

    public boolean ismTimerRunning() {
        return mTimerRunning;
    }

    public boolean ismTimerRunningDialog() {
        return mTimerRunningDialog;
    }
}