package com.example.tituh.fitnessproj.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.tituh.fitnessproj.R;
import java.util.ArrayList;

public class GlossaryWorkoutsRecyclerViewAdapter extends RecyclerView.Adapter<GlossaryWorkoutsRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mArrayList;

    public GlossaryWorkoutsRecyclerViewAdapter(ArrayList<String> arrayList) {
        this.mArrayList = arrayList;
    }

    @NonNull
    @Override
    public GlossaryWorkoutsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_glossary_item, parent, false);
        return new GlossaryWorkoutsRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GlossaryWorkoutsRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.mTextViewWarmUpNameGlossary.setText(mArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewWarmUpNameGlossary;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewWarmUpNameGlossary = itemView.findViewById(R.id.warm_up_name_glossary);
        }
    }
}
