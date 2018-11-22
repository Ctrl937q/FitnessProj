package com.example.tituh.fitnessproj.ui.fragments.nutrition;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.model.SevenDayMealPlanModel;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;

public class SevenDayMealPlanFragment extends BaseFragment {

    ArrayList<String> mEatList;
    ArrayList<String> mDayList;
    ArrayList<String> fromSharedPref;
    SevenDayMealPlanModel sevenDayMealPlanModel;
    //ArrayList<String> arrayTitle;
    int countEat = 0;
    SharedPreferences sharedPref;
    int countDay = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.seven_day_meal_plan_fragment, container, false);
        ((MainActivity) getActivity()).goneIconAbouttActionBar();
        ((MainActivity) getActivity()).visibleIconBacktActionBar();
        ((MainActivity) getActivity()).updateActionBarTitle("PLAN");
        sevenDayMealPlanModel = new SevenDayMealPlanModel();

        mEatList = new ArrayList<>();
        mDayList = new ArrayList<>();
        fromSharedPref = new ArrayList<>();

        mEatList.add("Breakfast");
        mEatList.add("Snack");
        mEatList.add("Lunch");
        mEatList.add("Snack2");
        mEatList.add("Dinner");


        mDayList.add("Monday");
        mDayList.add("Tuesday");
        mDayList.add("Wednesday");
        mDayList.add("Thursday");
        mDayList.add("Friday");
        mDayList.add("Saturday");
        mDayList.add("Sunday");

        final TextView mTextViewEating = rootView.findViewById(R.id.text_eating);
        final TextView mTextViewWeekDay = rootView.findViewById(R.id.text_week_day);

        ImageView mLeftTopArrow = rootView.findViewById(R.id.arrow_left_eating);
        ImageView mRightTopArrow = rootView.findViewById(R.id.arrow_right_eating);
        ImageView mLeftBotArrow = rootView.findViewById(R.id.arrow_left_week_day);
        ImageView mRightBotArrow = rootView.findViewById(R.id.arrow_right_week_day);

        final EditText mEditTextFirst = rootView.findViewById(R.id.edit_text_first);
        final EditText mEditTextSecond = rootView.findViewById(R.id.edit_text_second);
        final EditText mEditTextThird = rootView.findViewById(R.id.edit_text_third);

        mTextViewEating.setText(mEatList.get(0));
        mTextViewWeekDay.setText(mDayList.get(0));

        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        fromSharedPref = (ArrayList<String>) SharedPreferencesUtil.pullStringList(sharedPref,
                mTextViewEating.getText().toString() + mTextViewWeekDay.getText().toString());

        if (fromSharedPref.size() == 0) {
            fromSharedPref.add("");
            fromSharedPref.add("");
            fromSharedPref.add("");
        }

        Log.d("dss121sa", "size : " + fromSharedPref.size());

        mEditTextFirst.setText(fromSharedPref.get(0));
        mEditTextSecond.setText(fromSharedPref.get(1));
        mEditTextThird.setText(fromSharedPref.get(2));


        mEditTextFirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                fromSharedPref.set(0, "" + charSequence.toString());
                SharedPreferencesUtil.pushStringList(sharedPref, fromSharedPref,
                        mTextViewEating.getText().toString() + mTextViewWeekDay.getText().toString());
                Log.d("asdszxz", "onTextChangedFirst" + fromSharedPref.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });


        mEditTextSecond.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                fromSharedPref.set(1, "" + charSequence.toString());
                SharedPreferencesUtil.pushStringList(sharedPref, fromSharedPref,
                        mTextViewEating.getText().toString() + mTextViewWeekDay.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        mEditTextThird.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                fromSharedPref.set(2, "" + editable.toString());
                SharedPreferencesUtil.pushStringList(sharedPref, fromSharedPref,
                        mTextViewEating.getText().toString() + mTextViewWeekDay.getText().toString());
            }
        });


        mRightTopArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                countEat++;
                if (countEat >= 3) {
                    countEat = 0;
                }
                mTextViewEating.setText("" + mEatList.get(countEat));
            }
        });

        mLeftTopArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countEat--;
                if (countEat < 0) {
                    countEat = 2;
                }
                mTextViewEating.setText("" + mEatList.get(countEat));
            }
        });

        mRightBotArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                countDay++;
                if (countDay >= 7) {
                    countDay = 0;
                }
                mTextViewWeekDay.setText("" + mDayList.get(countDay));

            }
        });


        mLeftBotArrow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                countDay--;
                if (countDay < 0) {
                    countDay = 6;
                }
                mTextViewWeekDay.setText("" + mDayList.get(countDay));

            }
        });


        return rootView;
    }
}
