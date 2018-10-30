package com.example.tituh.fitnessproj.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tituh.fitnessproj.Model.FitnessStartModel;
import com.example.tituh.fitnessproj.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.tituh.fitnessproj.Model.FitnessStartModel.ONE_TYPE;
import static com.example.tituh.fitnessproj.Model.FitnessStartModel.TWO_TYPE;

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
                Picasso.get().load(R.drawable.prepare_image).into(((OneViewHolder)holder).imageView_first_item);
                ((OneViewHolder)holder).headline_1.setText(model.getHeadline_1());
                ((OneViewHolder)holder).headline_2.setText(model.getHeadline_2());
            }if(position == 1){
                Picasso.get().load(R.drawable.week_workout_image).into(((OneViewHolder)holder).imageView_first_item);
                ((OneViewHolder)holder).headline_1.setText(model.getHeadline_1());
                ((OneViewHolder)holder).headline_2.setText(model.getHeadline_2());
            }

                break;
            case TWO_TYPE:
                ((TwoViewHolder)holder).headline_3.setText(model.getHeadline_1());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class OneViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView_first_item;
        TextView headline_1;
        TextView headline_2;


        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_first_item = itemView.findViewById(R.id.image_view_recycler_view_start);
            headline_1 = itemView.findViewById(R.id.textViewFitnessStartLayout_1);
            headline_2 = itemView.findViewById(R.id.textViewFitnessStartLayout_2);
        }
    }

    class TwoViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView headline_3;

        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view_fitness_start2);
            headline_3 = itemView.findViewById(R.id.text_view_fitness_start_3);
        }
    }
}


