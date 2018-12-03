package com.example.tituh.fitnessproj.ui.interfaces;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

public interface OnFragmentInteractionListener {
    void pushFragment(BaseFragment fragment, boolean shouldAddToBackstack);

    void pushFragmentGlossary(BaseFragment fragment, boolean shouldAddToBackstack);

    void popFragment();

    void runUiTask(Runnable task);

    void showAlertDialog(View view, boolean atBottom);

    void showAlertDialog(@NonNull AlertDialog dialog);

    View inflateView(int res);

    void showSnackMessage(String message);

    void showSnackMessage(int stringResId);

    void updateActionBarTitle(String title);

    void goneIconBacktActionBar();

    void goneIconAbouttActionBar();

    void visibleIconBacktActionBar();

    void visibleIconAboutActionBar();

    void visibilityIconHomeActionBar();

    void visibilityIconInfoActionBar();

    void visibilityIconShareActionBar();

    void visibilityIconBackGetReadyActionBar();

    void goneIconHomeActionBar();

    void goneIconInfoActionBar();

    void goneIconShareActionBar();

    void goneIconBackGetReadyActionBar();

    void startTimerGetReady(TextView textView, FragmentManager fragmentManager);

    void stopTimerGetReady();

    void startTimerExerciseDo(TextView textViewTime,
                              ProgressBar progressBarExersice, FragmentManager fragmentManager);

    void stopTimerExerciseDo();

    void btnPlayPause(int timerValue, TextView textViewTime,
                      ProgressBar progressBarExersice, FragmentManager fragmentManager);

    void btnBackPressed();


}
