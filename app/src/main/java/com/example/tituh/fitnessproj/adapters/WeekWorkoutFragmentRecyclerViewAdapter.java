package com.example.tituh.fitnessproj.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tituh.fitnessproj.model.WeekWorkoutModel;
import com.example.tituh.fitnessproj.R;

import java.util.List;

public class WeekWorkoutFragmentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String TAG = WeekWorkoutFragmentRecyclerViewAdapter.class.getSimpleName();
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ITEM = 1;
    private List<WeekWorkoutModel> itemObjects;

    public WeekWorkoutFragmentRecyclerViewAdapter(List<WeekWorkoutModel> itemObjects) {
        this.itemObjects = itemObjects;
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
        WeekWorkoutModel weekWorkoutModel = itemObjects.get(position);
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).headerTitle1.setText(weekWorkoutModel.getHeader_1());
            ((HeaderViewHolder) holder).headerTitle2.setText(weekWorkoutModel.getHeader_2());
        } else if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).textView_week.setText(weekWorkoutModel.getHeader_1());
        }
    }

    @Override
    public int getItemCount() {
        return itemObjects.size();
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

     class HeaderViewHolder extends RecyclerView.ViewHolder {

        public TextView headerTitle1;
        public TextView headerTitle2;
        public Button button;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            headerTitle1 = (TextView) itemView.findViewById(R.id.text_view_quantity_week);
            headerTitle2 = (TextView) itemView.findViewById(R.id.text_view_all_week);
            //button = (Button) itemView.findViewById(R.id.btn_button_rest_workout);
        }
    }

     class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView_progress;
        TextView textView_week;
        ImageView imageView_arrow;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_progress = (ImageView)itemView.findViewById(R.id.image_view_week_workout_progress);
            textView_week = (TextView) itemView.findViewById(R.id.text_view_week_workout_week);
            imageView_arrow = (ImageView)itemView.findViewById(R.id.image_view_week_workout_arrow);
        }
    }
}
