package com.example.tituh.fitnessproj.ui.fragments.nutrition;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
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
import com.example.tituh.fitnessproj.helpers.MarginItemDecoration;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GroceryListFragment extends BaseFragment {

    private RecyclerView mHorizontalRecyclerView;
    private RecyclerView mVerticalRecyclerViewGrocery;
    private ArrayList mArrayListCategory;
    private EditText mEditTextAdd;
    private ImageView mImageViewAdd;
    private ArrayList<String> mArrayListGroceryList;
    private String mTextTitle = " ";
    private NutritionGroceryListVerticalAdapter mAdapter;
    private ArrayList<String> mArrayListHorRecyclerView;
    private SharedPreferences mSharedPref;
    private boolean isFirstClick = false;
    private boolean isSecondClick = false;
    private boolean isThirdClick = false;
    private boolean isFourthClick = false;
    private boolean isFiveClick = false;
    private Set<String> deleteDuplArray;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.grocery_list_fragment, container, false);
            fragmentInteractionListener.updateActionBarTitle("GROCERY LIST");
            fragmentInteractionListener.goneIconAbouttActionBar();
            fragmentInteractionListener.visibleIconBacktActionBar();
            mHorizontalRecyclerView = view.findViewById(R.id.horizontal_recyclerView_grocery_list);
            mVerticalRecyclerViewGrocery = view.findViewById(R.id.recyclerView_grocery_list_vertical);
            mEditTextAdd = view.findViewById(R.id.edit_text_add_grocery_list);
            mImageViewAdd = view.findViewById(R.id.image_view_add_grocery_list);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                    LinearLayoutManager.HORIZONTAL, false);
            mSharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
            mArrayListGroceryList = (ArrayList<String>) SharedPreferencesUtil.pullStringList(mSharedPref, "key");
            Collections.sort(mArrayListGroceryList, String.CASE_INSENSITIVE_ORDER);

            mVerticalRecyclerViewGrocery.setLayoutManager(new LinearLayoutManager(getActivity()));
            mAdapter = new NutritionGroceryListVerticalAdapter(mArrayListGroceryList, mSharedPref);
            mVerticalRecyclerViewGrocery.setAdapter(mAdapter);
            mVerticalRecyclerViewGrocery.addItemDecoration(new MarginItemDecoration(1, 40, 40, 0, 0));

            DividerItemDecoration divider = new DividerItemDecoration(mVerticalRecyclerViewGrocery.getContext(), DividerItemDecoration.VERTICAL);
            divider.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.horizontal_divider));
            mVerticalRecyclerViewGrocery.addItemDecoration(divider);

            mAdapter.notifyDataSetChanged();

            mHorizontalRecyclerView.setLayoutManager(layoutManager);
            mArrayListCategory = new ArrayList<String>();
            if (mArrayListGroceryList == null) {
                mArrayListGroceryList = new ArrayList<>();
            }

            mArrayListCategory.add("Breakfast");
            mArrayListCategory.add("Mains");
            mArrayListCategory.add("Snacks");
            mArrayListCategory.add("Sweets");
            mArrayListCategory.add("Booze");
            mArrayListHorRecyclerView = new ArrayList<>();
            deleteDuplArray = new HashSet<>();


            mImageViewAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!mTextTitle.equals(" ")) {
                        mTextTitle = mTextTitle.replaceFirst("^ *", "");
                        mArrayListGroceryList.add(mTextTitle);
                        Collections.sort(mArrayListGroceryList, String.CASE_INSENSITIVE_ORDER);
                        mAdapter.notifyDataSetChanged();
                        SharedPreferencesUtil.pushStringList(mSharedPref, mArrayListGroceryList, "key");
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
                        mTextTitle = charSequence.toString();
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
                        final CardView cardView = view.findViewById(R.id.card_view_horizontal_recycler_view_grocery_list);
                        cardView.setCardBackgroundColor(getResources().getColor(R.color.color_grocery_list_card_view_checked));
                        if (position == 0) {
                            if(isFirstClick){
                                return;
                            }else {
                                isFirstClick = true;
                                mArrayListHorRecyclerView.add("eggs");
                                mArrayListHorRecyclerView.add("almond milk");
                                mArrayListHorRecyclerView.add("oats");
                                mArrayListHorRecyclerView.add("berries");
                                mArrayListGroceryList.addAll(mArrayListHorRecyclerView);
                                Collections.sort(mArrayListGroceryList, String.CASE_INSENSITIVE_ORDER);
                                mAdapter.notifyDataSetChanged();
                                mArrayListHorRecyclerView.clear();
                            }
                        }
                        if (position == 1) {
                            if(isSecondClick){
                                return;
                            }else {
                                isSecondClick = true;
                                mArrayListHorRecyclerView.add("tuna");
                                mArrayListHorRecyclerView.add("kale");
                                mArrayListHorRecyclerView.add("avocado");
                                mArrayListHorRecyclerView.add("arugula");
                                mArrayListHorRecyclerView.add("sliced turkey");
                                mArrayListHorRecyclerView.add("eggs");
                                mArrayListHorRecyclerView.add("riced cauliflower");
                                mArrayListHorRecyclerView.add("lemon");
                                mArrayListHorRecyclerView.add("lentil pasta");
                                mArrayListHorRecyclerView.add("kimchi");
                                mArrayListGroceryList.addAll(mArrayListHorRecyclerView);
                                Collections.sort(mArrayListGroceryList, String.CASE_INSENSITIVE_ORDER);
                                mAdapter.notifyDataSetChanged();
                                mArrayListHorRecyclerView.clear();
                            }
                        }
                        if(position == 2){
                            if(isThirdClick){
                                return;
                            }else {
                                isThirdClick = true;
                                mArrayListHorRecyclerView.add("hummus");
                                mArrayListHorRecyclerView.add("sliced turkey");
                                mArrayListHorRecyclerView.add("popcorn");
                                mArrayListGroceryList.addAll(mArrayListHorRecyclerView);
                                Collections.sort(mArrayListGroceryList, String.CASE_INSENSITIVE_ORDER);
                                mAdapter.notifyDataSetChanged();
                                mArrayListHorRecyclerView.clear();

                            }
                        }
                        if(position == 3){
                            if(isFourthClick){
                                return;
                            }else {
                                isFourthClick = true;
                                mArrayListHorRecyclerView.add("popcorn");
                                mArrayListHorRecyclerView.add("stevia");
                                mArrayListHorRecyclerView.add("peanut butter");
                                mArrayListHorRecyclerView.add("almond butter");
                                mArrayListHorRecyclerView.add("eggs");
                                mArrayListHorRecyclerView.add("almond milk");
                                mArrayListGroceryList.addAll(mArrayListHorRecyclerView);
                                Collections.sort(mArrayListGroceryList, String.CASE_INSENSITIVE_ORDER);
                                mAdapter.notifyDataSetChanged();
                                mArrayListHorRecyclerView.clear();
                            }
                        }
                        if(position == 4){
                            if(isFiveClick){
                                return;
                            }else {
                                isFiveClick = true;
                                mArrayListHorRecyclerView.add("tequila");
                                mArrayListHorRecyclerView.add("orange liqueur");
                                mArrayListHorRecyclerView.add("sparkling water");
                                mArrayListHorRecyclerView.add("rose wine");
                                mArrayListHorRecyclerView.add("lemon");
                                mArrayListHorRecyclerView.add("lime");
                                mArrayListHorRecyclerView.add("vodka");
                                mArrayListHorRecyclerView.add("club soda");
                                mArrayListGroceryList.addAll(mArrayListHorRecyclerView);
                                Collections.sort(mArrayListGroceryList, String.CASE_INSENSITIVE_ORDER);
                                mAdapter.notifyDataSetChanged();
                                mArrayListHorRecyclerView.clear();

                            }
                        }
                    }
                }

                @Override
                public void onLongClick(View view, int position) {
                }
            }));
        }
        fragmentInteractionListener.updateActionBarTitle("GROCERY LIST");

        return view;
    }

    @Override
    public void onDestroyView() {
        fragmentInteractionListener.updateActionBarTitle("NUTRITION");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        SharedPreferencesUtil.pushStringList(mSharedPref, mArrayListGroceryList, "key");
        super.onDestroy();
    }
}
