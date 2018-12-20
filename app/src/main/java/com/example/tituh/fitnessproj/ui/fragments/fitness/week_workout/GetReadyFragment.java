package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.Locale;

public class GetReadyFragment extends BaseFragment {

    private TextView mTextViewTime;
    private String mTitle;
    private ExersiceDoFragment exersiceDoFragment;
    private CountDownTimer countDownTimer;
    private long mTimeLeftInMills;
    private boolean isTimerRunning = false;
    String key;
    int dayClick;
    int weekClick;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.get_ready_fragment_layout, container, false);
            final Button button = view.findViewById(R.id.button_start_workout);
            mTextViewTime = view.findViewById(R.id.text_view_timer);
            mTitle = getArguments().getString("title");
            key = getArguments().getString("key");
            weekClick = getArguments().getInt("week_click");
            dayClick = getArguments().getInt("day_click");
            fragmentInteractionListener.updateActionBarTitle(mTitle);
            fragmentInteractionListener.goneIconAbouttActionBar();
            fragmentInteractionListener.visibleIconBacktActionBar();
            fragmentInteractionListener.goneIconHomeActionBar();
            fragmentInteractionListener.goneIconInfoActionBar();
            fragmentInteractionListener.goneIconShareActionBar();
            isTimerRunning = true;
            startStopTimerExercise();
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bundleAndPush();
                }
            });
        }

        fragmentInteractionListener.updateActionBarTitle(mTitle);
        fragmentInteractionListener.goneIconAbouttActionBar();
        fragmentInteractionListener.visibleIconBacktActionBar();
        fragmentInteractionListener.goneIconHomeActionBar();
        fragmentInteractionListener.goneIconInfoActionBar();
        fragmentInteractionListener.goneIconShareActionBar();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void startStopTimerExercise() {
        countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMills = l;
                updateCountDownText(mTextViewTime);
            }

            @Override
            public void onFinish() {
                isTimerRunning = false;
                bundleAndPush();
            }
        }.start();
    }


    public void pauseTimer() {
        countDownTimer.cancel();
    }

    private void updateCountDownText(TextView textView) {
        int seconds = (int) (mTimeLeftInMills / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%1d", seconds);
        textView.setText(timeLeftFormatted);
    }

    private void bundleAndPush() {
        pauseTimer();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("array_trainings_one_three_workout",
                getArguments().getParcelableArrayList("array_trainings_one_three"));
        bundle.putParcelableArrayList("array_trainings_two_four_workout",
                getArguments().getParcelableArrayList("array_trainings_two_four"));
        bundle.putInt("level", getArguments().getInt("level"));
        bundle.putString("title", mTitle);
        bundle.putString("week", getArguments().getString("week"));
        bundle.putString("day", getArguments().getString("day"));
        bundle.putString("key", key);
        bundle.putInt("week_click", weekClick);
        bundle.putInt("day_click", dayClick);


        exersiceDoFragment = new ExersiceDoFragment();
        exersiceDoFragment.setArguments(bundle);
        FragmentManager manager = getFragmentManager();
        if (manager != null) {
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.fragment_container, exersiceDoFragment, "fragment_if_you_need");
            ft.addToBackStack("fragment_if_you_need");
            ft.commit();
            pauseTimer();
        }

    }


    @Override
    public void onDestroy() {
        pauseTimer();
        super.onDestroy();
    }
}