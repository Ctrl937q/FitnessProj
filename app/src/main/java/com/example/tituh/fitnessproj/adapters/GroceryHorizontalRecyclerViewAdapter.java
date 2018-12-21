package com.example.tituh.fitnessproj.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.tituh.fitnessproj.R;
import java.util.ArrayList;

public class GroceryHorizontalRecyclerViewAdapter extends RecyclerView.Adapter<GroceryHorizontalRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mListHorizontal;

    public GroceryHorizontalRecyclerViewAdapter(ArrayList<String> list){
        this.mListHorizontal = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grocery_horizontal_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTextViewHorizontalRecyclerView.setText(mListHorizontal.get(position));
    }


    @Override
    public int getItemCount() {
        return mListHorizontal.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewHorizontalRecyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewHorizontalRecyclerView = itemView.findViewById(R.id.textViewHorizontalRv);
        }
    }
}


