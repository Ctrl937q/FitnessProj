package com.example.tituh.fitnessproj.adapters;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.networking.responses.recipes.IngredientsItem;
import com.example.tituh.fitnessproj.ui.fragments.nutrition.SharedPreferencesUtil;

import java.util.ArrayList;

public class RecipesInfoRecyclerViewAdapterIngredients extends RecyclerView.Adapter<RecipesInfoRecyclerViewAdapterIngredients.ViewHolder> {

    private ArrayList<IngredientsItem> ingredientsItemArrayList;
    private SharedPreferences mSharedPref;
    private ArrayList<String> mArrayListFromPreference;

    public RecipesInfoRecyclerViewAdapterIngredients(ArrayList<IngredientsItem> ingredientsItemArrayList, SharedPreferences sharedPref) {
        this.mSharedPref = sharedPref;
        this.ingredientsItemArrayList = ingredientsItemArrayList;
        mArrayListFromPreference = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipes_info_rv_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.mTextViewTitle.setText(ingredientsItemArrayList.get(i).getDosage() + " " + ingredientsItemArrayList.get(i).getTitle());
        viewHolder.imageViewPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mTitleWithoutNumber = ingredientsItemArrayList.get(i).getTitle();
                mTitleWithoutNumber = mTitleWithoutNumber.replaceAll("[^A-Za-z ()]", "");
                mTitleWithoutNumber = mTitleWithoutNumber.replaceFirst("^ *", "");
                mArrayListFromPreference = (ArrayList<String>) SharedPreferencesUtil.pullStringList(mSharedPref, "key");
                mArrayListFromPreference.add(mTitleWithoutNumber);
                SharedPreferencesUtil.pushStringList(mSharedPref, mArrayListFromPreference, "key");
                viewHolder.imageViewPlus.setEnabled(false);
                viewHolder.imageViewPlus.setImageResource(R.drawable.vector_add_grocery_list_empty_small);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ingredientsItemArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewTitle;
        private ImageView imageViewPlus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewTitle = itemView.findViewById(R.id.textView_recipes_info_item_text);
            imageViewPlus = itemView.findViewById(R.id.image_view_add_grocery_list_recipes_info);
        }

    }

}