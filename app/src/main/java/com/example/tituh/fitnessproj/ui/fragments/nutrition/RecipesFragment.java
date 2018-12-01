package com.example.tituh.fitnessproj.ui.fragments.nutrition;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    private RecyclerView mHorizontalRecyclerView;
    private RecyclerView mVerticalRecyclerView;
    private ArrayList<String> mArrayListRecipesCategory;
    private ArrayList<RecipesModel> mArrayListRecipes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.recipes_fragment, container, false);
            ((MainActivity) getActivity()).updateActionBarTitle("RECIPES");
            ((MainActivity) getActivity()).visibleIconBacktActionBar();
            mHorizontalRecyclerView = view.findViewById(R.id.horizontal_recyclerView_recipes);
            mVerticalRecyclerView = view.findViewById(R.id.vertical_recyclerView_recipes);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                    LinearLayoutManager.HORIZONTAL, false);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
            mArrayListRecipesCategory = new ArrayList<>();

            mArrayListRecipesCategory.add("Breakfast");
            mArrayListRecipesCategory.add("Mains");
            mArrayListRecipesCategory.add("Snacks");
            mArrayListRecipesCategory.add("Sweets");
            mArrayListRecipesCategory.add("Booze");

            mArrayListRecipes = new ArrayList<>();
            mArrayListRecipes.add(new RecipesModel("morning eggs with salsa"));
            mArrayListRecipes.add(new RecipesModel("second title"));
            mArrayListRecipes.add(new RecipesModel("third title"));
            mArrayListRecipes.add(new RecipesModel("fourth title"));
            mArrayListRecipes.add(new RecipesModel("fifth title"));
            mArrayListRecipes.add(new RecipesModel("six title"));
            mArrayListRecipes.add(new RecipesModel("seven title"));

            mHorizontalRecyclerView.setLayoutManager(layoutManager);
            mVerticalRecyclerView.setLayoutManager(gridLayoutManager);
            mHorizontalRecyclerView.setAdapter(new RecipesHorizontalRecyclerViewAdapter(mArrayListRecipesCategory));

            mVerticalRecyclerView.setAdapter(new RecipesVerticalRecyclerViewAdapter(mArrayListRecipes));
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

            mVerticalRecyclerView.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                    mHorizontalRecyclerView, new RecyclerTouchListenerStart.ClickListener() {
                @Override
                public void onClick(View view, final int position) {
                    if (null != fragmentInteractionListener) {
                        fragmentInteractionListener.pushFragment(new RecipesInfoFragment(), true);
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
