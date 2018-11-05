package com.example.tituh.fitnessproj.ui.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.activities.TimerClass;
import com.example.tituh.fitnessproj.ui.fragments.fitness.ExersiceDoFragment;

import java.util.Timer;
import java.util.TimerTask;
import mehdi.sakout.fancybuttons.FancyButton;

public class DialogFragmentExersice extends Dialog {

    private FancyButton mButtonSkip;
    private TextView mTextViewTest;
    private TimerClass timerClass;

    public DialogFragmentExersice(Activity activity) {
        super(activity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_layout);
        mButtonSkip = (FancyButton) findViewById(R.id.btn_skip_workout);
        mTextViewTest = (TextView)findViewById(R.id.text_view_seconds_left);
        timerClass = new TimerClass();
        timerClass.startTimerDialog(mTextViewTest);
        setCancelable(false);
        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                dismiss();
                t.cancel();
            }
        }, 10000);

        mButtonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }


    public TextView getmTextViewTest() {
        return mTextViewTest;
    }
}