package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.helpers.TimerClass;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

public class GetReadyFragment extends BaseFragment {

    TextView textViewTime;
    TimerClass timerClass;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.get_ready_fragment_layout, container, false);
        Button button = (Button) rootView.findViewById(R.id.button_start_workout);
        textViewTime = (TextView) rootView.findViewById(R.id.text_view_timer);
        timerClass = new TimerClass();

        ((MainActivity) getActivity()).updateActionBarTitle("ASS | LEGS");
        ((MainActivity) getActivity()).goneIconAbouttActionBar();
        ((MainActivity) getActivity()).visibleIconBacktActionBar();
        ((MainActivity) getActivity()).goneIconHomeActionBar();
        ((MainActivity) getActivity()).goneIconInfoActionBar();
        ((MainActivity) getActivity()).goneIconShareActionBar();

        //((MainActivity) getActivity()).startTimerGetReady(textViewTime);
        timerClass.startTimerGetReady(textViewTime, getFragmentManager());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mCountDownTimer.cancel();
                //timerClass.pauseTimerGetReady();
                //mCountDownTimerGetReady.cancel();
                timerClass.pauseTimerGetReady();
                fragmentInteractionListener.pushFragment(new ExersiceDoFragment(), false, "asdas");
            }
        });
        return rootView;
    }
}
