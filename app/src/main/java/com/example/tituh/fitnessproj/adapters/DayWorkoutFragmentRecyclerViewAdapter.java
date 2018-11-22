package com.example.tituh.fitnessproj.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.model.DayWorkoutModel;

import java.util.List;

import mehdi.sakout.fancybuttons.FancyButton;

public class DayWorkoutFragmentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private List<DayWorkoutModel> mItemObjects;

    public DayWorkoutFragmentRecyclerViewAdapter(List<DayWorkoutModel> mItemObjects) {
        this.mItemObjects = mItemObjects;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_workout_header, parent, false);
            return new DayWorkoutFragmentRecyclerViewAdapter.HeaderViewHolder(layoutView);
        } else if (viewType == TYPE_ITEM) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_day_item, parent, false);
            return new DayWorkoutFragmentRecyclerViewAdapter.ItemViewHolder(layoutView);
        }
        throw new RuntimeException("No match for " + viewType + ".");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DayWorkoutModel dayWorkoutModel = mItemObjects.get(position);
        if (holder instanceof DayWorkoutFragmentRecyclerViewAdapter.HeaderViewHolder) {
            ((DayWorkoutFragmentRecyclerViewAdapter.HeaderViewHolder) holder).mHeaderTitle1.setText(dayWorkoutModel.getmHeader1());
            ((DayWorkoutFragmentRecyclerViewAdapter.HeaderViewHolder) holder).mHeaderTitle2.setText(dayWorkoutModel.getmHeader2());
            ((DayWorkoutFragmentRecyclerViewAdapter.HeaderViewHolder)holder).mButton.setText("RESET");
        } else if (holder instanceof DayWorkoutFragmentRecyclerViewAdapter.ItemViewHolder) {
            ((DayWorkoutFragmentRecyclerViewAdapter.ItemViewHolder) holder).mTextViewDay.setText(dayWorkoutModel.getmHeader1());
            ((DayWorkoutFragmentRecyclerViewAdapter.ItemViewHolder) holder).mTextViewExercise.setText(dayWorkoutModel.getmHeader2());
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
            mHeaderTitle1 = (TextView) itemView.findViewById(R.id.text_view_quantity_day);
            mHeaderTitle2 = (TextView) itemView.findViewById(R.id.text_view_all_day);
            mButton = (FancyButton) itemView.findViewById(R.id.btn_button_rest_day);
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageViewProgress;
        TextView mTextViewDay;
        TextView mTextViewExercise;
        ImageView mImageViewArrow;

        private ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageViewProgress = (ImageView)itemView.findViewById(R.id.image_view_day_workout_progress);
            mTextViewDay = (TextView) itemView.findViewById(R.id.text_view_day_workout);
            mTextViewExercise = (TextView) itemView.findViewById(R.id.text_view_what_exersice);
            mImageViewArrow = (ImageView)itemView.findViewById(R.id.image_view_day_workout_arrow);
        }
    }
}
