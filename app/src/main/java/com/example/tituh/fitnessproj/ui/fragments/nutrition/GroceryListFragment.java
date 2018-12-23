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

            mArrayListCategory.add("Fruits and veggies");
            mArrayListCategory.add("Nuts,sweet and snuck");
            mArrayListCategory.add("Proteins");


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
                            mArrayListHorRecyclerView = new ArrayList<>();
                            mArrayListHorRecyclerView.add("Apple");
                            mArrayListHorRecyclerView.add("Cheese");
                            mArrayListHorRecyclerView.add("Chips");
                            mArrayListGroceryList.addAll(mArrayListHorRecyclerView);
                            Collections.sort(mArrayListGroceryList, String.CASE_INSENSITIVE_ORDER);
                            mAdapter.notifyDataSetChanged();
                            SharedPreferencesUtil.pushStringList(mSharedPref, mArrayListGroceryList, "key");
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

}
