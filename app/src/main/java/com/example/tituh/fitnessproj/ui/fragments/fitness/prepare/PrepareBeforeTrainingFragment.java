package com.example.tituh.fitnessproj.ui.fragments.fitness.prepare;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

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

    private AlertDialog.Builder mDialogBuilderInfo;
    private AlertDialog mAlertDialogInfo;
    private CountDownTimer mCountDownTimer;

    private boolean isTimerCalcel;
    private boolean flag;

    private Button mButton1StartWorkout;
    private Button mButton2StartWorkout;
    private Button mButton3StartWorkout;
    private Button mButton4StartWorkout;

    private ViewPager mViewPagerFirst;
    private ViewPager mViewPagerSecond;
    private TabLayout tabLayoutFirst;
    private TabLayout tabLayoutSecond;

    ApiClient apiClient;
    private LayoutInflater layoutInflater;
    private View promptsView;
    private ProgressBar progressBar;

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
                clickBtnResponse();
                break;
            case R.id.button2_start_workout:
                clickBtnResponse();
                break;
            case R.id.button3_start_workout:
                clickBtnResponse();
                break;
            case R.id.button4_start_workout:
                clickBtnResponse();
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

        mDialogBuilderInfo = new AlertDialog.Builder(getActivity());
        layoutInflater = LayoutInflater.from(getActivity());
        promptsView = layoutInflater.inflate(R.layout.dialog_prepare, null);

        mDialogBuilderInfo.setView(promptsView);
        progressBar = promptsView.findViewById(R.id.progress_bar_prepare);
        mDialogBuilderInfo.setCancelable(false);

        mAlertDialogInfo = mDialogBuilderInfo.create();

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

    private void clickBtnResponse() {
        if (fragmentInteractionListener.isInternetConnectionSnackBar(linearLayout)) {
            mAlertDialogInfo.show();
            mAlertDialogInfo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            timer();
            apiClient.getTrainings(new OnGetTrainingResponseListener() {
                @Override
                public void onGetTrainingsResponse(@Nullable String message, boolean success, @Nullable TrainingResponse trainingResponse) {
                    if (trainingResponse != null) {
                        mArrayListResult.clear();
                        mArrayListResult.addAll(trainingResponse.getResults());
                        if (!isTimerCalcel) {
                            mCountDownTimer.cancel();
                        }
                        if (!flag) {
                            mAlertDialogInfo.dismiss();
                        } else {
                            pushFragmentWithBundle();
                        }

                    }
                }
            });
        }
    }

    private void timer() {
        isTimerCalcel = false;
        flag = true;

        mCountDownTimer = new CountDownTimer(4500, 500) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                final Snackbar snackbar = Snackbar.make(view, "Cant get data, try again", Snackbar.LENGTH_SHORT);
                snackbar.show();
                mAlertDialogInfo.dismiss();
                flag = false;
                if (!isTimerCalcel) {
                    mCountDownTimer.cancel();
                    isTimerCalcel = true;
                }
            }
        }.start();
    }


    private void pushFragmentWithBundle() {
        sortDeleteDuplicates(mArrayListResult);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("array_trainings", mArrayListResult);
        bundle.putStringArrayList("array_weeks", mWeekArray);
        bundle.putInt("count_weeks", mWeekArray.size());
        ChooseLevelFragment chooseLevelFragment = new ChooseLevelFragment();
        chooseLevelFragment.setArguments(bundle);
        mAlertDialogInfo.dismiss();
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
