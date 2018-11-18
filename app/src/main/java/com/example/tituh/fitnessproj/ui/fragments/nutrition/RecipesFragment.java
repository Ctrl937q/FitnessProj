package com.example.tituh.fitnessproj.ui.fragments.nutrition;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.RecipesHorizontalRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecipesVerticalRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.helpers.SpacesItemDecoration;
import com.example.tituh.fitnessproj.model.RecipesModel;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;

public class RecipesFragment extends BaseFragment {

    RecyclerView mHorizontalRecyclerView;
    RecyclerView mVerticalRecyclerView;
    ArrayList<String> arrayListRecipesCategory;
    ArrayList<RecipesModel> arrayListRecipes;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.recipes_fragment, container, false);
        ((MainActivity) getActivity()).updateActionBarTitle("RECIPES");
        mHorizontalRecyclerView = (RecyclerView) rootView.findViewById(R.id.horizontal_recyclerView_recipes);
        mVerticalRecyclerView = (RecyclerView) rootView.findViewById(R.id.vertical_recyclerView_recipes);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        arrayListRecipesCategory = new ArrayList<>();

        arrayListRecipesCategory.add("Breakfast");
        arrayListRecipesCategory.add("Mains");
        arrayListRecipesCategory.add("Snacks");
        arrayListRecipesCategory.add("Sweets");
        arrayListRecipesCategory.add("Booze");

        arrayListRecipes = new ArrayList<>();
        arrayListRecipes.add(new RecipesModel("morning eggs with salsa"));
        arrayListRecipes.add(new RecipesModel("second title"));
        arrayListRecipes.add(new RecipesModel("third title"));
        arrayListRecipes.add(new RecipesModel("fourth title"));
        arrayListRecipes.add(new RecipesModel("fifth title"));
        arrayListRecipes.add(new RecipesModel("six title"));
        arrayListRecipes.add(new RecipesModel("seven title"));

        mHorizontalRecyclerView.setLayoutManager(layoutManager);
        mVerticalRecyclerView.setLayoutManager(gridLayoutManager);
        mHorizontalRecyclerView.setAdapter(new RecipesHorizontalRecyclerViewAdapter(arrayListRecipesCategory));


        mVerticalRecyclerView.setAdapter(new RecipesVerticalRecyclerViewAdapter(arrayListRecipes, getActivity()));
        mVerticalRecyclerView.addItemDecoration(new SpacesItemDecoration(getActivity(), R.dimen.column_spacing));

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
