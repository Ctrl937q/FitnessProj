package com.example.tituh.fitnessproj.ui.activities;

import android.content.Context;
import android.net.ConnectivityManager;
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
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;
import com.example.tituh.fitnessproj.ui.fragments.MainTabLayoutFragment;
import com.example.tituh.fitnessproj.ui.interfaces.OnFragmentInteractionListener;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    private TextView mActionBarTitle;
    private ImageView mImageViewBackActionBar;
    private ImageView mImageViewAboutActionBar;
    private ImageView mImageHomeActionBar;
    private ImageView mImageViewInfo;
    private ImageView mImageViewShare;
    private ImageView mImageViewBackActionBarGetReady;
    private boolean pressOnExersiceDoFragment = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
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

        mImageViewBackActionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popFragment();
            }
        });

        mImageHomeActionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popFragment();
                popFragment();
                popFragment();
                pressOnExersiceDoFragment = false;
            }
        });
        pushFragment(new MainTabLayoutFragment(), false);
    }


    @Override
    public void pushFragment(BaseFragment fragment, boolean shouldAddToBackstack) {
        if (!isFinishing()) {
            String tag = String.format("%s:%s", fragment.getBackStackTag(), String.valueOf(System.currentTimeMillis()));
            //Log.v(tag, tag);
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
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
            ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
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
        if (pressOnExersiceDoFragment) {
            popFragment();
            popFragment();
            popFragment();
            pressOnExersiceDoFragment = false;
        } else {
            popFragment();
        }

    }

    @Override
    public void showAlertDialog(View view, boolean atBottom) {
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(view);
            final AlertDialog dialog = builder.create();
            if (atBottom)
                if (dialog.getWindow() != null) dialog.getWindow().setGravity(Gravity.BOTTOM);
            if (dialog.getWindow() != null)
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
    public boolean isInternetConnection() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            if (cm.getActiveNetwork() != null) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean isInternetConnectionSnackBar(View view) {
        final ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null && cm.getActiveNetwork() != null) {
            return true;
        } else {
            final Snackbar snackbar = Snackbar.make(view, "No Internet Connection", Snackbar.LENGTH_LONG);
            final Snackbar snackbar2 = Snackbar.make(view, "Internet Connection Restored", Snackbar.LENGTH_LONG);
            snackbar.setAction("Retry", new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    if (cm != null && cm.getActiveNetwork() == null) {
                        new CountDownTimer(1500, 500) {
                            @Override
                            public void onTick(long l) {
                                if (cm.getActiveNetwork() != null) {
                                    snackbar2.show();

                                }
                            }

                            @Override
                            public void onFinish() {
                                if (cm.getActiveNetwork() == null) {
                                    snackbar.show();
                                }
                                cancel();
                            }
                        }.start();

                    } else {
                        snackbar2.show();

                    }
                }
            });
            snackbar.show();
            return false;
        }
    }

    @Override
    public boolean getPressOnExersiceDoFragment() {
        return pressOnExersiceDoFragment;
    }

    @Override
    public void setPressOnExersiceDoFragment(boolean value) {
        pressOnExersiceDoFragment = value;
    }

    @Override
    public ImageView getInfoButton() {
        return mImageViewInfo;
    }

    @Override
    public ImageView getmImageViewAboutActionBar() {
        return mImageViewAboutActionBar;
    }
}
