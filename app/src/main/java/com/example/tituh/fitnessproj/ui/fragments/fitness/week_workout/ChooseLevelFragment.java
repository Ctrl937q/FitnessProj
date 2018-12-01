package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.ChooseLevelRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.model.ChooseLevelModel;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;

public class ChooseLevelFragment extends BaseFragment {

    private ArrayList<ChooseLevelModel> mModelLevel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null) {
            view = inflater.inflate(R.layout.week_workout_choose_level_fragment, container, false);

            RecyclerView recyclerView =  view.findViewById(R.id.recycler_view_choose_level);

            fragmentInteractionListener.updateActionBarTitle("12 WEEK");
            fragmentInteractionListener.visibleIconBacktActionBar();
            fragmentInteractionListener.visibleIconAboutActionBar();
            fragmentInteractionListener.goneIconHomeActionBar();
            fragmentInteractionListener.goneIconInfoActionBar();
            fragmentInteractionListener.goneIconShareActionBar();

            mModelLevel = new ArrayList<>();

            mModelLevel.add(new ChooseLevelModel(R.drawable.vector_medal_beginner, "BEGINNER"));
            mModelLevel.add(new ChooseLevelModel(R.drawable.vector_medal_intermediate, "INTERMEDIATE"));
            mModelLevel.add(new ChooseLevelModel(R.drawable.vector_medal_advanced, "ADVANCED"));

            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(new ChooseLevelRecyclerViewAdapter(mModelLevel));

            recyclerView.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                    recyclerView, new RecyclerTouchListenerStart.ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    if (position == 1) {
                        if (null != fragmentInteractionListener) {
                            fragmentInteractionListener.pushFragment(new WeekWorkoutFragment(), true);
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

    @Override
    public void onDestroy() {
        ((MainActivity) getActivity()).updateActionBarTitle("TSC BODY");
        super.onDestroy();
    }


    @Override
    public void onResume() {
        FragmentManager fragmentManager = getFragmentManager();
        Log.d("dasdaf32rdfge", "" + fragmentManager.getBackStackEntryCount());
        super.onResume();
    }

}
