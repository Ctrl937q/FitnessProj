package com.example.tituh.fitnessproj.ui.fragments.nutrition;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.RecipesHorizontalRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecipesVerticalRecyclerViewAdapter;
import com.example.tituh.fitnessproj.adapters.RecyclerTouchListenerStart;
import com.example.tituh.fitnessproj.helpers.SpacesItemDecoration;
import com.example.tituh.fitnessproj.networking.ApiClient;
import com.example.tituh.fitnessproj.networking.responses.OnGetRecipesResponseListener;
import com.example.tituh.fitnessproj.networking.responses.recipes.RecipesResponse;
import com.example.tituh.fitnessproj.networking.responses.recipes.ResultsItem;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import java.util.ArrayList;
import java.util.List;

public class RecipesFragment extends BaseFragment {

    private RecyclerView mHorizontalRecyclerView;
    private RecyclerView mVerticalRecyclerView;
    private ArrayList<String> mArrayListRecipesCategory;
    private ArrayList<ResultsItem> mResultsItemArrayListResponse;
    private RecipesVerticalRecyclerViewAdapter recipesVerticalRecyclerViewAdapter;
    private int mPastVisiblesItems;
    private int mVisibleItemCount;
    private int mTotalItemCount;
    private NestedScrollView mNestedScrollView;
    private ApiClient apiClient;
    private GridLayoutManager mGridLayoutManager;
    private LinearLayoutManager mLayoutManager;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.recipes_fragment, container, false);

            initialize();


            apiClient.getRecipes(new OnGetRecipesResponseListener() {
                @Override
                public void onGetRecipesResponse(@Nullable String message, boolean success, @Nullable RecipesResponse recipesResponse) {
                    mResultsItemArrayListResponse.addAll(recipesResponse.getResults());
                    recipesVerticalRecyclerViewAdapter = new RecipesVerticalRecyclerViewAdapter(mResultsItemArrayListResponse);
                    mVerticalRecyclerView.setAdapter(recipesVerticalRecyclerViewAdapter);
                    progressBar.setVisibility(View.GONE);
                }
            });

            mNestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                @Override
                public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    if (v.getChildAt(v.getChildCount() - 1) != null) {
                        if ((scrollY + 1500 >= (v.getChildAt(v.getChildCount() - 1).getMeasuredHeight() - v.getMeasuredHeight())) &&
                                scrollY > oldScrollY) {
                            mVisibleItemCount = mGridLayoutManager.getChildCount();
                            mTotalItemCount = mGridLayoutManager.getItemCount();
                            mPastVisiblesItems = mGridLayoutManager.findFirstVisibleItemPosition();
                            if ((mVisibleItemCount + mPastVisiblesItems) >= mTotalItemCount) {
                                apiClient.nextPage();
                                apiClient.getRecipes(new OnGetRecipesResponseListener() {
                                    @Override
                                    public void onGetRecipesResponse(@Nullable String message, boolean success,
                                                                     @Nullable RecipesResponse recipesResponse) {
                                        Toast.makeText(getActivity(), "loading more", Toast.LENGTH_SHORT).show();
                                        mResultsItemArrayListResponse.addAll(recipesResponse.getResults());
                                        recipesVerticalRecyclerViewAdapter.notifyDataSetChanged();
                                    }
                                });
                            }
                        }
                    }
                }
            });


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
                        RecipesInfoFragment recipesInfoFragment = new RecipesInfoFragment();
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("array_for_recipes_info", mResultsItemArrayListResponse);
                        bundle.putInt("position_for_recipes_info", position);
                        recipesInfoFragment.setArguments(bundle);
                        fragmentInteractionListener.pushFragment(recipesInfoFragment, true);
                    }
                }


                @Override
                public void onLongClick(View view, int position) {
                }
            }));
        }
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
        mNestedScrollView = view.findViewById(R.id.nestedScrollView);
        progressBar = view.findViewById(R.id.progressBarRecipes);
        mLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);
        mGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mArrayListRecipesCategory = new ArrayList<>();
        mResultsItemArrayListResponse = new ArrayList<>();

        mArrayListRecipesCategory.add("Breakfast");
        mArrayListRecipesCategory.add("Mains");
        mArrayListRecipesCategory.add("Snacks");
        mArrayListRecipesCategory.add("Sweets");
        mArrayListRecipesCategory.add("Booze");

        mHorizontalRecyclerView.setLayoutManager(mLayoutManager);
        mVerticalRecyclerView.setLayoutManager(mGridLayoutManager);
        mHorizontalRecyclerView.setAdapter(new RecipesHorizontalRecyclerViewAdapter(mArrayListRecipesCategory));

        mVerticalRecyclerView.addItemDecoration(new SpacesItemDecoration(getActivity(), R.dimen.column_spacing));
    }
}
