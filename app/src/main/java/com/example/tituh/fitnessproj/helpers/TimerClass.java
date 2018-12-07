package com.example.tituh.fitnessproj.helpers;

import android.os.CountDownTimer;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout.AwardFragment;
import com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout.ExersiceDoFragment;

import java.util.Locale;

public class TimerClass extends BaseFragment {

    private CountDownTimer mCountDownTimerExercise;
    private CountDownTimer mCountDownTimerGetReady;

    private long startTimeInMills;
    private long startTimeInMillsGetReady = 10000;
    private long startTimeInMillsDialog = 10000;

    private long mTimeLeftInMills;
    private long mTimeLeftInMillsGetReady = startTimeInMillsGetReady;
    private long mTimeLeftInMillsDialog = startTimeInMillsDialog;

    private boolean mTimerRunningExercise;
    private boolean mTimerRunningGetReady;

    private boolean mOnPause = false;

    //private boolean mTimerRunningDialog;

    public void startTimerExercise(long startTime,final TextView textView, final ProgressBar progressBar,
                                   final FragmentManager fragmentManager) {
        startTimeInMills = startTime;
        mTimeLeftInMills = startTime;
        mTimerRunningExercise = true;
        mCountDownTimerExercise = new CountDownTimer(mTimeLeftInMills, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMills = l;
                updateCountDownText(textView);
                long valueProgressBar = startTimeInMills / 1000 - mTimeLeftInMills / 1000;
                progressBar.setProgress((int) valueProgressBar);
                Log.d("ssssssdasd1", "" + l);
            }

            @Override
            public void onFinish() {
                mTimerRunningExercise = false;
                mCountDownTimerExercise.cancel();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment_container, new AwardFragment(), "awardfragment");
                ft.addToBackStack("awardfragment");
                ft.commit();
            }
        }.start();
        mTimerRunningExercise = true;
    }

    public void startStopTimerExercise(final TextView textView, final ProgressBar progressBar,
                                       final FragmentManager fragmentManager){
        mTimerRunningExercise = true;
        mCountDownTimerExercise = new CountDownTimer(mTimeLeftInMills, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMills = l;
                updateCountDownText(textView);
                long valueProgressBar = startTimeInMills / 1000 - mTimeLeftInMills / 1000;
                progressBar.setProgress((int) valueProgressBar);
                Log.d("ssssssdasd1", "" + l);
            }

            @Override
            public void onFinish() {
                mTimerRunningExercise = false;
                mCountDownTimerExercise.cancel();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment_container, new AwardFragment(), "awardfragment");
                ft.addToBackStack("awardfragment");
                ft.commit();
            }
        }.start();
        mTimerRunningExercise = true;
    }

    public void startTimerGetReady(final TextView textViewTime, final FragmentManager fragmentManager) {
        mTimerRunningGetReady = true;
        mCountDownTimerGetReady = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillsGetReady = millisUntilFinished;
                updateCountDownGetReady(textViewTime);
                Log.d("dddddasd", "+");
            }

            public void onFinish() {
                mTimerRunningGetReady = false;
                mCountDownTimerGetReady.cancel();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment_container, new ExersiceDoFragment(), "exercisedofragment");
                ft.commit();

            }
        }.start();
        mTimerRunningGetReady = true;

    }




    public void pauseTimerExercise() {
        mCountDownTimerExercise.cancel();
        mTimerRunningExercise = false;
    }

    public void pauseTimerGetReady() {
        mCountDownTimerGetReady.cancel();
        mTimerRunningExercise = false;
    }

    private void updateCountDownText(TextView textView) {
        int seconds = (int) (mTimeLeftInMills / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%1d", seconds);
        textView.setText(timeLeftFormatted);
    }

    private void updateCountDownGetReady(TextView textView) {
        int seconds = (int) (mTimeLeftInMillsGetReady / 1000) % 60;
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

    public boolean ismTimerRunningExercise() {
        return mTimerRunningExercise;
    }

    public boolean ismTimerRunningGetReady() {
        return mTimerRunningGetReady;
    }

    public CountDownTimer getmCountDownTimerExercise() {
        return mCountDownTimerExercise;
    }

    public void setmCountDownTimerExercise(CountDownTimer mCountDownTimerExercise) {
        this.mCountDownTimerExercise = mCountDownTimerExercise;
    }

    public void setmTimerRunningExercise(boolean mTimerRunningExercise) {
        this.mTimerRunningExercise = mTimerRunningExercise;
    }

    public void setmTimerRunningGetReady(boolean mTimerRunningGetReady) {
        this.mTimerRunningGetReady = mTimerRunningGetReady;
    }

    public long getStartTimeInMills() {
        return startTimeInMills;
    }

    public void setStartTimeInMills(long startTimeInMills) {
        this.startTimeInMills = startTimeInMills;
    }

    public void setmTimeLeftInMills(long mTimeLeftInMills) {
        this.mTimeLeftInMills = mTimeLeftInMills;
    }

    public boolean ismOnPause() {
        return mOnPause;
    }

    public void setmOnPause(boolean mOnPause) {
        this.mOnPause = mOnPause;
    }
}