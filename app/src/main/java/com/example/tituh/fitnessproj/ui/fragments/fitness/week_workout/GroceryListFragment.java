package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.FitnessFragmentStartRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.GroceryHorizontalRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;

public class GroceryListFragment extends BaseFragment {

    RecyclerView mHorizontalRecyclerView;
    ArrayList mArrayListCategory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.grocery_list_fragment, container, false);

        mHorizontalRecyclerView = (RecyclerView) rootView.findViewById(R.id.horizontal_recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);

        mArrayListCategory = new ArrayList();
        mArrayListCategory.add("FRUITS AND VEGGIES");
        mArrayListCategory.add("NUTS,SWEETS AND SNUCKS");
        mArrayListCategory.add("PROTEINS");
        mArrayListCategory.add("PROTEINS");
        mArrayListCategory.add("PROTEINS");
        mArrayListCategory.add("PROTEINS");
        mArrayListCategory.add("PROTEINS");

        ((MainActivity) getActivity()).updateActionBarTitle("GROCERY LIST");

        mHorizontalRecyclerView.setLayoutManager(layoutManager);
        mHorizontalRecyclerView.setAdapter(new GroceryHorizontalRecyclerViewAdapter(mArrayListCategory));
        mHorizontalRecyclerView.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                mHorizontalRecyclerView, new RecyclerTouchListenerStart.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                    if (null != fragmentInteractionListener) {

                }
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));

        return rootView;
    }
}
