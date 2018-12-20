package com.example.tituh.fitnessproj.ui.interfaces;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import org.w3c.dom.Text;

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

    boolean isInternetConnectionSnackBarWithProgress(View view, ProgressBar progressBar);

    boolean isInternetConnection();

    boolean isInternetConnectionSnackBar(View view);

    boolean getPressOnExersiceDoFragment();

    void setPressOnExersiceDoFragment(boolean value);

    ImageView getInfoButton();

    ImageView getmImageViewAboutActionBar();

}