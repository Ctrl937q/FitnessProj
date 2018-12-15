package com.example.tituh.fitnessproj.ui.fragments.nutrition;

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
import com.example.tituh.fitnessproj.adapters.NutritionFragmentRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.model.NutritionModel;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class NutritionFragment extends BaseFragment {

    private RecyclerView mRecyclerViewNutritionFragment;
    private List<NutritionModel> mListNutritionModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {

            view = inflater.inflate(R.layout.nutrition_fragment, container, false);

            fragmentInteractionListener.visibleIconAboutActionBar();
            fragmentInteractionListener.goneIconBacktActionBar();
            Log.d("asd32wefragt", " + ");

            mRecyclerViewNutritionFragment = view.findViewById(R.id.recycler_view_nutrition);

            mListNutritionModel = new ArrayList<>();
            mListNutritionModel.add(new NutritionModel("Recipes", "About Daily Recipes",
                    NutritionModel.ONE_TYPE));
            mListNutritionModel.add(new NutritionModel("Grocery List", NutritionModel.TWO_TYPE,
                    R.drawable.vector_orange_grocery_list));
            mListNutritionModel.add(new NutritionModel("7 Day Meal Plan", NutritionModel.TWO_TYPE,
                    R.drawable.vector_seven_day_meel_plan));

            mRecyclerViewNutritionFragment.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerViewNutritionFragment.setAdapter(new NutritionFragmentRecyclerViewAdapter(mListNutritionModel));

            mRecyclerViewNutritionFragment.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                    mRecyclerViewNutritionFragment, new RecyclerTouchListenerStart.ClickListener() {
                @Override
                public void onClick(View view, final int position) {
                    if (position == 0) {
                        if (null != fragmentInteractionListener) {
                            fragmentInteractionListener.pushFragment(new RecipesFragment(), true);
                        }
                    }

                    if (position == 1) {
                        if (null != fragmentInteractionListener) {
                            fragmentInteractionListener.pushFragment(new GroceryListFragment(), true);
                        }
                    }

                    if (position == 2) {
                        if (null != fragmentInteractionListener) {
                            fragmentInteractionListener.pushFragment(new SevenDayMealPlanFragment(), true);
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