package com.example.tituh.fitnessproj.adapters;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.networking.responses.training.WorkoutsItem;

import java.util.ArrayList;

public class ExerciseRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private ArrayList<WorkoutsItem> resultsItemsCircuitOneThree;
    private ArrayList<WorkoutsItem> resultsItemsCircuitTwoFour;
    private ArrayList<WorkoutsItem> allItems;
    int level;
    int time;

    public ExerciseRecyclerViewAdapter(ArrayList<WorkoutsItem> resultsItemsCircuitOneThree,
                                       ArrayList<WorkoutsItem> resultsItemsCircuitTwoFour, int level) {
        this.resultsItemsCircuitOneThree = resultsItemsCircuitOneThree;
        this.resultsItemsCircuitTwoFour = resultsItemsCircuitTwoFour;
        allItems = new ArrayList<>();
        allItems.addAll(resultsItemsCircuitOneThree);
        allItems.addAll(resultsItemsCircuitTwoFour);
        this.level = level;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_choose_rv_item2, parent, false);
            return new HeaderViewHolder(layoutView);
        } else if (viewType == TYPE_ITEM) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_choose_rv_item1, parent, false);
            return new ItemViewHolder(layoutView);
        }
        throw new RuntimeException("No match for " + viewType + ".");
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ItemViewHolder) {
            if (position > 0 && position <= resultsItemsCircuitOneThree.size()) {
                time = (int)allItems.get(position - 1).getDuration();
                ((ItemViewHolder) holder).textViewWarmUpName.setText(allItems.get(position - 1).getTitle());
                ((ItemViewHolder) holder).textViewTime.setText("" + time);
                if (level == 0) {
                    ((ItemViewHolder) holder).textViewReps.setText("" + allItems.get(position - 1)
                            .getRepetitions().getBeginner() + " #REPS");
                }
                if (level == 1) {
                    ((ItemViewHolder) holder).textViewReps.setText("" + allItems.get(position - 1)
                            .getRepetitions().getIntermediate() + " #REPS");
                }
                if (level == 2) {
                    ((ItemViewHolder) holder).textViewReps.setText("" + allItems.get(position - 1)
                            .getRepetitions().getAdvanced() + " #REPS");
                }

            }
            if (position > resultsItemsCircuitOneThree.size() + 1) {
                time = (int)allItems.get(position - 2).getDuration();
                ((ItemViewHolder) holder).textViewWarmUpName.setText(allItems.get(position - 2).getTitle());
                ((ItemViewHolder) holder).textViewTime.setText("" + time);

                if (level == 0) {
                    ((ItemViewHolder) holder).textViewReps.setText("" + allItems.get(position - 2)
                            .getRepetitions().getBeginner() + " #REPS");
                }
                if (level == 1) {
                    ((ItemViewHolder) holder).textViewReps.setText("" + allItems.get(position - 2)
                            .getRepetitions().getIntermediate() + " #REPS");
                }
                if (level == 2) {
                    ((ItemViewHolder) holder).textViewReps.setText("" + allItems.get(position - 2)
                            .getRepetitions().getAdvanced() + " #REPS");
                }
            }
        }

        if (holder instanceof HeaderViewHolder) {
            if (position == 0) {
                ((HeaderViewHolder) holder).textViewHeader.setText("CIRCUIT #1 & CIRCUIT #3");
            }
            if (position == resultsItemsCircuitOneThree.size() + 1) {
                ((HeaderViewHolder) holder).textViewHeader.setText("CIRCUIT #2 & CIRCUIT #4");

            }
        }
    }


    @Override
    public int getItemCount() {
        return allItems.size() + 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        if (position == 0) {
            return true;
        }
        if (position == resultsItemsCircuitOneThree.size() + 1) {
            return true;
        }
        return false;
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {

        TextView textViewHeader;

        private HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewHeader = (TextView) itemView.findViewById(R.id.text_view_title_exercise);
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewTraining;
        TextView textViewWarmUpName;
        TextView textViewTime;
        TextView textViewReps;
        ImageView imageViewInfo;

        private ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewTraining = (ImageView) itemView.findViewById(R.id.imageView_exercise);
            textViewWarmUpName = (TextView) itemView.findViewById(R.id.warm_up_name_info_training);
            textViewTime = (TextView) itemView.findViewById(R.id.textView_time_exercise_2);
            textViewReps = (TextView) itemView.findViewById(R.id.reps_item);
            imageViewInfo = (ImageView) itemView.findViewById(R.id.image_view_info_training_info);

        }
    }
}
