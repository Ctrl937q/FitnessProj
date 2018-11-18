package com.example.tituh.fitnessproj.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NutritionGroceryListVerticalAdapter  extends RecyclerView.Adapter<NutritionGroceryListVerticalAdapter.ViewHolder> {

    ArrayList<String> mArrayListTitle;

    public NutritionGroceryListVerticalAdapter(ArrayList<String> mArrayListTitle) {
        this.mArrayListTitle = mArrayListTitle;
    }

    public void titleChange(ArrayList<String> titleArray) {
        this.mArrayListTitle = titleArray;
    }

    @NonNull
    @Override
    public NutritionGroceryListVerticalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nutrition_grocery_list_item, parent, false);
        return new NutritionGroceryListVerticalAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NutritionGroceryListVerticalAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.mTextView.setText("" + mArrayListTitle.get(i));
        viewHolder.mImageViewDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mArrayListTitle.remove(i);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mArrayListTitle.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;
        ImageView mImageViewDeleteItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.text_view_week_workout_week);
            mImageViewDeleteItem = itemView.findViewById(R.id.image_view_delete_item_grocery_list);


        }
    }
}
