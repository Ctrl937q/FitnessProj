package com.example.tituh.fitnessproj.adapters;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.fragments.nutrition.SharedPreferencesUtil;
import java.util.ArrayList;

public class NutritionGroceryListVerticalAdapter extends RecyclerView.Adapter<NutritionGroceryListVerticalAdapter.ViewHolder> {

    private ArrayList<String> mArrayListTitle;
    private SharedPreferences mSharedPref;

    public NutritionGroceryListVerticalAdapter(ArrayList<String> mArrayListTitle, SharedPreferences sharedPref) {
        this.mArrayListTitle = mArrayListTitle;
        this.mSharedPref = sharedPref;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nutrition_grocery_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.mTextView.setText("" + mArrayListTitle.get(i));
        viewHolder.mImageViewDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mArrayListTitle.remove(i);
                notifyDataSetChanged();
                SharedPreferencesUtil.pushStringList(mSharedPref, mArrayListTitle, "key");
                }
        });

    }

    @Override
    public int getItemCount() {
        if (mArrayListTitle != null) {
            return mArrayListTitle.size();
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;
        private ImageView mImageViewDeleteItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.text_view_week_workout_week);
            mImageViewDeleteItem = itemView.findViewById(R.id.image_view_delete_item_grocery_list);
        }
    }
}
