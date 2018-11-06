package com.example.tituh.fitnessproj.ui.interfaces;

import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;

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
}
