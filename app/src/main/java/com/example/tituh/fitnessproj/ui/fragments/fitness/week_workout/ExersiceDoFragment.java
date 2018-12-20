package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.helpers.ProgressBarDrawable;
import com.example.tituh.fitnessproj.networking.responses.training.WorkoutsItem;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import com.ohoussein.playpause.PlayPauseView;
import java.util.ArrayList;
import java.util.Locale;

public class ExersiceDoFragment extends BaseFragment {

    private AwardFragment mAwardFragment;
    private RestFragment mRestFragment;
    private TextView mTextViewTime;
    private ProgressBar mProgressBarExersice;
    private Button mButtonBack;
    private Button mButtonNext;
    private ProgressBar mProgressBarCircuitProgress;
    private ImageView mImageView;
    private PlayPauseView mButtonPlayPause;
    private TextView mTextViewValueCircuit;
    private TextView mTextViewReps;
    private ArrayList<WorkoutsItem> mResultsItemsCircuitOneThree;
    private ArrayList<WorkoutsItem> mResultsItemsCircuitTwoFour;
    private ArrayList<WorkoutsItem> mAllWorkout;
    private int mLevel;
    private String mTitle;
    private int mCurrentTraining = 0;
    private ProgressBarDrawable mBgProgress;
    private int mFirstRest;
    private int mSecondRest;
    private int mThirdRest;
    private int mFourRest;
    private int mCurrentCircuit = 1;
    private long mStartTimeInMills;
    private long mTimeLeftInMills;
    private long mTimeLeftInMillsDialog;
    private boolean mTimerRunningExercise;
    private CountDownTimer mCountDownTimerExercise;
    private CountDownTimer mCountDownDialog;
    private Button buttonDialog;
    private TextView textViewDialog;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog.Builder dialogBuilderInfo;
    private LayoutInflater layoutInflater;
    private LayoutInflater layoutInflaterInfo;
    private View promptsView;
    private View promptsViewinfo;
    private AlertDialog alertDialog;
    private AlertDialog alertDialogInfo;
    private String key;
    private int weekClick;
    private int dayClick;
    private Button buttonInfoDialog;
    private TextView textViewInfoDialog;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.workout_start_layout, container, false);
            fragmentInteractionListener.setPressOnExersiceDoFragment(true);
            initialize();
            concatContent();
            setContent();
            mButtonBack.setEnabled(false);
            fragmentInteractionListener.getInfoButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!mAllWorkout.get(mCurrentTraining).getInfo().equalsIgnoreCase("-")) {
                    mButtonPlayPause.toggle();
                    if (ismTimerRunningExercise()) {
                        mTimerRunningExercise = false;
                        pauseTimerExercise();
                    } else {
                        mTimerRunningExercise = true;
                        startStopTimerExerciseDo(mTextViewTime, mProgressBarExersice, getFragmentManager());
                    }
                        showDialogInfo();
                        textViewInfoDialog.setText(mAllWorkout.get(mCurrentTraining).getInfo());
                    }
                }
            });

            buttonInfoDialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mButtonPlayPause.toggle();
                    if (ismTimerRunningExercise()) {
                        mTimerRunningExercise = false;
                        pauseTimerExercise();
                    } else {
                        mTimerRunningExercise = true;
                        startStopTimerExerciseDo(mTextViewTime, mProgressBarExersice, getFragmentManager());
                    }
                    alertDialogInfo.dismiss();
                }
            });

            buttonDialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setContent();
                    pauseTimeDialog();
                    alertDialog.dismiss();
                }
            });

            mButtonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCurrentTraining++;
                    if (ismTimerRunningExercise()) {
                        pauseTimerExercise();
                    }
                    if (mCurrentTraining == mFirstRest || mCurrentTraining == mSecondRest || mCurrentTraining == mThirdRest) {
                        mCurrentCircuit++;
                        goToRest();
                        return;
                    }
                    if (mCurrentTraining == mFourRest) {
                        fragmentInteractionListener.setPressOnExersiceDoFragment(false);
                        gotoAward();
                        return;
                    }
                    if (mCurrentTraining < mAllWorkout.size()) {
                        showDialog();
                    }
                }
            });

            mButtonPlayPause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mButtonPlayPause.toggle();
                    if (ismTimerRunningExercise()) {
                        mTimerRunningExercise = false;
                        pauseTimerExercise();
                    } else {
                        mTimerRunningExercise = true;
                        startStopTimerExerciseDo(mTextViewTime, mProgressBarExersice, getFragmentManager());
                    }
                }
            });

            mButtonBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mCurrentTraining == 0) {
                        mTimerRunningExercise = false;
                        pauseTimerExercise();
                        fragmentInteractionListener.popFragment();

                    } else {
                        pauseTimerExercise();
                        btnBackClick();
                    }
                }
            });
        }

        fragmentInteractionListener.visibilityIconHomeActionBar();
        fragmentInteractionListener.goneIconBacktActionBar();
        fragmentInteractionListener.visibilityIconInfoActionBar();
        fragmentInteractionListener.goneIconAbouttActionBar();
        fragmentInteractionListener.goneIconShareActionBar();

        return view;
    }


    private void initialize() {
        mImageView = view.findViewById(R.id.image_view_exercise_do);
        mTextViewTime = view.findViewById(R.id.text_view_time);
        mButtonPlayPause = view.findViewById(R.id.button_test_start_exercise);
        mProgressBarExersice = view.findViewById(R.id.progressBar_exersice);
        mButtonBack = view.findViewById(R.id.btn_back_exersice);
        mButtonNext = view.findViewById(R.id.btn_next_exersice);
        mProgressBarCircuitProgress = view.findViewById(R.id.progress_bar_circuit_progress);
        mTextViewValueCircuit = view.findViewById(R.id.textView_value_circuit);
        mTextViewReps = view.findViewById(R.id.text_view_reps);
        dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilderInfo = new AlertDialog.Builder(getActivity());
        layoutInflater = LayoutInflater.from(getActivity());
        layoutInflaterInfo = LayoutInflater.from(getActivity());
        promptsView = layoutInflater.inflate(R.layout.dialog_layout, null);
        promptsViewinfo = layoutInflaterInfo.inflate(R.layout.dialog_info, null);
        dialogBuilder.setView(promptsView);
        dialogBuilderInfo.setView(promptsViewinfo);
        dialogBuilder.setCancelable(false);
        dialogBuilderInfo.setCancelable(false);
        buttonDialog = promptsView.findViewById(R.id.btn_skip_workout);
        textViewDialog = promptsView.findViewById(R.id.text_view_seconds_left);
        buttonInfoDialog = promptsViewinfo.findViewById(R.id.btn_ok_dialog_info);
        textViewInfoDialog = promptsViewinfo.findViewById(R.id.text_info_dialog_exercise_do);
        alertDialog = dialogBuilder.create();
        alertDialogInfo = dialogBuilderInfo.create();
        mResultsItemsCircuitOneThree = new ArrayList<>();
        mResultsItemsCircuitTwoFour = new ArrayList<>();
        mAllWorkout = new ArrayList<>();
        mResultsItemsCircuitOneThree = getArguments().getParcelableArrayList("array_trainings_one_three_workout");
        mResultsItemsCircuitTwoFour = getArguments().getParcelableArrayList("array_trainings_two_four_workout");
        mLevel = getArguments().getInt("level");
        mTitle = getArguments().getString("title");
        key = getArguments().getString("key");
        weekClick = getArguments().getInt("week_click");
        dayClick = getArguments().getInt("day_click");
        mFirstRest = mResultsItemsCircuitOneThree.size();
        mSecondRest = mResultsItemsCircuitOneThree.size() + mResultsItemsCircuitTwoFour.size();
        mThirdRest = mResultsItemsCircuitOneThree.size() * 2 + mResultsItemsCircuitTwoFour.size();
        mFourRest = (mResultsItemsCircuitOneThree.size() + mResultsItemsCircuitTwoFour.size()) * 2;
        fragmentInteractionListener.visibilityIconHomeActionBar();
        fragmentInteractionListener.goneIconBacktActionBar();
        fragmentInteractionListener.visibilityIconInfoActionBar();
        fragmentInteractionListener.goneIconAbouttActionBar();
        fragmentInteractionListener.goneIconShareActionBar();

    }

    @SuppressLint("SetTextI18n")
    public void setContent() {
        if (mCurrentTraining == 0 || mCurrentTraining == mFirstRest || mCurrentTraining == mSecondRest || mCurrentTraining == mThirdRest) {
            mButtonBack.setEnabled(false);
        } else mButtonBack.setEnabled(true);
        mTextViewValueCircuit.setText(mCurrentCircuit + "/" + 4);
        if(getActivity()!=null) {
            Glide.with(getActivity())
                    .load(mAllWorkout.get(mCurrentTraining).getImage())
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.placeholder_recipes))
                    .into(mImageView);
        }
        fragmentInteractionListener.visibilityIconHomeActionBar();
        fragmentInteractionListener.updateActionBarTitle(mAllWorkout.get(mCurrentTraining).getTitle());
        mBgProgress = new ProgressBarDrawable(mResultsItemsCircuitOneThree.size());
        mProgressBarCircuitProgress.setMax(mResultsItemsCircuitOneThree.size());
        mProgressBarCircuitProgress.setProgressDrawable(mBgProgress);
        mProgressBarCircuitProgress.setProgress(mCurrentTraining % mResultsItemsCircuitOneThree.size());
        mProgressBarExersice.setMax((int) mAllWorkout.get(mCurrentTraining).getDuration());
        mButtonPlayPause.change(false);
        if (mLevel == 0) {
            mTextViewReps.setText(mAllWorkout.get(mCurrentTraining).getRepetitions().getBeginner() + " Reps");
        }
        if (mLevel == 1) {
            mTextViewReps.setText(mAllWorkout.get(mCurrentTraining).getRepetitions().getIntermediate() + " Reps");
        }
        if (mLevel == 2) {
            mTextViewReps.setText(mAllWorkout.get(mCurrentTraining).getRepetitions().getAdvanced() + " Reps");
        }
        startTimerExercise((int) mAllWorkout.get(mCurrentTraining).getDuration() * 1000, mTextViewTime, //
                mProgressBarExersice);
    }


    private void goToRest() {
        Bundle bundle = new Bundle();
        mProgressBarCircuitProgress.setProgress(0);
        bundle.putInt("circuit", mCurrentCircuit);
        bundle.putString("title", mTitle);
        mRestFragment = new RestFragment();
        mRestFragment.setArguments(bundle);
        fragmentInteractionListener.pushFragment(mRestFragment, true);
    }


    private void gotoAward() {
        Bundle bundle = new Bundle();
        bundle.putString("title", mTitle);
        bundle.putString("week", getArguments().getString("week"));
        bundle.putString("day", getArguments().getString("day"));
        bundle.putString("key", key);
        bundle.putInt("level", mLevel);
        bundle.putInt("week_click", weekClick);
        bundle.putInt("day_click", dayClick);
        mAwardFragment = new AwardFragment();
        mAwardFragment.setArguments(bundle);
        fragmentInteractionListener.pushFragment(mAwardFragment, true);
    }

    public void btnBackClick() {
        mCurrentTraining--;
        setContent();
    }

    public void startTimerExercise(long startTime, final TextView textView, final ProgressBar progressBar) {

        mStartTimeInMills = startTime;
        mTimeLeftInMills = startTime;
        mTimerRunningExercise = true;
        mCountDownTimerExercise = new CountDownTimer(mTimeLeftInMills, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMills = l;
                updateCountDownText(textView);
                long valueProgressBar = mStartTimeInMills / 1000 - mTimeLeftInMills / 1000;
                progressBar.setProgress((int) valueProgressBar);
            }

            @Override
            public void onFinish() {
                mCurrentTraining++;
                pauseTimerExercise();
                if (mCurrentTraining == mFirstRest || mCurrentTraining == mSecondRest || mCurrentTraining == mThirdRest) {
                    goToRest();
                    return;
                }
                if (mCurrentTraining == mFourRest) {
                    gotoAward();
                    return;
                }
                if (mCurrentTraining < mAllWorkout.size()) {
                    showDialog();
                }
            }
        }.start();
    }

    public void startStopTimerExercise(final TextView textView, final ProgressBar progressBar,
                                       final FragmentManager fragmentManager) {

        mTimerRunningExercise = true;
        mCountDownTimerExercise = new CountDownTimer(mTimeLeftInMills, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMills = l;
                updateCountDownText(textView);
                long valueProgressBar = mStartTimeInMills / 1000 - mTimeLeftInMills / 1000;
                progressBar.setProgress((int) valueProgressBar);
            }

            @Override
            public void onFinish() {
                pauseTimerExercise();
                showDialog();
            }
        }.start();
        mTimerRunningExercise = true;
    }

    public void showDialog() {
        alertDialog.show();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mCountDownDialog = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMillsDialog = l;
                updateCountDownTextDialog(textViewDialog);
            }

            @Override
            public void onFinish() {
                setContent();
                pauseTimeDialog();
                alertDialog.dismiss();
            }
        }.start();
    }


    public void showDialogInfo() {
        alertDialogInfo.show();
    }

    private void concatContent() {
        mAllWorkout.addAll(mResultsItemsCircuitOneThree);
        mAllWorkout.addAll(mResultsItemsCircuitTwoFour);
        mAllWorkout.addAll(mResultsItemsCircuitOneThree);
        mAllWorkout.addAll(mResultsItemsCircuitTwoFour);
    }


    private void updateCountDownText(TextView textView) {
        int seconds = (int) (mTimeLeftInMills / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%1d", seconds);
        textView.setText(timeLeftFormatted);
    }

    private void updateCountDownTextDialog(TextView textView) {
        int seconds = (int) (mTimeLeftInMillsDialog / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%1d", seconds);
        textView.setText(timeLeftFormatted);
    }

    public void startStopTimerExerciseDo(TextView textViewTime,
                                         ProgressBar progressBarExersice, FragmentManager fragmentManager) {
        mTimerRunningExercise = true;
        startStopTimerExercise(textViewTime, progressBarExersice, fragmentManager);
    }

    public boolean ismTimerRunningExercise() {
        return mTimerRunningExercise;
    }

    public void pauseTimerExercise() {
        mCountDownTimerExercise.cancel();
        mTimerRunningExercise = false;
    }

    public void pauseTimeDialog() {
        mCountDownDialog.cancel();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        pauseTimerExercise();
        super.onDestroy();
    }
}