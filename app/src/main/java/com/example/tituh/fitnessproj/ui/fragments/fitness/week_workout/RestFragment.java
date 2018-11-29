package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

public class RestFragment extends BaseFragment {

    CountDownTimer mCountDownTimer;
    long mSec;
    TextView mTextView;
    Button mButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.rest_fragment, container, false);

        ((MainActivity)getActivity()).goneIconAbouttActionBar();
        ((MainActivity)getActivity()).visibleIconBacktActionBar();
        ((MainActivity)getActivity()).goneIconHomeActionBar();
        ((MainActivity)getActivity()).goneIconInfoActionBar();
        ((MainActivity) getActivity()).goneIconShareActionBar();

        mTextView = (TextView)rootView.findViewById(R.id.text_view_timer_rest);
        mButton = (Button)rootView.findViewById(R.id.button_start_circuit);

        mCountDownTimer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                mSec = (millisUntilFinished / 1000) % 60;
                mTextView.setText("" + mSec);
            }

            public void onFinish() {
                fragmentInteractionListener.popFragment();
            }
        }.start();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCountDownTimer.cancel();
                fragmentInteractionListener.popFragment();
            }
        });

        return rootView;
    }
}
