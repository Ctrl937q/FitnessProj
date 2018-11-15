package com.example.tituh.fitnessproj.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.model.ChooseLevelModel;

import java.util.ArrayList;

public class ChooseLevelRecyclerViewAdapter extends RecyclerView.Adapter<ChooseLevelRecyclerViewAdapter.ViewHolder> {

    private ArrayList<ChooseLevelModel> mArrayListChooseLevelodel;

    public ChooseLevelRecyclerViewAdapter(ArrayList<ChooseLevelModel> mArrayListChooseLevelodel) {
        this.mArrayListChooseLevelodel = mArrayListChooseLevelodel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fitness_choose_level_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChooseLevelModel model = mArrayListChooseLevelodel.get(position);
        holder.mImageViewLevel.setImageResource(model.getImageInt());
        holder.mTextViewTitle.setText("" + model.getTitle());
        if(position == 0){
            holder.mImageViewStar2.setVisibility(View.GONE);
            holder.mImageViewStar3.setVisibility(View.GONE);
        }
        if(position == 1){
            holder.mImageViewStar3.setVisibility(View.GONE);
        }
    }


    @Override
    public int getItemCount() {
        return mArrayListChooseLevelodel.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageViewLevel;
        TextView mTextViewTitle;
        ImageView mImageViewStar1;
        ImageView mImageViewStar2;
        ImageView mImageViewStar3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageViewLevel = itemView.findViewById(R.id.image_view_level_choose_medal);
            mTextViewTitle = itemView.findViewById(R.id.text_view_level_choose_title);
            mImageViewStar1 = itemView.findViewById(R.id.image_view_level_choose_star1);
            mImageViewStar2 = itemView.findViewById(R.id.image_view_level_choose_star2);
            mImageViewStar3 = itemView.findViewById(R.id.image_view_level_choose_star3);
        }
    }
}
