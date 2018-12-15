package com.example.tituh.fitnessproj.adapters;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tituh.fitnessproj.R;

import java.util.ArrayList;

public class RecipesHorizontalRecyclerViewAdapter extends RecyclerView.Adapter<RecipesHorizontalRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mListHorizontal;

    public RecipesHorizontalRecyclerViewAdapter(ArrayList<String> mListHorizontal) {
        this.mListHorizontal = mListHorizontal;
    }

    @NonNull
    @Override
    public RecipesHorizontalRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipes_horizontal_item,
                parent, false);
        return new RecipesHorizontalRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecipesHorizontalRecyclerViewAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.button.setText("" + mListHorizontal.get(i));
    }

    @Override
    public int getItemCount() {
        return mListHorizontal.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder  {

        //private TextView mTextViewHorizontalRecyclerView;
        private Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //mTextViewHorizontalRecyclerView = itemView.findViewById(R.id.textViewHorizontalRv_recipes);
            button = itemView.findViewById(R.id.card_view_horizontal_recycler_view_recipes);
        }


    }
}
