package com.example.tituh.fitnessproj.ui.fragments.nutrition;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.RecipesHorizontalRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecipesVerticalRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.helpers.SpacesItemDecoration;
import com.example.tituh.fitnessproj.networking.ApiClient;
import com.example.tituh.fitnessproj.networking.responses.OnGetRecipesResponseListener;
import com.example.tituh.fitnessproj.networking.responses.recipes.ResultsItem;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import java.util.ArrayList;
import java.util.List;

public class RecipesFragment extends BaseFragment {

    private RecyclerView mHorizontalRecyclerView;
    private RecyclerView mVerticalRecyclerView;
    private ArrayList<String> mArrayListRecipesCategory;
    private ArrayList<ResultsItem> mResultsItemArrayListResponse;
    private ArrayList<ResultsItem> mResultsItemArrayListResponseFilter;
    private RecipesVerticalRecyclerViewAdapter recipesVerticalRecyclerViewAdapter;
    private Button buttonRetry;
    private CoordinatorLayout coordinatorLayout;
    private ApiClient apiClient;
    private GridLayoutManager mGridLayoutManager;
    private LinearLayoutManager mLayoutManager;
    private ProgressBar progressBar;
    private boolean mBreakfastClick = false;
    private boolean mSweets = false;
    private boolean mOntheGo = false;
    private boolean mNourish = false;
    private boolean mSkinnyDrinks = false;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.recipes_fragment, container, false);
            initialize();

            tryResponse();

            buttonRetry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    buttonResponse();
                }
            });

            mHorizontalRecyclerView.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                    mHorizontalRecyclerView, new RecyclerTouchListenerStart.ClickListener() {
                @Override
                public void onClick(View view, final int position) {
                    progressBar.setVisibility(View.VISIBLE);
                    filterArray(position);
                    progressBar.setVisibility(View.GONE);

                }

                @Override
                public void onLongClick(View view, int position) {
                }
            }));


            mVerticalRecyclerView.addOnItemTouchListener(new RecyclerTouchListenerStart(getActivity(),
                    mVerticalRecyclerView, new RecyclerTouchListenerStart.ClickListener() {
                @Override
                public void onClick(View view, final int position) {
                    if (null != fragmentInteractionListener) {

                        RecipesInfoFragment recipesInfoFragment = new RecipesInfoFragment();
                        Bundle bundle = new Bundle();
                        if (mBreakfastClick || mNourish || mOntheGo || mSweets || mSkinnyDrinks) {
                            bundle.putParcelableArrayList("array_for_recipes_info", mResultsItemArrayListResponseFilter);
                            bundle.putInt("position_for_recipes_info", position);
                        } else {
                            bundle.putParcelableArrayList("array_for_recipes_info", mResultsItemArrayListResponse);
                            bundle.putInt("position_for_recipes_info", position);
                        }
                        recipesInfoFragment.setArguments(bundle);
                        fragmentInteractionListener.pushFragment(recipesInfoFragment, true);
                    }
                }


                @Override
                public void onLongClick(View view, int position) {
                }
            }));
        }
        fragmentInteractionListener.goneIconAbouttActionBar();
        return view;
    }


    @Override
    public void onDestroyView() {
        fragmentInteractionListener.updateActionBarTitle("NUTRITION");
        super.onDestroyView();
    }


    private void initialize() {
        apiClient = new ApiClient();
        fragmentInteractionListener.updateActionBarTitle("RECIPES");
        fragmentInteractionListener.visibleIconBacktActionBar();
        mHorizontalRecyclerView = view.findViewById(R.id.horizontal_recyclerView_recipes);
        mVerticalRecyclerView = view.findViewById(R.id.vertical_recyclerView_recipes);
        coordinatorLayout = view.findViewById(R.id.nestedScrollView);
        buttonRetry = view.findViewById(R.id.btn_retry_recipes);
        progressBar = view.findViewById(R.id.progressBarRecipes);
        mLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);
        mGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mArrayListRecipesCategory = new ArrayList<>();
        mResultsItemArrayListResponse = new ArrayList<>();
        mResultsItemArrayListResponseFilter = new ArrayList<>();

        mArrayListRecipesCategory.add("BREAKFAST");
        mArrayListRecipesCategory.add("SWEETS");
        mArrayListRecipesCategory.add("ON THE GO");
        mArrayListRecipesCategory.add("NOURISH");
        mArrayListRecipesCategory.add("SKINNY DRINKS");

        mHorizontalRecyclerView.setLayoutManager(mLayoutManager);
        mVerticalRecyclerView.setLayoutManager(mGridLayoutManager);

        mVerticalRecyclerView.addItemDecoration(new SpacesItemDecoration(getActivity(), R.dimen.column_spacing));
    }

    private void filterArray(int position) {
        if (position == 0) {
            if (mBreakfastClick) {
                mBreakfastClick = false;
                setAdapter(mResultsItemArrayListResponse);
                return;
            }
            whichPositionClick(true, false, false, false, false);
            mResultsItemArrayListResponseFilter.clear();
            for (int i = 0; i < mResultsItemArrayListResponse.size(); i++) {
                if (mResultsItemArrayListResponse.get(i).getType() == 0) {
                    mResultsItemArrayListResponseFilter.add(mResultsItemArrayListResponse.get(i));
                }
            }
            setAdapter(mResultsItemArrayListResponseFilter);
        }
        if (position == 1) {
            if (mSweets) {
                mSweets = false;
                setAdapter(mResultsItemArrayListResponse);
                return;
            }
            whichPositionClick(false, true, false, false, false);
            mResultsItemArrayListResponseFilter.clear();
            for (int i = 0; i < mResultsItemArrayListResponse.size(); i++) {
                if (mResultsItemArrayListResponse.get(i).getType() == 3) {
                    mResultsItemArrayListResponseFilter.add(mResultsItemArrayListResponse.get(i));
                }
            }
            setAdapter(mResultsItemArrayListResponseFilter);
        }
        if (position == 2) {
            if (mOntheGo) {
                mOntheGo = false;
                setAdapter(mResultsItemArrayListResponse);
                return;
            }
            whichPositionClick(false, false, true, false, false);
            mResultsItemArrayListResponseFilter.clear();
            for (int i = 0; i < mResultsItemArrayListResponse.size(); i++) {
                if (mResultsItemArrayListResponse.get(i).getType() == 5) {
                    mResultsItemArrayListResponseFilter.add(mResultsItemArrayListResponse.get(i));
                }
            }
            setAdapter(mResultsItemArrayListResponseFilter);
        }
        if (position == 3) {
            if (mNourish) {
                mNourish = false;
                setAdapter(mResultsItemArrayListResponse);
                return;
            }
            whichPositionClick(false, false, false, true, false);
            mResultsItemArrayListResponseFilter.clear();
            for (int i = 0; i < mResultsItemArrayListResponse.size(); i++) {
                if (mResultsItemArrayListResponse.get(i).getType() == 6) {
                    mResultsItemArrayListResponseFilter.add(mResultsItemArrayListResponse.get(i));
                }
            }
            setAdapter(mResultsItemArrayListResponseFilter);
        }
        if (position == 4) {
            if (mSkinnyDrinks) {
                mSkinnyDrinks = false;
                setAdapter(mResultsItemArrayListResponse);
                return;
            }
            whichPositionClick(false, false, false, false, true);

            mResultsItemArrayListResponseFilter.clear();
            for (int i = 0; i < mResultsItemArrayListResponse.size(); i++) {
                if (mResultsItemArrayListResponse.get(i).getType() == 7) {
                    mResultsItemArrayListResponseFilter.add(mResultsItemArrayListResponse.get(i));
                }
            }
            setAdapter(mResultsItemArrayListResponseFilter);
        }
    }

    private void whichPositionClick(boolean breakfastClick, boolean sweets,
                                    boolean ontheGo, boolean nourish, boolean skinnyDrinks) {
        mBreakfastClick = breakfastClick;
        mSweets = sweets;
        mOntheGo = ontheGo;
        mNourish = nourish;
        mSkinnyDrinks = skinnyDrinks;
    }

    private void setAdapter(ArrayList<ResultsItem> arrayList) {
        recipesVerticalRecyclerViewAdapter = new RecipesVerticalRecyclerViewAdapter(arrayList);
        mVerticalRecyclerView.setAdapter(recipesVerticalRecyclerViewAdapter);
        recipesVerticalRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void tryResponse() {
        if (fragmentInteractionListener.isInternetConnection()) {
            progressBar.setVisibility(View.VISIBLE);
            apiClient.getRecipes(new OnGetRecipesResponseListener() {
                @Override
                public void onGetRecipesResponse(@Nullable String message, boolean success, @NonNull List<ResultsItem> resultsItems) {
                    mResultsItemArrayListResponse.addAll(resultsItems);
                    recipesVerticalRecyclerViewAdapter = new RecipesVerticalRecyclerViewAdapter(mResultsItemArrayListResponse);
                    mVerticalRecyclerView.setAdapter(recipesVerticalRecyclerViewAdapter);
                    mHorizontalRecyclerView.setAdapter(new RecipesHorizontalRecyclerViewAdapter(mArrayListRecipesCategory));
                    progressBar.setVisibility(View.GONE);
                }
            });
        } else {
            Snackbar snackbarNoIntt = Snackbar.make(coordinatorLayout, "No Internet Connection", Snackbar.LENGTH_LONG);
            snackbarNoIntt.show();
            buttonRetry.setVisibility(View.VISIBLE);

        }
    }

    private void buttonResponse() {
        buttonRetry.setVisibility(View.GONE);
        final Snackbar snackbarNoInt = Snackbar.make(coordinatorLayout, "No Internet Connection", Snackbar.LENGTH_LONG);
        final Snackbar snackbarYesInt = Snackbar.make(coordinatorLayout, "Internet Connection Restored", Snackbar.LENGTH_LONG);
        if (fragmentInteractionListener.isInternetConnection()) {
            snackbarYesInt.show();
            tryResponse();
        } else {
            progressBar.setVisibility(View.VISIBLE);
            new CountDownTimer(2000, 500) {
                @Override
                public void onTick(long l) {
                    if (fragmentInteractionListener.isInternetConnection()) {
                        snackbarYesInt.show();
                        tryResponse();
                    }
                }

                @Override
                public void onFinish() {
                    if (fragmentInteractionListener.isInternetConnection()) {
                        snackbarYesInt.show();
                        tryResponse();
                    } else {
                        snackbarNoInt.show();
                        progressBar.setVisibility(View.GONE);
                        buttonRetry.setVisibility(View.VISIBLE);
                    }
                    cancel();
                }
            }.start();
        }
    }
}
