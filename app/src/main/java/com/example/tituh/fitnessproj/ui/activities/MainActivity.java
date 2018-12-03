package com.example.tituh.fitnessproj.ui.activities;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.helpers.TimerClass;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import com.example.tituh.fitnessproj.ui.fragments.MainTabLayoutFragment;
import com.example.tituh.fitnessproj.ui.interfaces.OnFragmentInteractionListener;


public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    private TextView mActionBarTitle;
    private ImageView mImageViewBackActionBar;
    private ImageView mImageViewAboutActionBar;
    private ImageView mImageHomeActionBar;
    private ImageView mImageViewInfo;
    private ImageView mImageViewShare;
    private ImageView mImageViewBackActionBarGetReady;

    TimerClass timerClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.app_bar);

        mActionBarTitle = findViewById(R.id.action_bar_text_view);
        mImageViewBackActionBar = findViewById(R.id.action_bar_arrow);
        mImageViewAboutActionBar = findViewById(R.id.action_bar_about);
        mImageHomeActionBar = findViewById(R.id.action_bar_home);
        mImageViewInfo = findViewById(R.id.action_bar_info);
        mImageViewShare = findViewById(R.id.action_bar_share);
        mImageViewBackActionBarGetReady = findViewById(R.id.action_bar_arrow_get_ready);
        setSupportActionBar(toolbar);
        timerClass = new TimerClass();
        mImageViewBackActionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timerClass.ismTimerRunningExercise()) {
                    stopTimerExerciseDo();
                }
                if (timerClass.ismTimerRunningGetReady()) {
                    stopTimerGetReady();
                }
                popFragment();
            }
        });
        mImageHomeActionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        pushFragment(new MainTabLayoutFragment(), false);
    }

    //TODO remove 'name' parameter from method definition, use fragment.getBackStackTag() instead

    @Override
    public void pushFragment(BaseFragment fragment, boolean shouldAddToBackstack) {
        if (!isFinishing()) {
            String tag = String.format("%s:%s", fragment.getBackStackTag(), String.valueOf(System.currentTimeMillis()));
            //Log.v(tag, tag);
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            //ft.setCustomAnimations(R.animator.slide_in_left, 0);
            ft.replace(R.id.fragment_container, fragment, tag);
            if (shouldAddToBackstack) ft.addToBackStack(tag);
            ft.commit();
        }
    }

    @Override
    public void pushFragmentGlossary(BaseFragment fragment, boolean shouldAddToBackstack) {
        if (!isFinishing()) {
            String tag = String.format("%s:%s", fragment.getBackStackTag(), String.valueOf(System.currentTimeMillis()));
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            //ft.setCustomAnimations(R.animator.slide_in_left, 0);
            ft.replace(R.id.fragment_container_glossary, fragment, tag);
            if (shouldAddToBackstack) ft.addToBackStack(tag);
            ft.commit();
        }
    }

    @Override
    public void popFragment() {
        if (!isFinishing()) {
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStack();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public void runUiTask(Runnable task) {
        if (!isFinishing()) {
            runOnUiThread(task);
        }
    }

    @Override
    public void onBackPressed() {
        if (timerClass.ismTimerRunningExercise()) {
            stopTimerExerciseDo();
        }
        if (timerClass.ismTimerRunningGetReady()) {
            stopTimerGetReady();
        }
        popFragment();
    }

    @Override
    public void showAlertDialog(View view, boolean atBottom) {
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(view);
            final AlertDialog dialog = builder.create();
            if (atBottom) dialog.getWindow().setGravity(Gravity.BOTTOM);
            dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_transparent);
            dialog.show();
        }
    }


    @Override
    public void showAlertDialog(@NonNull AlertDialog dialog) {
        if (!isFinishing()) {
            dialog.show();
        }
    }

    @Override
    public View inflateView(int res) {
        if (isFinishing()) {
            return null;
        } else {
            return getLayoutInflater().inflate(res, null);
        }
    }

    @Override
    public void showSnackMessage(final String message) {
        if (!isFinishing()) runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(findViewById(R.id.fragment_container), message, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void showSnackMessage(final int stringResId) {
        if (!isFinishing()) runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(findViewById(R.id.fragment_container), getString(stringResId), Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void updateActionBarTitle(final String title) {
        if (!isFinishing()) runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mActionBarTitle.setText(title);
            }
        });
    }

    //TODO Remove all mistypes
    @Override
    public void goneIconBacktActionBar() {
        mImageViewBackActionBar.setVisibility(View.GONE);
    }

    @Override
    public void goneIconAbouttActionBar() {
        mImageViewAboutActionBar.setVisibility(View.GONE);
    }

    @Override
    public void visibleIconBacktActionBar() {
        mImageViewBackActionBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void visibleIconAboutActionBar() {
        mImageViewAboutActionBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void visibilityIconHomeActionBar() {
        mImageHomeActionBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void visibilityIconInfoActionBar() {
        mImageViewInfo.setVisibility(View.VISIBLE);
    }

    @Override
    public void visibilityIconShareActionBar() {
        mImageViewShare.setVisibility(View.VISIBLE);
    }

    @Override
    public void visibilityIconBackGetReadyActionBar() {
        mImageViewBackActionBarGetReady.setVisibility(View.VISIBLE);
    }

    @Override
    public void goneIconHomeActionBar() {
        mImageHomeActionBar.setVisibility(View.GONE);
    }

    @Override
    public void goneIconInfoActionBar() {
        mImageViewInfo.setVisibility(View.GONE);
    }

    @Override
    public void goneIconShareActionBar() {
        mImageViewShare.setVisibility(View.GONE);
    }

    @Override
    public void goneIconBackGetReadyActionBar() {
        mImageViewBackActionBarGetReady.setVisibility(View.GONE);
    }

    @Override
    public void startTimerGetReady(TextView textView, FragmentManager fragmentManager) {
        timerClass.setmTimerRunningGetReady(true);
        timerClass.startTimerGetReady(textView, fragmentManager);
    }

    @Override
    public void stopTimerGetReady() {
        timerClass.setmTimerRunningGetReady(false);
        timerClass.pauseTimerGetReady();
    }

    @Override
    public void startTimerExerciseDo(TextView textViewTime,
                                     ProgressBar progressBarExersice, FragmentManager fragmentManager) {
        timerClass.setmTimerRunningExercise(true);
        timerClass.startTimerExercise(20000, textViewTime, progressBarExersice, fragmentManager);
    }

    public void startStopTimerExerciseDo(TextView textViewTime,
                                         ProgressBar progressBarExersice, FragmentManager fragmentManager) {
        timerClass.setmTimerRunningExercise(true);
        timerClass.startStopTimerExercise(textViewTime, progressBarExersice, fragmentManager);
    }

    @Override
    public void stopTimerExerciseDo() {
        timerClass.setmTimerRunningExercise(false);
        timerClass.pauseTimerExercise();
    }

    @Override
    public void btnPlayPause(int timerValue, TextView textViewTime,
                             ProgressBar progressBarExersice, FragmentManager fragmentManager) {

        if (timerClass.ismTimerRunningExercise()) {
            timerClass.setmTimerRunningExercise(false);
            stopTimerExerciseDo();
        } else {
            timerClass.setmTimerRunningExercise(true);
            startStopTimerExerciseDo(textViewTime, progressBarExersice, fragmentManager);
        }
    }

    @Override
    public void btnBackPressed() {
        onBackPressed();
    }

}
