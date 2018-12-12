package com.example.tituh.fitnessproj.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.networking.responses.recipes.ResultsItem;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class RecipesVerticalRecyclerViewAdapter extends RecyclerView.Adapter<RecipesVerticalRecyclerViewAdapter.ViewHolder> {

    private List<ResultsItem> resultsItemArrayList;

    public RecipesVerticalRecyclerViewAdapter(List<ResultsItem> resultsItems) {
        resultsItemArrayList = new ArrayList<>();
        this.resultsItemArrayList = resultsItems;
    }

    @NonNull
    @Override
    public RecipesVerticalRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_vertical_rv_item,
                parent, false);
        return new RecipesVerticalRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesVerticalRecyclerViewAdapter.ViewHolder viewHolder, int position) {
        viewHolder.button.setText("" + resultsItemArrayList.get(position).getTitle());
        Picasso.get().load("" + resultsItemArrayList.get(position).getImage()).placeholder(R.drawable.placeholder_recipes).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return resultsItemArrayList.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view_recipe_background);
            button = itemView.findViewById(R.id.button_on_recipe);
        }
    }

}
