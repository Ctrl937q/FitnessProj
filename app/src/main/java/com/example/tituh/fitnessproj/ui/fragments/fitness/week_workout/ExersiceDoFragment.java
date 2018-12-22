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
import android.util.Log;
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
    private AlertDialog.Builder dialogBuilderInfo;
    private LayoutInflater layoutInflaterInfo;
    private View promptsViewinfo;
    private AlertDialog alertDialogInfo;
    private Button buttonInfoDialog;
    private TextView textViewInfoDialog;
    private Button buttonDialog;
    private TextView textViewDialog;
    private AlertDialog.Builder dialogBuilder;
    private LayoutInflater layoutInflater;
    private View promptsView;
    private AlertDialog alertDialog;
    private String key;
    private int weekClick;
    private int dayClick;
    private String day;
    private boolean mTimerRunningDialog = false;
    private boolean dialogShow = false;

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
                        if (ismTimerRunningExercise()) {
                            pauseTimerExercise();
                        }
                        showDialogInfo();
                        textViewInfoDialog.setText(mAllWorkout.get(mCurrentTraining).getInfo());
                    }
                }
            });

            buttonInfoDialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startStopTimerExerciseDo(mTextViewTime, mProgressBarExersice);
                    alertDialogInfo.dismiss();
                }
            });

            buttonDialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mTimerRunningDialog = false;
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
                    if (ismTimerRunningExercise()) {
                        mTimerRunningExercise = false;
                        pauseTimerExercise();
                    } else {
                        mTimerRunningExercise = true;
                        startStopTimerExerciseDo(mTextViewTime, mProgressBarExersice);
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
        fragmentInteractionListener.goneIconAbouttActionBar();
        fragmentInteractionListener.goneIconShareActionBar();

        return view;
    }


    @SuppressLint("SetTextI18n")
    public void setContent() {
        Log.d("saddsa12eadsadssa", "setContent");

        if (mCurrentTraining == 0 || mCurrentTraining == mFirstRest || mCurrentTraining == mSecondRest || mCurrentTraining == mThirdRest) {
            mButtonBack.setEnabled(false);
        } else mButtonBack.setEnabled(true);
        mTextViewValueCircuit.setText(mCurrentCircuit + "/" + 4);
        if (getActivity() != null) {
            Glide.with(getActivity())
                    .load(mAllWorkout.get(mCurrentTraining).getImage())
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.placeholder_recipes))
                    .into(mImageView);
        }
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

        Log.d("sadasd123defwasz", "" + mAllWorkout.get(mCurrentTraining).getInfo());
        if (!mAllWorkout.get(mCurrentTraining).getInfo().equalsIgnoreCase("-")) {
            fragmentInteractionListener.visibilityIconInfoActionBar();
        } else fragmentInteractionListener.goneIconInfoActionBar();
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
        bundle.putInt("trainingId", getArguments().getInt("trainingId"));
        bundle.putString(day, "day");
        mAwardFragment = new AwardFragment();
        mAwardFragment.setArguments(bundle);
        fragmentInteractionListener.pushFragment(mAwardFragment, true);
    }

    public void btnBackClick() {
        mCurrentTraining--;
        setContent();
    }

    public void startTimerExercise(long startTime, final TextView textView, final ProgressBar progressBar) {
        Log.d("saddsa12eadsadssa", "startTimerExercise");
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
                mTimerRunningExercise = false;
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
        }.start();
    }

    public void startStopTimerExercise(final TextView textView, final ProgressBar progressBar) {
        Log.d("saddsa12eadsadssa", "startStopTimerExercise");

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
                mTimerRunningExercise = false;
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
        }.start();
        // mTimerRunningExercise = true;
    }

    public void showDialog() {
        alertDialog.show();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        startDimerDialog();
    }


    public void startDimerDialog() {
        mTimerRunningDialog = true;
        mButtonPlayPause.change(false);
        mCountDownDialog = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMillsDialog = l;
                updateCountDownTextDialog(textViewDialog);
            }

            @Override
            public void onFinish() {
                Log.d("saddsa12eadsadssa", "+");
                mTimerRunningDialog = false;
                setContent();
                pauseTimeDialog();
                alertDialog.dismiss();
            }
        }.start();
    }


    public void startStopTimerExerciseDo(TextView textViewTime,
                                         ProgressBar progressBarExersice) {

        mButtonPlayPause.change(false);

        startStopTimerExercise(textViewTime, progressBarExersice);
    }

    public boolean ismTimerRunningExercise() {
        return mTimerRunningExercise;
    }

    public void pauseTimerExercise() {
        Log.d("233321sadsadsaa", "+");
        mButtonPlayPause.change(true);
        mCountDownTimerExercise.cancel();
        mTimerRunningExercise = false;
    }

    public void pauseTimeDialog() {
        Log.d("233321sadsadsaa", "+");
        mCountDownDialog.cancel();
    }

    @Override
    public void onPause() {
        if (ismTimerRunningExercise()) {
            pauseTimerExercise();
        }
        if (mTimerRunningDialog) {
            dialogShow = true;
            pauseTimeDialog();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        if (dialogShow) {
            startDimerDialog();
            dialogShow = false;
        }
        if (!mTimerRunningExercise && !mTimerRunningDialog) {
            startStopTimerExerciseDo(mTextViewTime, mProgressBarExersice);
        }
        super.onResume();
    }

    @Override
    public void onDestroy() {
        pauseTimerExercise();
        super.onDestroy();
    }


    //------------------------------------------------------------------------------------------


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
        int minutes = (int) (mTimeLeftInMills / 1000) / 60;
        int seconds = (int) (mTimeLeftInMills / 1000) % 60;
        String timeLeftWithinutes = String.format(Locale.getDefault(), "%2d:%02d", minutes, seconds);
        String timeLeftFormatted = String.format(Locale.getDefault(), "%1d", seconds);
        if (mTimeLeftInMills / 1000 >= 60) {
            textView.setText(timeLeftWithinutes);
        } else {
            textView.setText(timeLeftFormatted);
        }
    }

    private void updateCountDownTextDialog(TextView textView) {
        int seconds = (int) (mTimeLeftInMillsDialog / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%1d", seconds);
        textView.setText(timeLeftFormatted);
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


        dialogBuilderInfo = new AlertDialog.Builder(getActivity());
        layoutInflaterInfo = LayoutInflater.from(getActivity());
        promptsViewinfo = layoutInflaterInfo.inflate(R.layout.dialog_info, null);
        dialogBuilderInfo.setView(promptsViewinfo);
        dialogBuilderInfo.setCancelable(false);
        buttonInfoDialog = promptsViewinfo.findViewById(R.id.btn_ok_dialog_info);
        textViewInfoDialog = promptsViewinfo.findViewById(R.id.text_info_dialog_exercise_do);
        alertDialogInfo = dialogBuilderInfo.create();

        dialogBuilder = new AlertDialog.Builder(getActivity());
        layoutInflater = LayoutInflater.from(getActivity());
        promptsView = layoutInflater.inflate(R.layout.dialog_layout, null);
        dialogBuilder.setView(promptsView);
        dialogBuilder.setCancelable(false);
        dialogBuilderInfo.setCancelable(false);

        buttonDialog = promptsView.findViewById(R.id.btn_skip_workout);
        textViewDialog = promptsView.findViewById(R.id.text_view_seconds_left);
        alertDialog = dialogBuilder.create();
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
        day = getArguments().getString("day");
        mFirstRest = mResultsItemsCircuitOneThree.size();
        mSecondRest = mResultsItemsCircuitOneThree.size() + mResultsItemsCircuitTwoFour.size();
        mThirdRest = mResultsItemsCircuitOneThree.size() * 2 + mResultsItemsCircuitTwoFour.size();
        mFourRest = (mResultsItemsCircuitOneThree.size() + mResultsItemsCircuitTwoFour.size()) * 2;
        fragmentInteractionListener.visibilityIconHomeActionBar();
        fragmentInteractionListener.goneIconBacktActionBar();
        fragmentInteractionListener.goneIconAbouttActionBar();
        fragmentInteractionListener.goneIconShareActionBar();
        fragmentInteractionListener.goneIconInfoActionBar();

    }
}