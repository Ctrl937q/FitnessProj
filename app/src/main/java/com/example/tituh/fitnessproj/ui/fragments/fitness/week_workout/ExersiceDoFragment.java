package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.helpers.ProgressBarDrawable;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.helpers.TimerClass;
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
    private ProgressBar progressBarAllProgress;
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.workout_start_layout, container, false);
        imageView = (ImageView)rootView.findViewById(R.id.image_view_exercise_do);
        mTextViewTime = (TextView) rootView.findViewById(R.id.text_view_time);
        final PlayPauseView buttonPlayPause = (PlayPauseView) rootView.findViewById(R.id.button_test_start_exercise);
        mProgressBarExersice = (ProgressBar) rootView.findViewById(R.id.progressBar_exersice);
        mButtonBack = (Button) rootView.findViewById(R.id.btn_back_exersice);
        mButtonNext = (Button) rootView.findViewById(R.id.btn_next_exersice);
        progressBarAllProgress = (ProgressBar)rootView.findViewById(R.id.progress_bar_do_exercise);
        ProgressBarDrawable bgProgress= new ProgressBarDrawable(6);
        progressBarAllProgress.setProgressDrawable(bgProgress);
        progressBarAllProgress.setProgress(55);
        mProgressBarExersice.setMax(timerValue);
        timerClass = new TimerClass();

        ((MainActivity) getActivity()).updateActionBarTitle("WORKOUT NAME");
        ((MainActivity) getActivity()).visibilityIconHomeActionBar();
        ((MainActivity) getActivity()).goneIconBacktActionBar();


        timerClass.startTimer(timerValue, mTextViewTime, mProgressBarExersice);
        buttonPlayPause.change(false);

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*timerClass.pauseTimerDialog();
                DialogFragmentExersice dialogFragmentExersice = new DialogFragmentExersice(getActivity());
                dialogFragmentExersice.show();
                dialogFragmentExersice.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                buttonPlayPause.change(true);*/
                fragmentInteractionListener.pushFragment(new RestFragment(), true);



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

    public void pushNext(){
        fragmentInteractionListener.pushFragment(new RestFragment(), true);
    }

}
