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

//recyclerView_exercise_choose id
public class ExerciseRecyclerViewAdapter extends RecyclerView.Adapter<ExerciseRecyclerViewAdapter.ViewHolder> {

    ArrayList<String>arrayList;

    public ExerciseRecyclerViewAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_choose_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewWarmUpName.setText(arrayList.get(position));
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewExerciseTitle;
        ImageView imageViewExercise;
        TextView textViewWarmUpName;
        TextView textViewTimeExersice1;
        TextView textViewTimeExersice2;
        FancyButton fancyButtonStartWorkout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewExerciseTitle = itemView.findViewById(R.id.text_view_title_exercise);
            imageViewExercise = itemView.findViewById(R.id.imageView_exercise);
            textViewWarmUpName = itemView.findViewById(R.id.warm_up_name);
            textViewTimeExersice1 = itemView.findViewById(R.id.textView_time_exercise_1);
            textViewTimeExersice2 = itemView.findViewById(R.id.textView_time_exercise_2);
            fancyButtonStartWorkout = itemView.findViewById(R.id.button_start_workout);
        }
    }
}
