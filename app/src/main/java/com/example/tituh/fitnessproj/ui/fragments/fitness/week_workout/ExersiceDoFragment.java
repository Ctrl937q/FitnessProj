package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.helpers.ProgressBarDrawable;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import com.ohoussein.playpause.PlayPauseView;

public class ExersiceDoFragment extends BaseFragment {

    private TextView mTextViewTime;
    private ProgressBar mProgressBarExersice;
    private Button mButtonBack;
    private Button mButtonNext;
    private int mTimerValue = 20;
    private ProgressBar mProgressBarAllProgress;
    private ImageView mImageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.workout_start_layout, container, false);
            mImageView = view.findViewById(R.id.image_view_exercise_do);
            mTextViewTime = view.findViewById(R.id.text_view_time);
            final PlayPauseView buttonPlayPause = view.findViewById(R.id.button_test_start_exercise);
            mProgressBarExersice = view.findViewById(R.id.progressBar_exersice);
            mButtonBack = view.findViewById(R.id.btn_back_exersice);
            mButtonNext = view.findViewById(R.id.btn_next_exersice);
            mProgressBarAllProgress = view.findViewById(R.id.progress_bar_do_exercise);
            ProgressBarDrawable bgProgress = new ProgressBarDrawable(6);
            mProgressBarAllProgress.setProgressDrawable(bgProgress);
            mProgressBarAllProgress.setProgress(55);
            mProgressBarExersice.setMax(mTimerValue);

            fragmentInteractionListener.updateActionBarTitle("WORKOUT NAME");
            fragmentInteractionListener.visibilityIconHomeActionBar();
            fragmentInteractionListener.goneIconBacktActionBar();
            fragmentInteractionListener.visibilityIconInfoActionBar();
            fragmentInteractionListener.goneIconAbouttActionBar();
            fragmentInteractionListener.goneIconShareActionBar();

            buttonPlayPause.change(false);

            fragmentInteractionListener.startTimerExerciseDo(mTextViewTime, mProgressBarExersice, getFragmentManager());

            mButtonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //timerClass.pauseTimerDialog();
                    //DialogFragmentExersice dialogFragmentExersice = new DialogFragmentExersice(getActivity());
                    //dialogFragmentExersice.show();
                    //dialogFragmentExersice.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    buttonPlayPause.change(true);
                    fragmentInteractionListener.stopTimerExerciseDo();
                    fragmentInteractionListener.pushFragment(new AwardFragment(), true);
                }
            });

            buttonPlayPause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    buttonPlayPause.toggle();
                    fragmentInteractionListener.btnPlayPause(mTimerValue, mTextViewTime,
                            mProgressBarExersice, getFragmentManager());
                }
            });

            mButtonBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                fragmentInteractionListener.btnBackPressed();
                }
            });
        }

        fragmentInteractionListener.updateActionBarTitle("WORKOUT NAME");
        fragmentInteractionListener.visibilityIconHomeActionBar();
        fragmentInteractionListener.goneIconBacktActionBar();
        fragmentInteractionListener.visibilityIconInfoActionBar();
        fragmentInteractionListener.goneIconAbouttActionBar();
        fragmentInteractionListener.goneIconShareActionBar();

        return view;
    }
}