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
import com.example.tituh.fitnessproj.ui.interfaces.OnFragmentInteractionListener;

import java.util.Locale;

public class TimerClass extends BaseFragment {

    private CountDownTimer mCountDownTimerExercise;
    private CountDownTimer mCountDownTimerGetReady;

    private long startTimeInMills = 5000;
    private long startTimeInMillsGetReady = 10000;
    private long startTimeInMillsDialog = 10000;

    private long mTimeLeftInMills = startTimeInMills;
    private long mTimeLeftInMillsGetReady = startTimeInMillsGetReady;
    private long mTimeLeftInMillsDialog = startTimeInMillsDialog;

    private boolean mTimerRunningExercise;
    private boolean mTimerRunningGetReady;

    //private boolean mTimerRunningDialog;

    public void startTimerExercise(final int value, final TextView textView, final ProgressBar progressBar, final FragmentManager fragmentManager) {
        mCountDownTimerExercise = new CountDownTimer(mTimeLeftInMills, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMills = l;
                updateCountDownText(textView);
                long valueProgressBar = value - mTimeLeftInMills / 1000;
                progressBar.setProgress((int) valueProgressBar);
                Log.d("ssssssdasd1", "+");
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



  /*  public void startTimerDialog(final TextView textView) {
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
    }*/

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
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d", seconds);
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
}
