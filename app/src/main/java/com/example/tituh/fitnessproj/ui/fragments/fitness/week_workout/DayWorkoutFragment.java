package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.DayWorkoutFragmentRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.model.DayWorkoutModel;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import java.util.ArrayList;
import java.util.List;

public class DayWorkoutFragment extends BaseFragment {

    private List<DayWorkoutModel> mList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.day_workout_layout, container, false);
            mList = new ArrayList<>();
            mList.add(new DayWorkoutModel("3", "OUT OF 12 WEEKS"));
            mList.add(new DayWorkoutModel("Day 1", "ASS | LEGGS"));
            mList.add(new DayWorkoutModel("Day 2", "ARS | BECK"));
            mList.add(new DayWorkoutModel("Day 3", "FULL SHEBANG"));

            RecyclerView recyclerView = view.findViewById(R.id.recyclerView_workout_day);

            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(new DayWorkoutFragmentRecyclerViewAdapter(mList));

            fragmentInteractionListener.updateActionBarTitle("WEEK 3");
            fragmentInteractionListener.goneIconAbouttActionBar();
            fragmentInteractionListener.visibleIconBacktActionBar();
            fragmentInteractionListener.goneIconHomeActionBar();
            fragmentInteractionListener.goneIconInfoActionBar();
            fragmentInteractionListener.goneIconShareActionBar();

            recyclerView.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                    recyclerView, new RecyclerTouchListenerStart.ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    if (position == 3) {
                        if (null != fragmentInteractionListener) {
                            fragmentInteractionListener.pushFragment(new ExerciseInfoFragment(), true);
                        }
                    }
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));
        }
        return view;
    }
}
