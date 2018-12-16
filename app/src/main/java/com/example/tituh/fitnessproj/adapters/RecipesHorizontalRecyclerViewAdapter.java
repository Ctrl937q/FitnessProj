package com.example.tituh.fitnessproj.adapters;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;

import java.util.ArrayList;

public class RecipesHorizontalRecyclerViewAdapter extends RecyclerView.Adapter<RecipesHorizontalRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mListHorizontal;
    private int row_index = -1;

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
        viewHolder.mTextViewHorizontalRecyclerView.setText("" + mListHorizontal.get(i));
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index = i;
                notifyDataSetChanged();
            }
        });
        if (row_index == i) {
            viewHolder.cardView.setCardBackgroundColor(Color.parseColor("#FFD6DD"));
        } else {
            viewHolder.cardView.setCardBackgroundColor(Color.parseColor("#ffffff"));
        }

    }

    @Override
    public int getItemCount() {
        return mListHorizontal.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewHorizontalRecyclerView;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewHorizontalRecyclerView = itemView.findViewById(R.id.textViewHorizontalRv);
            cardView = itemView.findViewById(R.id.card_view_horizontal_recycler_view_recipes);
        }
    }
}
