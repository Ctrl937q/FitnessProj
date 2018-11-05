package com.example.tituh.fitnessproj.ui.fragments.fitness;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.activities.TimerClass;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class GetReadyFragment extends BaseFragment {

    TextView textViewTime;
    TimerClass timerClass;
    CountDownTimer yourCountDownTimer;
    long sec;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.get_ready_fragment_layout, container, false);
        Button button = (Button) rootView.findViewById(R.id.button_start_workout);
        textViewTime = (TextView) rootView.findViewById(R.id.text_view_timer);

        ((MainActivity) getActivity()).updateActionBarTitle("ASS | LEGS");

        timerClass = new TimerClass();
        yourCountDownTimer = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                sec = (millisUntilFinished / 1000) % 60;
                textViewTime.setText("" + sec);
            }

            public void onFinish() {
                fragmentInteractionListener.pushFragment(new ExersiceDoFragment(), true);

            }
        }.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentInteractionListener.pushFragment(new ExersiceDoFragment(), true);
            }
        });

        return rootView;
    }

    @Override
    public void onPause() {
        yourCountDownTimer.cancel();
        Log.d("onP", "onPause |" + sec);
        super.onPause();
    }
}
