package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class AwardFragment extends BaseFragment {

    TextView textViewAwardCompleted;
    String key;
    int level;
    int weekclick;
    int position;
    int dayClick;
    ArrayList<Integer>arrayListProgressWeek;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.award_fragment, container, false);
            textViewAwardCompleted = view.findViewById(R.id.text_view_completed_award);
            fragmentInteractionListener.goneIconAbouttActionBar();
            fragmentInteractionListener.visibilityIconShareActionBar();
            fragmentInteractionListener.goneIconInfoActionBar();
            fragmentInteractionListener.goneIconHomeActionBar();
            fragmentInteractionListener.updateActionBarTitle(getArguments().getString("title"));
            arrayListProgressWeek = new ArrayList<>();
            level = getArguments().getInt("level");
            key = getArguments().getString("key");
            weekclick = getArguments().getInt("week_click");
            dayClick = getArguments().getInt("day_click");
            position = weekclick - 1;











            textViewAwardCompleted.setText("You have competed \n" + getArguments().getString("week") + " - " + getArguments().getString("day"));
            Button buttonMainMenu = view.findViewById(R.id.button_main_manu_award);
            buttonMainMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fragmentInteractionListener.popFragment();
                    fragmentInteractionListener.popFragment();
                    fragmentInteractionListener.popFragment();
                    fragmentInteractionListener.popFragment();
                }
            });
        }

        fragmentInteractionListener.goneIconAbouttActionBar();
        fragmentInteractionListener.visibilityIconShareActionBar();
        fragmentInteractionListener.goneIconInfoActionBar();
        fragmentInteractionListener.goneIconHomeActionBar();

        return view;
    }
}
