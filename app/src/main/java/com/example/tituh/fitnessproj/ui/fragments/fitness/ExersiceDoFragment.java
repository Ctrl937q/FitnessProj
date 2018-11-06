package com.example.tituh.fitnessproj.ui.fragments.fitness;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.activities.TimerClass;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import com.example.tituh.fitnessproj.ui.fragments.DialogFragmentExersice;
import com.ohoussein.playpause.PlayPauseView;

public class ExersiceDoFragment extends BaseFragment {

    private TextView mTextViewTime;
    private ProgressBar mProgressBarExersice;
    private Button mButtonBack;
    private Button mButtonNext;
    private TimerClass timerClass;
    private int timerValue = 45;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.workout_start_layout, container, false);

        mTextViewTime = (TextView) rootView.findViewById(R.id.text_view_time);
        final PlayPauseView buttonPlayPause = (PlayPauseView) rootView.findViewById(R.id.button_test_start_exercise);
        mProgressBarExersice = (ProgressBar) rootView.findViewById(R.id.progressBar_exersice);
        mButtonBack = (Button) rootView.findViewById(R.id.btn_back_exersice);
        mButtonNext = (Button) rootView.findViewById(R.id.btn_next_exersice);
        mProgressBarExersice.setMax(timerValue);
        timerClass = new TimerClass();

        ((MainActivity) getActivity()).updateActionBarTitle("WORKOUT NAME");

        timerClass.startTimer(timerValue, mTextViewTime, mProgressBarExersice);
        buttonPlayPause.change(false);

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerClass.pauseTimerDialog();
                fragmentInteractionListener.pushFragment(new GroceryListFragment(), true);
                /*DialogFragmentExersice dialogFragmentExersice = new DialogFragmentExersice(getActivity());
                dialogFragmentExersice.show();
                dialogFragmentExersice.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));*/
                buttonPlayPause.change(true);
                //fragmentInteractionListener.pushFragment(new GroceryListFragment(), true);

            }
        });

        buttonPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPlayPause.toggle();
                if (timerClass.ismTimerRunning()) {
                    timerClass.pauseTimer();
                } else {
                    timerClass.startTimer(timerValue, mTextViewTime, mProgressBarExersice);
                }
            }
        });

        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).popFragment();

            }
        });
        return rootView;
    }
}
