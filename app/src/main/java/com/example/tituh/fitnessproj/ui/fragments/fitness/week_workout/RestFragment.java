package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

@SuppressLint("ValidFragment")
public class RestFragment extends BaseFragment {

    private CountDownTimer mCountDownTimer;
    private long mSec;
    private TextView mTextViewTimer;
    private TextView mTextViewCircuit;
    private Button mButton;
    private String title;
    private int circuit;
    private int curentCircuit;
    private ExersiceDoFragment exersiceDoFragment;
    private boolean isTimerActive;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.rest_fragment, container, false);
            mTextViewTimer = view.findViewById(R.id.text_view_timer_rest);
            mTextViewCircuit = view.findViewById(R.id.text_view_circuit);
            mButton = view.findViewById(R.id.button_start_circuit);
            fragmentInteractionListener.goneIconAbouttActionBar();
            fragmentInteractionListener.goneIconBacktActionBar();
            fragmentInteractionListener.goneIconHomeActionBar();
            fragmentInteractionListener.goneIconInfoActionBar();
            fragmentInteractionListener.goneIconShareActionBar();
            circuit = getArguments().getInt("circuit");
            title = getArguments().getString("title");
            curentCircuit = circuit - 1;
            FragmentManager fm = getFragmentManager();
            exersiceDoFragment = (ExersiceDoFragment) fm.findFragmentByTag("fragment_if_you_need");

            fragmentInteractionListener.updateActionBarTitle(title);
            mTextViewCircuit.setText(curentCircuit + " out of 4 circuits");
            mButton.setText("skip timer start circuit " + circuit);

            startTimer();

            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exersiceDoFragment.setContent();
                    mCountDownTimer.cancel();
                    fragmentInteractionListener.popFragment();
                }
            });
        }
        return view;
    }


    private void startTimer() {
        isTimerActive = true;
        mCountDownTimer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                mSec = (millisUntilFinished / 1000) % 60;
                mTextViewTimer.setText("" + mSec);
            }

            public void onFinish() {
                isTimerActive = false;
                mCountDownTimer.cancel();
                exersiceDoFragment.setContent();
                fragmentInteractionListener.popFragment();
            }
        }.start();
    }

    @Override
    public void onPause() {
        mCountDownTimer.cancel();
        isTimerActive = false;
        super.onPause();
    }

    @Override
    public void onResume() {
        if (!isTimerActive) {
            startTimer();
        }
        super.onResume();
    }
}
