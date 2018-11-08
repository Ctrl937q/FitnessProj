package com.example.tituh.fitnessproj.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.tituh.fitnessproj.R;
import java.util.ArrayList;

public class WellnessFragmentRecyclerViewAdapter extends RecyclerView.Adapter<WellnessFragmentRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mListString;

    public WellnessFragmentRecyclerViewAdapter(ArrayList<String> list){
        this.mListString = list;
    }

    @NonNull
    @Override
    public WellnessFragmentRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wellness_rv_item,
                parent, false);
        return new WellnessFragmentRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WellnessFragmentRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.mTextViewWellnessItemName.setText(mListString.get(position));
    }

    @Override
    public int getItemCount() {
        return mListString.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextViewWellnessItemName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewWellnessItemName = itemView.findViewById(R.id.text_view_wellness_item_name);
        }
    }
}

