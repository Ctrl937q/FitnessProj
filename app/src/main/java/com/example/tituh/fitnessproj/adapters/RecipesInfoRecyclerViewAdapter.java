package com.example.tituh.fitnessproj.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.fragments.nutrition.SharedPreferencesUtil;

import java.util.ArrayList;

public class RecipesInfoRecyclerViewAdapter extends RecyclerView.Adapter<RecipesInfoRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mListTitle;
    SharedPreferences sharedPref;
    Activity activity;
    ArrayList<String> arrayListFromPreference;


    public RecipesInfoRecyclerViewAdapter(ArrayList<String> mListTitle,SharedPreferences sharedPref, Activity activity) {
        this.sharedPref = sharedPref;
        this.mListTitle = mListTitle;
        this.activity = activity;
        arrayListFromPreference = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecipesInfoRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipes_info_rv_item,
                parent, false);
        return new RecipesInfoRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecipesInfoRecyclerViewAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.mTextViewTitle.setText("" + mListTitle.get(i));
        viewHolder.imageViewPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mTitleWithoutNumber = mListTitle.get(i);
                mTitleWithoutNumber = mTitleWithoutNumber.replaceAll("[^A-Za-z ()]", "");
                mTitleWithoutNumber = mTitleWithoutNumber.replaceFirst("^ *", "");
                arrayListFromPreference = (ArrayList<String>) SharedPreferencesUtil.pullStringList(sharedPref, "key");
                arrayListFromPreference.add(mTitleWithoutNumber);
                SharedPreferencesUtil.pushStringList(sharedPref, arrayListFromPreference, "key");
                viewHolder.imageViewPlus.setEnabled(false);
                viewHolder.imageViewPlus.setImageResource(R.drawable.vector_add_grocery_list_empty_small);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListTitle.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextViewTitle;
        ImageView imageViewPlus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewTitle = itemView.findViewById(R.id.textView_recipes_info_item);
            imageViewPlus = itemView.findViewById(R.id.image_view_add_grocery_list_recipes_info);
        }
    }


}
