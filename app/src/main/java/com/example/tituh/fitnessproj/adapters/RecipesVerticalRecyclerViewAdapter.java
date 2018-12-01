package com.example.tituh.fitnessproj.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.model.RecipesModel;
import java.util.ArrayList;

public class RecipesVerticalRecyclerViewAdapter extends RecyclerView.Adapter<RecipesVerticalRecyclerViewAdapter.ViewHolder> {

    private ArrayList<RecipesModel> mArrayListRecipe;

    public RecipesVerticalRecyclerViewAdapter(ArrayList<RecipesModel> arrayListRecipe) {
        this.mArrayListRecipe = arrayListRecipe;
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
        RecipesModel model = mArrayListRecipe.get(position);
        Log.d("asdsa", " " + mArrayListRecipe.get(position));
        viewHolder.button.setText(model.getTitleButton());
    }

    @Override
    public int getItemCount() {
        return mArrayListRecipe.size();
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
