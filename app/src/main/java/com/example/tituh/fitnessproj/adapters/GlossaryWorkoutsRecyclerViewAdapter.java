package com.example.tituh.fitnessproj.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.networking.responses.training.WorkoutsItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GlossaryWorkoutsRecyclerViewAdapter extends RecyclerView.Adapter<GlossaryWorkoutsRecyclerViewAdapter.ViewHolder> {

    private List <WorkoutsItem> mList;
    private Context context;

    public GlossaryWorkoutsRecyclerViewAdapter(List<WorkoutsItem>mList, Context context) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public GlossaryWorkoutsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_glossary_item, parent, false);
        return new GlossaryWorkoutsRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GlossaryWorkoutsRecyclerViewAdapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load(mList.get(position).getImage())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.placeholder_recipes))
                .into(holder.imageViewGlossary);

        //Picasso.get().load(mList.get(position).getImage()).placeholder(R.drawable.placeholder_recipes);
        holder.mTextViewWarmUpNameGlossary.setText(mList.get(position).getTitle());
        holder.mTextViewWarmUpDurationGlossary.setText("" + mList.get(position).getDuration());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewWarmUpNameGlossary;
        private TextView mTextViewWarmUpDurationGlossary;
        private ImageView imageViewGlossary;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewWarmUpNameGlossary = itemView.findViewById(R.id.warm_up_name_glossary);
            mTextViewWarmUpDurationGlossary = itemView.findViewById(R.id.textView_time_exercise_2_glossary);
            imageViewGlossary = itemView.findViewById(R.id.imageView_glossary);
        }
    }
}
