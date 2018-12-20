package com.example.tituh.fitnessproj.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tituh.fitnessproj.model.FitnessStartModel;
import com.example.tituh.fitnessproj.R;

import java.util.List;

import static com.example.tituh.fitnessproj.model.FitnessStartModel.ONE_TYPE;
import static com.example.tituh.fitnessproj.model.FitnessStartModel.TWO_TYPE;

public class FitnessFragmentStartRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FitnessStartModel> mListFitnessStartModel;

    public FitnessFragmentStartRecyclerViewAdapter(List<FitnessStartModel> list) {
        this.mListFitnessStartModel = list;
    }

    @Override
    public int getItemViewType(int position) {
        FitnessStartModel model = mListFitnessStartModel.get(position);
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
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_fitness_start_item1,
                        parent, false);
                return new OneViewHolder(view);

            case TWO_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_fitness_start_item2,
                        parent, false);
                return new TwoViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {

        FitnessStartModel model = mListFitnessStartModel.get(position);

        switch (model.getType()) {
            case ONE_TYPE:

                ((OneViewHolder) holder).mImageViewItem.setImageResource(model.getDrawableassive()[position]);
                ((OneViewHolder) holder).mTextViewHeadline1.setText(model.getHeadline_1());
                if (position == 1) {
                    //    ((OneViewHolder) holder).mTextViewHeadline1.setText("" + countWeek + model.getHeadline_1());
                }
                ((OneViewHolder) holder).fancyButton.setText(model.getmTextButton());
                break;
            case TWO_TYPE:
                ((TwoViewHolder) holder).mTextViewHeadline3.setText(model.getHeadline_1());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mListFitnessStartModel.size();
    }

    private class OneViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageViewItem;
        private TextView mTextViewHeadline1;
        private Button fancyButton;

        private OneViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageViewItem = itemView.findViewById(R.id.image_view_recycler_view_start);
            mTextViewHeadline1 = itemView.findViewById(R.id.textViewFitnessStartLayout_1);
            fancyButton = itemView.findViewById(R.id.fancy_button_start);
        }

    }


    private class TwoViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageViewLastItemIcon;
        private TextView mTextViewHeadline3;
        private ProgressBar progressBar;

        private TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageViewLastItemIcon = itemView.findViewById(R.id.image_view_fitness_start2);
            mTextViewHeadline3 = itemView.findViewById(R.id.text_view_fitness_start_3);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progress_bar_item_start_rv);
        }
    }

    public void getProgressBar() {

    }
}


