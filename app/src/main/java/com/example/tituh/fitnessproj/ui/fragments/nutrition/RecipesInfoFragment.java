package com.example.tituh.fitnessproj.ui.fragments.nutrition;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.RecipesInfoRecyclerViewAdapter;
import com.example.tituh.fitnessproj.helpers.MarginItemDecoration;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;

public class RecipesInfoFragment extends BaseFragment {

    private ArrayList<String> mArrayListTitle;
    private SharedPreferences mSharedPref;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.recipes_info_fragment, container, false);
            mSharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
            mArrayListTitle = new ArrayList<>();
            mArrayListTitle.add("4 GG crackers (raisin preferred)");
            mArrayListTitle.add("2 eggs");
            mArrayListTitle.add("1 tsp Stevia or whatever sweetener you likes");
            RecyclerView recyclerView = view.findViewById(R.id.recyclerView_recipes_info);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(new RecipesInfoRecyclerViewAdapter(mArrayListTitle, mSharedPref));
            recyclerView.addItemDecoration(new MarginItemDecoration(1, 20, 20, 0, 0));
        }
        return view;
    }
}
