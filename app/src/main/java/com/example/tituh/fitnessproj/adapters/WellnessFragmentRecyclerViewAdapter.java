package com.example.tituh.fitnessproj.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.model.WellnessModel;
import java.util.List;
import mehdi.sakout.fancybuttons.FancyButton;

import static com.example.tituh.fitnessproj.model.WellnessModel.ONE_TYPE;
import static com.example.tituh.fitnessproj.model.WellnessModel.TWO_TYPE;


public class WellnessFragmentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<WellnessModel> mList;

    public WellnessFragmentRecyclerViewAdapter(List<WellnessModel> list) {
        this.mList = list;
    }

    @Override
    public int getItemViewType(int position) {
        WellnessModel model = mList.get(position);
        if (model != null) {
            return model.getType();
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case ONE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wellness_recycler_view_item1,
                        parent, false);
                return new OneViewHolder(view);
            case TWO_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wellness_recycler_view_item2,
                        parent, false);
                return new TwoViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {

        WellnessModel model = mList.get(position);

        switch (model.getType()) {
            case ONE_TYPE:
                ((OneViewHolder) holder).mTextViewHeadline1.setText(model.getmTitleText());
                ((OneViewHolder) holder).fancyButton.setText(model.getmButtonText());
                break;
            case TWO_TYPE:
                ((TwoViewHolder) holder).mImageView.setImageResource(model.getDrawableMassive());
                ((TwoViewHolder) holder).mTextViewHeadline3.setText(model.getmTitleText());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    private class OneViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewHeadline1;
        private Button fancyButton;

        private OneViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewHeadline1 = itemView.findViewById(R.id.text_view_daily_habits);
            fancyButton = itemView.findViewById(R.id.fancy_button_wellness_about_daily_habits);
        }
    }

    private class TwoViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewHeadline3;
        private ImageView mImageView;

        private TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view_wellness_protein);
            mTextViewHeadline3 = itemView.findViewById(R.id.text_view_wellness_protein);
        }
    }
}
