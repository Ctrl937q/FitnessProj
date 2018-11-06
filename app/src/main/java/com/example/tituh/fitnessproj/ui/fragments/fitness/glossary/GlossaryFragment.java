package com.example.tituh.fitnessproj.ui.fragments.fitness.glossary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

public class GlossaryFragment extends BaseFragment {

    CardView mCardViewWarmUp;
    CardView mCardViewWorkouts;
    CardView mCardViewStretching;

    ImageView mImageViewStretching;
    ImageView mImageViewWarmUp;
    ImageView mImageViewWorkouts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.glossary_fragment, container, false);

        mCardViewWarmUp = (CardView) rootView.findViewById(R.id.card_view_warm_up);
        mCardViewWorkouts = (CardView) rootView.findViewById(R.id.card_view_workouts);
        mCardViewStretching = (CardView) rootView.findViewById(R.id.card_view_stretching);
        mImageViewStretching = (ImageView)rootView.findViewById(R.id.image_view_stretching);
        mImageViewWarmUp = (ImageView)rootView.findViewById(R.id.image_view_warm_up);
        mImageViewWorkouts = (ImageView)rootView.findViewById(R.id.image_view_workouts);

        ((MainActivity)getActivity()).updateActionBarTitle("GLOSSARY");
        ((MainActivity)getActivity()).goneIconAbouttActionBar();
        ((MainActivity)getActivity()).visibleIconBacktActionBar();

        mCardViewWarmUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickWarmUp();
            }
        });

        mCardViewWorkouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickWorkouts();
            }
        });

        mCardViewStretching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickStretching();
            }
        });

        return rootView;

    }

    public void onClickWarmUp() {

        ((MainActivity)getActivity()).pushFragmentGlossary(new GlossaryWarmUpFragment(),
                false);

        mImageViewWarmUp.setImageDrawable(getResources().
                getDrawable(R.drawable.warm_up_black_vector));
        mImageViewStretching.setImageDrawable(getResources().
                getDrawable(R.drawable.stretching_pink_vector));
        mImageViewWorkouts.setImageDrawable(getResources().
                getDrawable(R.drawable.workouts_pink_vector));

        mCardViewWarmUp.setCardBackgroundColor(getResources()
                .getColor(R.color.color_wite_for_dialog));
        mCardViewWorkouts.setCardBackgroundColor(getResources()
                .getColor(R.color.color_background_card_view_gloccary));
        mCardViewStretching.setCardBackgroundColor(getResources()
                .getColor(R.color.color_background_card_view_gloccary));
    }

    public void onClickWorkouts() {

        ((MainActivity)getActivity()).pushFragmentGlossary(new RecyclerViewGlossaryWorkoutFragment(),
                false);

        mImageViewWarmUp.setImageDrawable(getResources().
                getDrawable(R.drawable.warm_up_pink_vector));
        mImageViewStretching.setImageDrawable(getResources().
                getDrawable(R.drawable.stretching_pink_vector));
        mImageViewWorkouts.setImageDrawable(getResources().
                getDrawable(R.drawable.workouts_black_vector));

        mCardViewWorkouts.setCardBackgroundColor(getResources()
                .getColor(R.color.color_wite_for_dialog));
        mCardViewWarmUp.setCardBackgroundColor(getResources()
                .getColor(R.color.color_background_card_view_gloccary));
        mCardViewStretching.setCardBackgroundColor(getResources()
                .getColor(R.color.color_background_card_view_gloccary));
    }

    public void onClickStretching() {

        ((MainActivity)getActivity()).pushFragmentGlossary(new GlossaryStretchingFragment(),
                false);

        mImageViewWarmUp.setImageDrawable(getResources().
                getDrawable(R.drawable.warm_up_pink_vector));
        mImageViewStretching.setImageDrawable(getResources().
                getDrawable(R.drawable.stretching_black_vector));
        mImageViewWorkouts.setImageDrawable(getResources().
                getDrawable(R.drawable.workouts_pink_vector));

        mCardViewWorkouts.setCardBackgroundColor(getResources()
                .getColor(R.color.color_background_card_view_gloccary));
        mCardViewWarmUp.setCardBackgroundColor(getResources()
                .getColor(R.color.color_background_card_view_gloccary));
        mCardViewStretching.setCardBackgroundColor(getResources()
                .getColor(R.color.color_wite_for_dialog));
    }
}
