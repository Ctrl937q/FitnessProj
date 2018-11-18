package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.os.Bundle;
import android.os.CountDownTimer;
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
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

public class GetReadyFragment extends BaseFragment {

    TextView textViewTime;
    CountDownTimer mCountDownTimer;
    long sec;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.get_ready_fragment_layout, container, false);
        Button button = (Button) rootView.findViewById(R.id.button_start_workout);
        textViewTime = (TextView) rootView.findViewById(R.id.text_view_timer);

        ((MainActivity) getActivity()).updateActionBarTitle("ASS | LEGS");

        mCountDownTimer = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                sec = (millisUntilFinished / 1000) % 60;
                textViewTime.setText("" + sec);
            }

            public void onFinish() {
                fragmentInteractionListener.pushFragment(new ExersiceDoFragment(), false);
                //fragmentInteractionListener.pushFragmentTest(new ExersiceDoFragment());

            }
        }.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentInteractionListener.pushFragment(new ExersiceDoFragment(), false);
                //fragmentInteractionListener.pushFragmentTest(new ExersiceDoFragment());
            }
        });

        return rootView;
    }

    @Override
    public void onPause() {
        mCountDownTimer.cancel();
        Log.d("onP", "onPause |" + sec);
        super.onPause();
    }
}
