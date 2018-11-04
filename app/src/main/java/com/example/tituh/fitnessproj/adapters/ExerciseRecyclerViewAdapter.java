package com.example.tituh.fitnessproj.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.tituh.fitnessproj.R;
import java.util.ArrayList;
import mehdi.sakout.fancybuttons.FancyButton;

public class ExerciseRecyclerViewAdapter extends RecyclerView.Adapter<ExerciseRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mArrayList;

    public ExerciseRecyclerViewAdapter(ArrayList<String> arrayList) {
        this.mArrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_choose_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTextViewWarmUpName.setText(mArrayList.get(position));
    }


    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextViewExerciseTitle;
        ImageView mImageViewExercise;
        TextView mTextViewWarmUpName;
        TextView mTextViewTimeExersice1;
        TextView mTextViewTimeExersice2;
        FancyButton mFancyButtonStartWorkout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewExerciseTitle = itemView.findViewById(R.id.text_view_title_exercise);
            mImageViewExercise = itemView.findViewById(R.id.imageView_exercise);
            mTextViewWarmUpName = itemView.findViewById(R.id.warm_up_name);
            mTextViewTimeExersice1 = itemView.findViewById(R.id.textView_time_exercise_1);
            mTextViewTimeExersice2 = itemView.findViewById(R.id.textView_time_exercise_2);
            mFancyButtonStartWorkout = itemView.findViewById(R.id.button_start_workout);
        }
    }
}
