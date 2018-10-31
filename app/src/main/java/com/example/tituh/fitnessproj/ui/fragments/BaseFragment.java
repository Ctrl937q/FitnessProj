package com.example.tituh.fitnessproj.ui.fragments;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.tituh.fitnessproj.ui.interfaces.OnFragmentInteractionListener;

public class BaseFragment extends Fragment {
    protected OnFragmentInteractionListener fragmentInteractionListener;
    protected View view;

    public String getBackStackTag() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            fragmentInteractionListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentInteractionListener = null;
    }

    protected boolean isActivityAvailable() {
        Activity activity = getActivity();
        return null != activity && !activity.isFinishing();
    }


    public void showContentLayout() {
        if (null!=fragmentInteractionListener && isActivityAvailable()) fragmentInteractionListener.runUiTask(new Runnable() {
            @Override
            public void run() {
                //TODO add progress layout to every fragment if needed
               // view.findViewById(R.id.progress_layout).setVisibility(View.GONE);
            }
        });
    }


    public void showProgressBar() {
        if (null!=fragmentInteractionListener && isActivityAvailable()) fragmentInteractionListener.runUiTask(new Runnable() {
            @Override
            public void run() {
                //TODO add progress layout to every fragment if needed
                // view.findViewById(R.id.progress_layout).setVisibility(View.VISIBLE);
            }
        });
    }


    public void showSnackMessage(final String message) {
        if (null!=fragmentInteractionListener && isActivityAvailable()) fragmentInteractionListener.showSnackMessage(message);
    }


    public void showSnackMessage(int stringResId) {
        if (null!=fragmentInteractionListener && isActivityAvailable()) fragmentInteractionListener.showSnackMessage(stringResId);
    }
}
