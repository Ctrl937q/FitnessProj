package com.example.tituh.fitnessproj.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.helpers.ProgressBarDrawable;
import com.example.tituh.fitnessproj.model.ChooseLevelModel;

import java.util.ArrayList;

public class ChooseLevelRecyclerViewAdapter extends RecyclerView.Adapter<ChooseLevelRecyclerViewAdapter.ViewHolder> {

    private ArrayList<ChooseLevelModel> mArrayListChooseLevelModel;

    public ChooseLevelRecyclerViewAdapter(ArrayList<ChooseLevelModel> mArrayListChooseLevelodel) {
        this.mArrayListChooseLevelModel = mArrayListChooseLevelodel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fitness_choose_level_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChooseLevelModel model = mArrayListChooseLevelModel.get(position);
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
        return mArrayListChooseLevelModel.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageViewLevel;
        TextView mTextViewTitle;
        ImageView mImageViewStar1;
        ImageView mImageViewStar2;
        ImageView mImageViewStar3;
        ProgressBar progressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageViewLevel = itemView.findViewById(R.id.image_view_level_choose_medal);
            mTextViewTitle = itemView.findViewById(R.id.text_view_level_choose_title);
            mImageViewStar1 = itemView.findViewById(R.id.image_view_level_choose_star1);
            mImageViewStar2 = itemView.findViewById(R.id.image_view_level_choose_star2);
            mImageViewStar3 = itemView.findViewById(R.id.image_view_level_choose_star3);
            progressBar = itemView.findViewById(R.id.progress_bar_level_choose_item);
            ProgressBarDrawable bgProgress= new ProgressBarDrawable(6);
            progressBar.setProgressDrawable(bgProgress);
            progressBar.setProgress(20);
        }
    }
}
