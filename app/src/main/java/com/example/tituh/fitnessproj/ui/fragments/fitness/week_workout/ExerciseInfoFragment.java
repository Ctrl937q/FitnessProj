package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.ExerciseRecyclerViewAdapter;
import com.example.tituh.fitnessproj.helpers.MarginItemDecoration;
import com.example.tituh.fitnessproj.networking.responses.training.EquipmentItem;
import com.example.tituh.fitnessproj.networking.responses.training.ResultsItem;
import com.example.tituh.fitnessproj.networking.responses.training.WorkoutsItem;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExerciseInfoFragment extends BaseFragment {

    private ArrayList<ResultsItem> mResultTraining;
    private ArrayList<WorkoutsItem> mResultsItemsCircuitOneThree;
    private ArrayList<WorkoutsItem> mResultsItemsCircuitTwoFour;
    private List<EquipmentItem> equipmentItems;
    private ArrayList<Integer> idEquipmentArray;
    private GetReadyFragment mGetReadyFragment;
    private TextView textViewCircuit;
    private int mWeekClick;
    private int mDayClick;
    private double mTime;
    private int mLevel;
    private String mDay;
    private String mWeek;
    private String mKeyShared;
    private ImageView imageViewEquip1;
    private ImageView imageViewEquip2;
    private ImageView imageViewEquip3;
    private ImageView imageViewEquip4;
    private ImageView imageViewEquip5;
    private ImageView imageViewEquip6;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.exercise_choose_fragment, container, false);

            RecyclerView recyclerView = view.findViewById(R.id.recyclerView_exercise_choose);
            TextView textViewTitle = view.findViewById(R.id.textView_title_exercise_info_fragment);
            Button mButtonStart = view.findViewById(R.id.button_start_workout);
            TextView textViewAllTime = view.findViewById(R.id.textView_training_info_time);
            imageViewEquip1 = view.findViewById(R.id.image_1_info);
            imageViewEquip2 = view.findViewById(R.id.image_2_info);
            imageViewEquip3 = view.findViewById(R.id.image_3_info);
            imageViewEquip4 = view.findViewById(R.id.image_4_info);
            imageViewEquip5 = view.findViewById(R.id.image_5_info);
            imageViewEquip6 = view.findViewById(R.id.image_6_info);
            textViewCircuit = view.findViewById(R.id.textViewCircuit_info_fragment);

            ImageView[] imageViewsArray = {imageViewEquip1, imageViewEquip2,
                    imageViewEquip3, imageViewEquip4, imageViewEquip5, imageViewEquip6};

            mResultTraining = new ArrayList<>();
            mResultsItemsCircuitOneThree = new ArrayList<>();
            mResultsItemsCircuitTwoFour = new ArrayList<>();
            idEquipmentArray = new ArrayList<>();

            mResultTraining = getArguments().getParcelableArrayList("array_trainings_for_training_info");

            mWeekClick = getArguments().getInt("week_click");
            mDayClick = getArguments().getInt("day_click");
            mLevel = getArguments().getInt("level");
            mTime = Double.parseDouble(mResultTraining.get(0).getDuration()) / 60;
            mWeek = getArguments().getString("week");
            mDay = getArguments().getString("day");
            mKeyShared = mLevel + mWeek + mDay;

            textViewTitle.setText("" + mResultTraining.get(0).getTitle());
            textViewAllTime.setText("" + (int) mTime + " minutes");

            filterCircuitOneThree(mResultTraining);
            filterCircuitTwoFout(mResultTraining);



            for (int i = 0; i < mResultTraining.get(0).getEquipment().size(); i++) {
                idEquipmentArray.add(mResultTraining.get(0).getEquipment().get(i).getId());
            }

            for (int i = 0; i < idEquipmentArray.size(); i++) {
                if (idEquipmentArray.get(i) == 1) {
                    imageViewsArray[i].setImageDrawable(getResources().getDrawable(R.drawable.image_one_training_need1));
                    imageViewsArray[i].setVisibility(View.VISIBLE);
                }
                if (idEquipmentArray.get(i) == 2) {
                    imageViewsArray[i].setImageDrawable(getResources().getDrawable(R.drawable.image_two_training_need1));
                    imageViewsArray[i].setVisibility(View.VISIBLE);

                }
                if (idEquipmentArray.get(i) == 3 || idEquipmentArray.get(i) == 7) {
                    imageViewsArray[i].setImageDrawable(getResources().getDrawable(R.drawable.image_three_training_need1));
                    imageViewsArray[i].setVisibility(View.VISIBLE);
                }
                if (idEquipmentArray.get(i) == 4) {
                    imageViewsArray[i].setImageDrawable(getResources().getDrawable(R.drawable.image_four_training_need1));
                    imageViewsArray[i].setVisibility(View.VISIBLE);
                }
                if (idEquipmentArray.get(i) == 5) {
                    imageViewsArray[i].setImageDrawable(getResources().getDrawable(R.drawable.image_five_training_need1));
                    imageViewsArray[i].setVisibility(View.VISIBLE);

                }
                if (idEquipmentArray.get(i) == 6) {
                    imageViewsArray[i].setImageDrawable(getResources().getDrawable(R.drawable.image_six_training_need1));
                    imageViewsArray[i].setVisibility(View.VISIBLE);

                }
            }


            mButtonStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("array_trainings_one_three", mResultsItemsCircuitOneThree);
                    bundle.putParcelableArrayList("array_trainings_two_four", mResultsItemsCircuitTwoFour);
                    bundle.putInt("level", mLevel);
                    bundle.putString("title", mResultTraining.get(0).getTitle());
                    bundle.putString("week", getArguments().getString("week"));
                    bundle.putString("day", getArguments().getString("day"));
                    bundle.putString("key", mKeyShared);
                    bundle.putInt("day_click", mDayClick);
                    bundle.putInt("week_click", mWeekClick);
                    bundle.putInt("trainingId", mResultTraining.get(0).getId());
                    mGetReadyFragment = new GetReadyFragment();
                    mGetReadyFragment.setArguments(bundle);
                    fragmentInteractionListener.pushFragment(mGetReadyFragment, true);

                }
            });
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(new ExerciseRecyclerViewAdapter(mResultsItemsCircuitOneThree, mResultsItemsCircuitTwoFour, mLevel, getActivity()));
            recyclerView.addItemDecoration(new MarginItemDecoration(1, 10, 0, 10, 10));
        }

        fragmentInteractionListener.updateActionBarTitle("WEEK " + mWeekClick + " - Day " + mDayClick);

        return view;
    }

    private void filterCircuitOneThree(List<ResultsItem> arrayList) {
        mResultsItemsCircuitOneThree.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.get(i).getWorkouts().size(); j++) {
                if (arrayList.get(i).getWorkouts().get(j).getCircuit() == 1) {
                    mResultsItemsCircuitOneThree.add(arrayList.get(i).getWorkouts().get(j));
                }
            }
        }
        Collections.sort(mResultsItemsCircuitOneThree, new Comparator<WorkoutsItem>() {
            @Override
            public int compare(WorkoutsItem workoutsItem, WorkoutsItem t1) {
                return workoutsItem.getPosition() - t1.getPosition();
            }
        });
    }

    private void filterCircuitTwoFout(List<ResultsItem> arrayList) {
        mResultsItemsCircuitTwoFour.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.get(i).getWorkouts().size(); j++) {
                if (arrayList.get(i).getWorkouts().get(j).getCircuit() == 2) {
                    mResultsItemsCircuitTwoFour.add(arrayList.get(i).getWorkouts().get(j));
                }
            }
        }
        Collections.sort(mResultsItemsCircuitTwoFour, new Comparator<WorkoutsItem>() {
            @Override
            public int compare(WorkoutsItem workoutsItem, WorkoutsItem t1) {
                return workoutsItem.getPosition() - t1.getPosition();
            }
        });
    }
}