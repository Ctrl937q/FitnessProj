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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.RecipesInfoRecyclerViewAdapterDirections;
import com.example.tituh.fitnessproj.adapters.RecipesInfoRecyclerViewAdapterIngredients;
import com.example.tituh.fitnessproj.helpers.MarginItemDecoration;
import com.example.tituh.fitnessproj.helpers.SquareImageView;
import com.example.tituh.fitnessproj.networking.responses.recipes.ResultsItem;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecipesInfoFragment extends BaseFragment {

    private SharedPreferences mSharedPref;
    private ArrayList<ResultsItem> ingredientsItemArrayList;
    private int mPosition;
    private SquareImageView mSquareImageView;
    private ImageView mNextImageRecipesInfo;
    private ImageView mPreviousImageRecipesInfo;
    private RecipesInfoRecyclerViewAdapterIngredients mRecipesInfoRecyclerViewAdapterIngredients;
    private RecipesInfoRecyclerViewAdapterDirections mRecipesInfoRecyclerViewAdapterDirections;
    private RecyclerView mRecyclerViewIngredients;
    private TextView textViewTitle;
    private RecyclerView mRecyclerViewDirections;
    private Toast toast;
    private Button buttonShop;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.recipes_info_fragment, container, false);
            mSquareImageView = view.findViewById(R.id.square_image_view_recipes_info);
            mNextImageRecipesInfo = view.findViewById(R.id.next_image_recipes_info);
            mPreviousImageRecipesInfo = view.findViewById(R.id.previous_image_recipes_info);
            textViewTitle = view.findViewById(R.id.recipes_info_title);
            mRecyclerViewIngredients = view.findViewById(R.id.recyclerView_recipes_info);
            mRecyclerViewDirections = view.findViewById(R.id.recyclerView_directions);
            buttonShop = view.findViewById(R.id.btn_shop_ingredients);

            buttonShop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fragmentInteractionListener.pushFragment(new GroceryListFragment(), true);
                }
            });

            mNextImageRecipesInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    nextItem();
                }
            });

            mPreviousImageRecipesInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    previousItem();
                }
            });

            mSharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
            Bundle bundle = this.getArguments();
            ingredientsItemArrayList = new ArrayList<>();
            ingredientsItemArrayList = bundle.getParcelableArrayList("array_for_recipes_info");
            mPosition = bundle.getInt("position_for_recipes_info");

            Picasso.get()
                    .load(ingredientsItemArrayList.get(mPosition).getImage())
                    .placeholder(R.drawable.wine_placeholder)
                    .into(mSquareImageView);

            textViewTitle.setText("" + ingredientsItemArrayList.get(mPosition).getTitle());

            mRecyclerViewIngredients.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecipesInfoRecyclerViewAdapterIngredients = new RecipesInfoRecyclerViewAdapterIngredients(ingredientsItemArrayList
                    .get(mPosition).getIngredients(), mSharedPref);

            mRecipesInfoRecyclerViewAdapterDirections = new RecipesInfoRecyclerViewAdapterDirections(ingredientsItemArrayList
                    .get(mPosition).getDirections());

            mRecyclerViewIngredients.setAdapter(mRecipesInfoRecyclerViewAdapterIngredients);
            mRecyclerViewIngredients.addItemDecoration(new MarginItemDecoration(1, 20, 20, 0, 0));

            mRecyclerViewDirections.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerViewDirections.setAdapter(mRecipesInfoRecyclerViewAdapterDirections);
        }
        return view;
    }

    public void nextItem() {
        mPosition++;
        if (mPosition >= ingredientsItemArrayList.size()) {
            if (toast != null) toast.cancel();
            toast = Toast.makeText(getActivity(),
                    "no more item",
                    Toast.LENGTH_SHORT);
            toast.show();
            mPosition = ingredientsItemArrayList.size() - 1;
        } else {
            Picasso.get()
                    .load(ingredientsItemArrayList.get(mPosition).getImage())
                    .placeholder(R.drawable.wine_placeholder)
                    .into(mSquareImageView);
            textViewTitle.setText("" + ingredientsItemArrayList.get(mPosition).getTitle());

            mRecipesInfoRecyclerViewAdapterIngredients = new RecipesInfoRecyclerViewAdapterIngredients(ingredientsItemArrayList
                    .get(mPosition).getIngredients(), mSharedPref);
            mRecyclerViewIngredients.setAdapter(mRecipesInfoRecyclerViewAdapterIngredients);
            mRecipesInfoRecyclerViewAdapterIngredients.notifyDataSetChanged();

            mRecipesInfoRecyclerViewAdapterDirections = new RecipesInfoRecyclerViewAdapterDirections(ingredientsItemArrayList
                    .get(mPosition).getDirections());
            mRecyclerViewDirections.setAdapter(mRecipesInfoRecyclerViewAdapterDirections);
            mRecipesInfoRecyclerViewAdapterDirections.notifyDataSetChanged();

        }
    }

    public void previousItem() {
        mPosition--;
        if (mPosition < 0) {
            if (toast != null) toast.cancel();
            toast = Toast.makeText(getActivity(),
                    "no more item",
                    Toast.LENGTH_SHORT);
            toast.show();
            mPosition = 0;
        } else {
            Picasso.get()
                    .load(ingredientsItemArrayList.get(mPosition).getImage())
                    .placeholder(R.drawable.placeholder_recipes)
                    .into(mSquareImageView);
            textViewTitle.setText("" + ingredientsItemArrayList.get(mPosition).getTitle());
            mRecipesInfoRecyclerViewAdapterIngredients = new RecipesInfoRecyclerViewAdapterIngredients(ingredientsItemArrayList
                    .get(mPosition).getIngredients(), mSharedPref);
            mRecyclerViewIngredients.setAdapter(mRecipesInfoRecyclerViewAdapterIngredients);
            mRecipesInfoRecyclerViewAdapterIngredients.notifyDataSetChanged();

            mRecipesInfoRecyclerViewAdapterDirections = new RecipesInfoRecyclerViewAdapterDirections(ingredientsItemArrayList
                    .get(mPosition).getDirections());
            mRecyclerViewDirections.setAdapter(mRecipesInfoRecyclerViewAdapterDirections);
            mRecipesInfoRecyclerViewAdapterDirections.notifyDataSetChanged();
        }
    }
}
