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
import com.example.tituh.fitnessproj.model.WeekWorkoutModel;
import java.util.List;
import mehdi.sakout.fancybuttons.FancyButton;

public class WeekWorkoutFragmentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private List<WeekWorkoutModel> mItemObjects;

    public WeekWorkoutFragmentRecyclerViewAdapter(List<WeekWorkoutModel> itemObjects) {
        this.mItemObjects = itemObjects;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.week_workout_header, parent, false);
            return new HeaderViewHolder(layoutView);
        } else if (viewType == TYPE_ITEM) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_week_item, parent, false);
            return new ItemViewHolder(layoutView);
        }
        throw new RuntimeException("No match for " + viewType + ".");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        WeekWorkoutModel weekWorkoutModel = mItemObjects.get(position);
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).mHeaderTitle1.setText(weekWorkoutModel.getHeader1());
            ((HeaderViewHolder) holder).mHeaderTitle2.setText(weekWorkoutModel.getHeader2());
            ((HeaderViewHolder)holder).mButton.setText("RESET");
        } else if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).mTextViewWeek.setText(weekWorkoutModel.getHeader1());
        }
    }

    @Override
    public int getItemCount() {
        return mItemObjects.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

     private class HeaderViewHolder extends RecyclerView.ViewHolder {

        private TextView mHeaderTitle1;
        private TextView mHeaderTitle2;
        private FancyButton mButton;

        private HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            mHeaderTitle1 = (TextView) itemView.findViewById(R.id.text_view_quantity_week);
            mHeaderTitle2 = (TextView) itemView.findViewById(R.id.text_view_all_week);
            mButton = (FancyButton) itemView.findViewById(R.id.btn_button_rest_workout);
        }
    }

     private class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewWeek;
        private ImageView mImageViewArrow;
        private ProgressBar progressBar;

        private ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            //mImageViewProgress = (ImageView)itemView.findViewById(R.id.image_view_week_workout_progress);
            mTextViewWeek = (TextView) itemView.findViewById(R.id.text_view_week_workout_week);
            mImageViewArrow = (ImageView)itemView.findViewById(R.id.image_view_week_workout_arrow);
            progressBar = (ProgressBar)itemView.findViewById(R.id.progress_bar_week);
            ProgressBarDrawable bgProgress= new ProgressBarDrawable(6);
            progressBar.setProgressDrawable(bgProgress);
            progressBar.setProgress(40);
        }
    }
}