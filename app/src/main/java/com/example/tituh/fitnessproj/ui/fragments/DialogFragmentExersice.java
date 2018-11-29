package com.example.tituh.fitnessproj.ui.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.helpers.TimerClass;
import com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout.ExersiceDoFragment;
import com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout.RestFragment;
import com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout.WeekWorkoutFragment;

import mehdi.sakout.fancybuttons.FancyButton;

public class DialogFragmentExersice extends Dialog {

    private FancyButton mButtonSkip;
    private TextView mTextViewTest;
    private TimerClass timerClass;
    long sec;
    CountDownTimer mCountDownTimer;
    ExersiceDoFragment exersiceDoFragment;

    public DialogFragmentExersice(Activity activity) {
        super(activity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_layout);
        exersiceDoFragment = new ExersiceDoFragment();
        mButtonSkip = (FancyButton) findViewById(R.id.btn_skip_workout);
        mTextViewTest = (TextView) findViewById(R.id.text_view_seconds_left);
        //timerClass = new TimerClass();
        //timerClass.startTimerDialog(mTextViewTest);
        setCancelable(false);
        mCountDownTimer = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                sec = (millisUntilFinished / 1000) % 60;
                mTextViewTest.setText("" + sec);
            }

            public void onFinish() {
                mCountDownTimer.cancel();
                dismiss();
            }
        }.start();

        mButtonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCountDownTimer.cancel();
                //exersiceDoFragment.setImage();
                //exersiceDoFragment.pushNext();
                dismiss();
            }
        });
    }
}