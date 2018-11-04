package com.example.tituh.fitnessproj.ui.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.activities.TimerClass;
import java.util.Timer;
import java.util.TimerTask;
import mehdi.sakout.fancybuttons.FancyButton;

public class DialogFragmentExersice extends Dialog {

    private FancyButton skip;
    private TextView textViewTest;
    TimerClass timerClass;

    public DialogFragmentExersice(Activity activity) {
        super(activity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_layout);
        skip = (FancyButton) findViewById(R.id.btn_skip_workout);
        textViewTest = (TextView)findViewById(R.id.text_view_seconds_left);
        timerClass = new TimerClass();
        timerClass.startTimerDialog(textViewTest);
        setCancelable(false);
        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                dismiss();
                t.cancel();
            }
        }, 10000);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}