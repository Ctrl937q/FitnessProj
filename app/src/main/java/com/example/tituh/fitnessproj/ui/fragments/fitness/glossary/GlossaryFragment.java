package com.example.tituh.fitnessproj.ui.fragments.fitness.glossary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

public class GlossaryFragment extends BaseFragment {

    private CardView mCardViewWarmUp;
    private CardView mCardViewWorkouts;
    private CardView mCardViewStretching;

    private ImageView mImageViewStretching;
    private ImageView mImageViewWarmUp;
    private ImageView mImageViewWorkouts;

    private TextView textViewWarmup;
    private TextView textViewStretching;
    private TextView textViewWorkouts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.glossary_fragment, container, false);
            mCardViewWarmUp = view.findViewById(R.id.card_view_warm_up);
            mCardViewWorkouts = view.findViewById(R.id.card_view_workouts);
            mCardViewStretching = view.findViewById(R.id.card_view_stretching);
            mImageViewStretching = view.findViewById(R.id.image_view_stretching);
            mImageViewWarmUp = view.findViewById(R.id.image_view_warm_up);
            mImageViewWorkouts = view.findViewById(R.id.image_view_workouts);

            textViewWarmup = view.findViewById(R.id.textView_warm_up_glossary);
            textViewStretching = view.findViewById(R.id.textView_stretching_glossary);
            textViewWorkouts = view.findViewById(R.id.textView_workouts_glossary);

            fragmentInteractionListener.updateActionBarTitle("GLOSSARY");
            fragmentInteractionListener.goneIconAbouttActionBar();
            fragmentInteractionListener.visibleIconBacktActionBar();

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

        }

        return view;
    }

    private void onClickWarmUp() {

        fragmentInteractionListener.pushFragmentGlossary(new GlossaryWarmUpFragment(),
                false);

        textViewWarmup.setTextColor(ContextCompat.getColor(getActivity(), R.color.pink_for_button));
        textViewStretching.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_card_view_glossary_1));
        textViewWorkouts.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_card_view_glossary_1));

        mCardViewWarmUp.setCardBackgroundColor(getResources()
                .getColor(R.color.color_card_view_glossary_1));
        mCardViewWorkouts.setCardBackgroundColor(getResources()
                .getColor(R.color.color_background_card_view_gloccary));
        mCardViewStretching.setCardBackgroundColor(getResources()
                .getColor(R.color.color_background_card_view_gloccary));
    }

    private void onClickWorkouts() {

        fragmentInteractionListener.pushFragmentGlossary(new RecyclerViewGlossaryWorkoutFragment(),
                false);

        textViewWarmup.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_card_view_glossary_1));
        textViewStretching.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_card_view_glossary_1));
        textViewWorkouts.setTextColor(ContextCompat.getColor(getActivity(), R.color.pink_for_button));

        mCardViewWorkouts.setCardBackgroundColor(getResources()
                .getColor(R.color.color_card_view_glossary_1));
        mCardViewWarmUp.setCardBackgroundColor(getResources()
                .getColor(R.color.color_background_card_view_gloccary));
        mCardViewStretching.setCardBackgroundColor(getResources()
                .getColor(R.color.color_background_card_view_gloccary));
    }

    private void onClickStretching() {

        fragmentInteractionListener.pushFragmentGlossary(new GlossaryStretchingFragment(),
                false);

        textViewWarmup.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_card_view_glossary_1));
        textViewStretching.setTextColor(ContextCompat.getColor(getActivity(), R.color.pink_for_button));
        textViewWorkouts.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_card_view_glossary_1));

        mCardViewWorkouts.setCardBackgroundColor(getResources()
                .getColor(R.color.color_background_card_view_gloccary));
        mCardViewWarmUp.setCardBackgroundColor(getResources()
                .getColor(R.color.color_background_card_view_gloccary));
        mCardViewStretching.setCardBackgroundColor(getResources()
                .getColor(R.color.color_card_view_glossary_1));


    }

    @Override
    public void onDestroyView() {
        fragmentInteractionListener.updateActionBarTitle("TSC BODY");
        super.onDestroyView();
    }
}
