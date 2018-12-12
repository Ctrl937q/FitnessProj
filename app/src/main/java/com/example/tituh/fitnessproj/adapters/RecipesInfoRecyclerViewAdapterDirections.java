package com.example.tituh.fitnessproj.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.networking.responses.recipes.DirectionsItem;

import java.util.ArrayList;

public class RecipesInfoRecyclerViewAdapterDirections extends RecyclerView.Adapter<RecipesInfoRecyclerViewAdapterDirections.ViewHolder> {

    ArrayList<DirectionsItem>directionsItems;

    public RecipesInfoRecyclerViewAdapterDirections(ArrayList<DirectionsItem> directionsItems) {
        this.directionsItems = directionsItems;
    }

    @NonNull
    @Override
    public RecipesInfoRecyclerViewAdapterDirections.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_view_directions,
                parent, false);
        return new RecipesInfoRecyclerViewAdapterDirections.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesInfoRecyclerViewAdapterDirections.ViewHolder viewHolder, int i) {
        viewHolder.mTextViewText.setText("" + directionsItems.get(i).getPosition() + ". " + directionsItems.get(i).getText());
        Log.d("ASDfw32t4", "" + directionsItems.get(i).getPosition() + ". " + directionsItems.get(i).getText());

    }

    @Override
    public int getItemCount() {
        return directionsItems.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewText = itemView.findViewById(R.id.textView_item_recipes_info_directions);
        }

    }

}
