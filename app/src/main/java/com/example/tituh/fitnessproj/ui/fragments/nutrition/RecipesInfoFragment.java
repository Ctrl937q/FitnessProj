package com.example.tituh.fitnessproj.ui.fragments.nutrition;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.example.tituh.fitnessproj.adapters.RecipesInfoRecyclerViewAdapter;
import com.example.tituh.fitnessproj.helpers.MarginItemDecoration;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;

public class RecipesInfoFragment extends BaseFragment {

    ArrayList<String>arrayListTitle;
    SharedPreferences sharedPref;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.recipes_info_fragment, container, false);
        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        arrayListTitle = new ArrayList<>();
        arrayListTitle.add("4 GG crackers (raisin preferred)");
        arrayListTitle.add("2 eggs");
        arrayListTitle.add("1 tsp Stevia or whatever sweetener you like");
        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView_recipes_info);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecipesInfoRecyclerViewAdapter(arrayListTitle, sharedPref, getActivity()));
        //arrayListTitle = (ArrayList<String>) SharedPreferencesUtil.pullStringList(sharedPref, "key");
        //Log.d("dddssa", " " + firstname1 = firstname1.replaceAll("[^A-Z]",""););
        recyclerView.addItemDecoration(new MarginItemDecoration(40, 1));

        return rootView;
    }
}
