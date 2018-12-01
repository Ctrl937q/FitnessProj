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

    private ArrayList<String> mEatList;
    private ArrayList<String> mDayList;
    private ArrayList<String> mFromSharedPref;
    private SevenDayMealPlanModel mSevenDayMealPlanModel;
    private int mCountEat = 0;
    private SharedPreferences mSharedPref;
    private int mCountDay = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.seven_day_meal_plan_fragment, container, false);
            ((MainActivity) getActivity()).goneIconAbouttActionBar();
            ((MainActivity) getActivity()).visibleIconBacktActionBar();
            ((MainActivity) getActivity()).updateActionBarTitle("PLAN");
            mSevenDayMealPlanModel = new SevenDayMealPlanModel();

            mEatList = new ArrayList<>();
            mDayList = new ArrayList<>();
            mFromSharedPref = new ArrayList<>();

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

            final TextView mTextViewEating = view.findViewById(R.id.text_eating);
            final TextView mTextViewWeekDay = view.findViewById(R.id.text_week_day);

            ImageView mLeftTopArrow = view.findViewById(R.id.arrow_left_eating);
            ImageView mRightTopArrow = view.findViewById(R.id.arrow_right_eating);
            ImageView mLeftBotArrow = view.findViewById(R.id.arrow_left_week_day);
            ImageView mRightBotArrow = view.findViewById(R.id.arrow_right_week_day);

            final EditText mEditTextFirst = view.findViewById(R.id.edit_text_first);
            final EditText mEditTextSecond = view.findViewById(R.id.edit_text_second);
            final EditText mEditTextThird = view.findViewById(R.id.edit_text_third);

            mTextViewEating.setText(mEatList.get(0));
            mTextViewWeekDay.setText(mDayList.get(0));

            mSharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
            mFromSharedPref = (ArrayList<String>) SharedPreferencesUtil.pullStringList(mSharedPref,
                    mTextViewEating.getText().toString() + mTextViewWeekDay.getText().toString());

            if (mFromSharedPref.size() == 0) {
                mFromSharedPref.add("");
                mFromSharedPref.add("");
                mFromSharedPref.add("");
            }

            Log.d("dss121sa", "size : " + mFromSharedPref.size());

            mEditTextFirst.setText(mFromSharedPref.get(0));
            mEditTextSecond.setText(mFromSharedPref.get(1));
            mEditTextThird.setText(mFromSharedPref.get(2));


            mEditTextFirst.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    mFromSharedPref.set(0, "" + charSequence.toString());
                    SharedPreferencesUtil.pushStringList(mSharedPref, mFromSharedPref,
                            mTextViewEating.getText().toString() + mTextViewWeekDay.getText().toString());
                    Log.d("asdszxz", "onTextChangedFirst" + mFromSharedPref.toString());
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
                    mFromSharedPref.set(1, "" + charSequence.toString());
                    SharedPreferencesUtil.pushStringList(mSharedPref, mFromSharedPref,
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
                    mFromSharedPref.set(2, "" + editable.toString());
                    SharedPreferencesUtil.pushStringList(mSharedPref, mFromSharedPref,
                            mTextViewEating.getText().toString() + mTextViewWeekDay.getText().toString());
                }
            });


            mRightTopArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mCountEat++;
                    if (mCountEat >= 3) {
                        mCountEat = 0;
                    }
                    mTextViewEating.setText("" + mEatList.get(mCountEat));
                }
            });

            mLeftTopArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCountEat--;
                    if (mCountEat < 0) {
                        mCountEat = 2;
                    }
                    mTextViewEating.setText("" + mEatList.get(mCountEat));
                }
            });

            mRightBotArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mCountDay++;
                    if (mCountDay >= 7) {
                        mCountDay = 0;
                    }
                    mTextViewWeekDay.setText("" + mDayList.get(mCountDay));

                }
            });


            mLeftBotArrow.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    mCountDay--;
                    if (mCountDay < 0) {
                        mCountDay = 6;
                    }
                    mTextViewWeekDay.setText("" + mDayList.get(mCountDay));
                }
            });
        }
        return view;
    }
}
