package com.example.tituh.fitnessproj.ui.fragments.fitness.prepare;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dd.CircularProgressButton;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.ViewPagerAdapter;
import com.example.tituh.fitnessproj.model.ChooseLevelModel;
import com.example.tituh.fitnessproj.networking.ApiClient;
import com.example.tituh.fitnessproj.networking.responses.OnGetTrainingResponseListener;
import com.example.tituh.fitnessproj.networking.responses.training.ResultsItem;
import com.example.tituh.fitnessproj.networking.responses.training.TrainingResponse;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout.ChooseLevelFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class PrepareBeforeTrainingFragment extends BaseFragment implements View.OnClickListener {

    private FitnessPrepareTabFragmentStretch mFirstStretchFragment;
    private FitnessPrepareTabFragmentYoga mSecondYogaFragment;
    private FitnessPrepareTabFragmentIncreaseTheBurn1 mFirstIncreaseTheBurnFragment;
    private FitnessPrepareTabFragmentIncreaseTheBurn2 mSecondIncreaseTheBurnFragment;

    private Button mButton1StartWorkout;
    private Button mButton2StartWorkout;
    private Button mButton3StartWorkout;
    private Button mButton4StartWorkout;

    private ViewPager mViewPagerFirst;
    private ViewPager mViewPagerSecond;
    private TabLayout tabLayoutFirst;
    private TabLayout tabLayoutSecond;

    ApiClient apiClient;

    private ArrayList<ChooseLevelModel> mModelLevel;
    private ArrayList<ResultsItem> mArrayListResult; //need
    private HashSet<String> mArrayWithoutDuplicates;

    private ArrayList<String> mWeekArray;//need
    private int mCountWeek;
    LinearLayout linearLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fitness_prepare_before_training, container, false);
            initialite();
        }
        return view;
    }

    private void setupViewPagerFirst(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mFirstStretchFragment = new FitnessPrepareTabFragmentStretch();
        mSecondYogaFragment = new FitnessPrepareTabFragmentYoga();
        viewPagerAdapter.addFragment(mFirstStretchFragment);
        viewPagerAdapter.addFragment(mSecondYogaFragment);
        viewPager.setAdapter(viewPagerAdapter);
    }

    private void setupViewPagerSecond(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mFirstIncreaseTheBurnFragment = new FitnessPrepareTabFragmentIncreaseTheBurn1();
        mSecondIncreaseTheBurnFragment = new FitnessPrepareTabFragmentIncreaseTheBurn2();
        viewPagerAdapter.addFragment(mFirstIncreaseTheBurnFragment);
        viewPagerAdapter.addFragment(mSecondIncreaseTheBurnFragment);
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1_start_workout:
                clickBtnResponse(mButton1StartWorkout);
                break;
            case R.id.button2_start_workout:
                clickBtnResponse(mButton2StartWorkout);
                break;
            case R.id.button3_start_workout:
                clickBtnResponse(mButton3StartWorkout);
                break;
            case R.id.button4_start_workout:
                clickBtnResponse(mButton4StartWorkout);
                break;
        }
    }


    private void initialite() {
        fragmentInteractionListener.updateActionBarTitle("PREPARE");
        fragmentInteractionListener.visibleIconBacktActionBar();
        fragmentInteractionListener.goneIconAbouttActionBar();

        mViewPagerFirst = view.findViewById(R.id.fitness_prepare_view_pager_1);
        mViewPagerSecond = view.findViewById(R.id.fitness_prepare_view_pager_2);
        tabLayoutFirst = view.findViewById(R.id.fitness_prepare_tabDots_1);
        tabLayoutSecond = view.findViewById(R.id.fitness_prepare_tabDots_2);
        linearLayout = view.findViewById(R.id.linear_for_prepare);

        apiClient = new ApiClient();

        mArrayListResult = new ArrayList<>();
        mWeekArray = new ArrayList<>();
        mModelLevel = new ArrayList<>();
        mArrayWithoutDuplicates = new HashSet<>();

        mButton1StartWorkout = view.findViewById(R.id.button1_start_workout);
        mButton2StartWorkout = view.findViewById(R.id.button2_start_workout);
        mButton3StartWorkout = view.findViewById(R.id.button3_start_workout);
        mButton4StartWorkout = view.findViewById(R.id.button4_start_workout);

        mButton1StartWorkout.setOnClickListener(this);
        mButton2StartWorkout.setOnClickListener(this);
        mButton3StartWorkout.setOnClickListener(this);
        mButton4StartWorkout.setOnClickListener(this);

        tabLayoutFirst.setupWithViewPager(mViewPagerFirst, true);
        tabLayoutSecond.setupWithViewPager(mViewPagerSecond, true);

        setupViewPagerFirst(mViewPagerFirst);
        setupViewPagerSecond(mViewPagerSecond);
    }

    private void clickBtnResponse(final Button button){
        if (fragmentInteractionListener.isInternetConnectionSnackBar(linearLayout)) {
            button.setEnabled(false);
            apiClient.getTrainings(new OnGetTrainingResponseListener() {
                @Override
                public void onGetTrainingsResponse(@Nullable String message, boolean success, @Nullable TrainingResponse trainingResponse) {
                    try {
                        mArrayListResult.clear();
                        mArrayListResult.addAll(trainingResponse.getResults());
                        pushFragmentWithBundle();
                        button.setEnabled(true);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void pushFragmentWithBundle() {
        sortDeleteDuplicates(mArrayListResult);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("array_trainings", mArrayListResult);
        bundle.putStringArrayList("array_weeks", mWeekArray);
        bundle.putInt("count_weeks", mWeekArray.size());
        ChooseLevelFragment chooseLevelFragment = new ChooseLevelFragment();
        chooseLevelFragment.setArguments(bundle);
        fragmentInteractionListener.pushFragment(chooseLevelFragment, true);
    }



    private ArrayList<String> sortDeleteDuplicates(ArrayList<ResultsItem> resultsItemsArrayList) {
        mArrayWithoutDuplicates.clear();
        mWeekArray.clear();
        for (int i = 0; i < resultsItemsArrayList.size(); i++) {
            for (int j = 0; j < resultsItemsArrayList.get(i).getWeeks().size(); j++) {
                String week;
                week = resultsItemsArrayList.get(i).getWeeks().get(j);
                mArrayWithoutDuplicates.add(week);
            }
        }
        mWeekArray.addAll(mArrayWithoutDuplicates);
        Collections.sort(mWeekArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return extractInt(o1) - extractInt(o2);
            }
        });

        return mWeekArray;
    }


    private int extractInt(String s) {
        String num = s.replaceAll("\\D", "");
        return num.isEmpty() ? 0 : Integer.parseInt(num);
    }


    @Override
    public void onDestroyView() {
        fragmentInteractionListener.updateActionBarTitle("TSC BODY");
        super.onDestroyView();
    }
}
