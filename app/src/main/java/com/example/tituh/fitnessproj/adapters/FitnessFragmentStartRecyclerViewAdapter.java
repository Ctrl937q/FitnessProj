package com.example.tituh.fitnessproj.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tituh.fitnessproj.model.FitnessStartModel;
import com.example.tituh.fitnessproj.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.tituh.fitnessproj.model.FitnessStartModel.ONE_TYPE;
import static com.example.tituh.fitnessproj.model.FitnessStartModel.TWO_TYPE;

public class FitnessFragmentStartRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    List<FitnessStartModel> list;

    public FitnessFragmentStartRecyclerViewAdapter(List<FitnessStartModel> list){
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        FitnessStartModel model = list.get(position);
        if(model != null){
            return model.getType();
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case ONE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_fitness_start_layout, parent,false);
                return new OneViewHolder(view);
            case TWO_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_fitness_start_layout2, parent,false);
                return new TwoViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {

        FitnessStartModel model = list.get(position);

        switch (model.getType()){
            case ONE_TYPE:
            if(position == 0){
                Picasso.get().load(R.drawable.prepare_image).into(((OneViewHolder)holder).imageViewFirstItem);
                ((OneViewHolder)holder).headline1.setText(model.getHeadline_1());
                ((OneViewHolder)holder).headline2.setText(model.getHeadline_2());
            }if(position == 1){
                Picasso.get().load(R.drawable.week_workout_image).into(((OneViewHolder)holder).imageViewFirstItem);
                ((OneViewHolder)holder).headline1.setText(model.getHeadline_1());
                ((OneViewHolder)holder).headline2.setText(model.getHeadline_2());
            }
                break;
            case TWO_TYPE:
                ((TwoViewHolder)holder).headline3.setText(model.getHeadline_1());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class OneViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewFirstItem;
        TextView headline1;
        TextView headline2;

        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewFirstItem = itemView.findViewById(R.id.image_view_recycler_view_start);
            headline1 = itemView.findViewById(R.id.textViewFitnessStartLayout_1);
            headline2 = itemView.findViewById(R.id.textViewFitnessStartLayout_2);
        }
    }

    class TwoViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView headline3;

        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view_fitness_start2);
            headline3 = itemView.findViewById(R.id.text_view_fitness_start_3);
        }
    }
}


