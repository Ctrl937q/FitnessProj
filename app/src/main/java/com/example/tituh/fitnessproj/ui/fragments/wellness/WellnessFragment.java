package com.example.tituh.fitnessproj.ui.fragments.wellness;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.adapters.WellnessFragmentRecyclerViewAdapter;
import com.example.tituh.fitnessproj.model.WellnessModel;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class WellnessFragment extends BaseFragment {

    RecyclerView mRecyclerViewWellnessFragment;
    private List<WellnessModel> mListWellnessModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.wellness_fragment, container, false);
        ((MainActivity) getActivity()).updateActionBarTitle("Wellness");
        ((MainActivity) getActivity()).visibleIconAboutActionBar();
        ((MainActivity) getActivity()).goneIconBacktActionBar();
        mRecyclerViewWellnessFragment = (RecyclerView) rootView.findViewById(R.id.recycler_view_wellness);

        mListWellnessModel = new ArrayList<>();
        mListWellnessModel.add(new WellnessModel("Daily Habits", "About Daily Habits", WellnessModel.ONE_TYPE));
        mListWellnessModel.add(new WellnessModel("Protein Powder Guide",WellnessModel.TWO_TYPE, R.drawable.vector_wellness_protein));
        mListWellnessModel.add(new WellnessModel("8 Tips for your success",WellnessModel.TWO_TYPE, R.drawable.vector_wellness_tips));

        mRecyclerViewWellnessFragment.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerViewWellnessFragment.setAdapter(new WellnessFragmentRecyclerViewAdapter(mListWellnessModel));


        mRecyclerViewWellnessFragment.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                mRecyclerViewWellnessFragment, new RecyclerTouchListenerStart.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                if (position == 0) {
                    if (null != fragmentInteractionListener) {
                        fragmentInteractionListener.pushFragment(new DailyHabitsFragment(), true);
                    }
                }

                if (position == 1) {
                    if (null != fragmentInteractionListener) {
                        fragmentInteractionListener.pushFragment(new ProteinPowderGuideFragment(), true);
                    }
                }

                if(position == 2){
                    if (null != fragmentInteractionListener) {
                        fragmentInteractionListener.pushFragment(new TipsForYourSuccess(), true);
                    }
                }
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));

        return rootView;
    }
}