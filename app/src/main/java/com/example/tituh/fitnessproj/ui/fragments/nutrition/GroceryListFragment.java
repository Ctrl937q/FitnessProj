package com.example.tituh.fitnessproj.ui.fragments.nutrition;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.GroceryHorizontalRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.NutritionGroceryListVerticalAdapter;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GroceryListFragment extends BaseFragment {

    RecyclerView mHorizontalRecyclerView;
    RecyclerView mVerticalRecyclerViewGrocery;
    ArrayList mArrayListCategory;
    EditText mEditTextAdd;
    ImageView mImageViewAdd;
    ArrayList<String> arrayListGroceryList;
    String textTitle = " ";
    NutritionGroceryListVerticalAdapter adapter;
    ArrayList<String> arrayListHorRecyclerView;
    SharedPreferences sharedPref;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.grocery_list_fragment, container, false);
        ((MainActivity) getActivity()).updateActionBarTitle("GROCERY LIST");
        ((MainActivity) getActivity()).goneIconAbouttActionBar();
        ((MainActivity) getActivity()).visibleIconBacktActionBar();
        mHorizontalRecyclerView = (RecyclerView) rootView.findViewById(R.id.horizontal_recyclerView_grocery_list);
        mVerticalRecyclerViewGrocery = (RecyclerView) rootView.findViewById(R.id.recyclerView_grocery_list_vertical);
        mEditTextAdd = (EditText) rootView.findViewById(R.id.edit_text_add_grocery_list);
        mImageViewAdd = (ImageView) rootView.findViewById(R.id.image_view_add_grocery_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);
        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        arrayListGroceryList = (ArrayList<String>) SharedPreferencesUtil.pullStringList(sharedPref, "key");
        Collections.sort(arrayListGroceryList, String.CASE_INSENSITIVE_ORDER);

        mVerticalRecyclerViewGrocery.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new NutritionGroceryListVerticalAdapter(arrayListGroceryList, sharedPref);
        mVerticalRecyclerViewGrocery.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        mHorizontalRecyclerView.setLayoutManager(layoutManager);
        mArrayListCategory = new ArrayList();
        if (arrayListGroceryList == null) {
            arrayListGroceryList = new ArrayList<>();
        }

        mArrayListCategory.add("Fruits and veggies");
        mArrayListCategory.add("Nuts,sweet and snuck");
        mArrayListCategory.add("Proteins");


        mImageViewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textTitle.equals(" ")) {
                    textTitle = textTitle.replaceFirst("^ *", "");
                    arrayListGroceryList.add(textTitle);
                    Collections.sort(arrayListGroceryList, String.CASE_INSENSITIVE_ORDER);
                    adapter.notifyDataSetChanged();
                    SharedPreferencesUtil.pushStringList(sharedPref, arrayListGroceryList, "key");
                    mEditTextAdd.getText().clear();
                }
            }
        });


        mEditTextAdd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(final CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    mImageViewAdd.setClickable(false);
                    mEditTextAdd.setBackground(getResources().getDrawable(R.drawable.border_edit_text_empty));
                    mImageViewAdd.setImageResource(R.drawable.vector_add_grocery_list_empty);
                } else {
                    mImageViewAdd.setClickable(true);
                    mEditTextAdd.setBackground(getResources().getDrawable(R.drawable.border_edit_text_not_empty));
                    mImageViewAdd.setImageResource(R.drawable.vector_add_grocery_list_not_empty);
                    textTitle = charSequence.toString();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (mEditTextAdd.getText().toString().startsWith(" "))
                    mEditTextAdd.setText("");
            }
        });


        mHorizontalRecyclerView.setAdapter(new GroceryHorizontalRecyclerViewAdapter(mArrayListCategory));
        mHorizontalRecyclerView.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                mHorizontalRecyclerView, new RecyclerTouchListenerStart.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                if (null != fragmentInteractionListener) {
                    //TODO: ?
                    final CardView cardView = view.findViewById(R.id.card_view_horizontal_recycler_view_grocery_list);
                    cardView.setCardBackgroundColor(getResources().getColor(R.color.color_grocery_list_card_view_checked));
                    if (position == 0) {
                        arrayListHorRecyclerView = new ArrayList<>();
                        arrayListHorRecyclerView.add("Apple");
                        arrayListHorRecyclerView.add("Cheese");
                        arrayListHorRecyclerView.add("Chips");
                        arrayListGroceryList.addAll(arrayListHorRecyclerView);
                        Collections.sort(arrayListGroceryList, String.CASE_INSENSITIVE_ORDER);

                        adapter.notifyDataSetChanged();
                        SharedPreferencesUtil.pushStringList(sharedPref, arrayListGroceryList, "key");

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
