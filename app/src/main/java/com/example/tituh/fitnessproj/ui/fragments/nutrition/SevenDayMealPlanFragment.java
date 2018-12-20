package com.example.tituh.fitnessproj.ui.fragments.nutrition;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;

public class SevenDayMealPlanFragment extends BaseFragment {

    private ArrayList<String> mEatList;
    private ArrayList<String> mDayList;
    private int mCountEat = 0;
    private SharedPreferences mSharedPref;
    private int mCountDay = 0;
    private String mTextFromEditTextFirst = "";
    private String mTextFromEditTextSecond = "";
    private String mTextFromEditTextThird = "";
    private EditText mEditTextFirst;
    private EditText mEditTextSecond;
    private EditText mEditTextThird;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.seven_day_meal_plan_fragment, container, false);
            fragmentInteractionListener.goneIconAbouttActionBar();
            fragmentInteractionListener.visibleIconBacktActionBar();
            fragmentInteractionListener.updateActionBarTitle("PLAN");
            mEatList = new ArrayList<>();
            mDayList = new ArrayList<>();
            mEatList.add("Breakfast");
            mEatList.add("Snack");
            mEatList.add("Lunch");
            mEatList.add("Snack");
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

            mEditTextFirst = view.findViewById(R.id.edit_text_first);
            mEditTextSecond = view.findViewById(R.id.edit_text_second);
            mEditTextThird = view.findViewById(R.id.edit_text_third);

            mTextViewEating.setText(mEatList.get(0));
            mTextViewWeekDay.setText(mDayList.get(0));

            mSharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);

            mEditTextFirst.setText(pullFromSharedPreference(mCountEat + mCountDay).get(0));
            mEditTextSecond.setText(pullFromSharedPreference(mCountEat + mCountDay).get(1));
            mEditTextThird.setText(pullFromSharedPreference(mCountEat + mCountDay).get(2));

            mRightTopArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mTextFromEditTextFirst = mEditTextFirst.getText().toString();
                    mTextFromEditTextSecond = mEditTextSecond.getText().toString();
                    mTextFromEditTextThird = mEditTextThird.getText().toString();
                    pushToSharedPreference(mTextFromEditTextFirst, mTextFromEditTextSecond,
                            mTextFromEditTextThird, mCountEat + mCountDay);
                    mCountEat++;
                    if (mCountEat >= 5) {
                        mCountEat = 0;
                    }
                    mTextViewEating.setText("" + mEatList.get(mCountEat));
                    mEditTextFirst.setText(pullFromSharedPreference(mCountEat + mCountDay).get(0));
                    mEditTextSecond.setText(pullFromSharedPreference(mCountEat + mCountDay).get(1));
                    mEditTextThird.setText(pullFromSharedPreference(mCountEat + mCountDay).get(2));
                }
            });

            mLeftTopArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mTextFromEditTextFirst = mEditTextFirst.getText().toString();
                    mTextFromEditTextSecond = mEditTextSecond.getText().toString();
                    mTextFromEditTextThird = mEditTextThird.getText().toString();
                    pushToSharedPreference(mTextFromEditTextFirst, mTextFromEditTextSecond,
                            mTextFromEditTextThird, mCountEat + mCountDay);
                    mCountEat--;
                    if (mCountEat < 0) {
                        mCountEat = 4;
                    }

                    mTextViewEating.setText("" + mEatList.get(mCountEat));
                    mEditTextFirst.setText(pullFromSharedPreference(mCountEat + mCountDay).get(0));
                    mEditTextSecond.setText(pullFromSharedPreference(mCountEat + mCountDay).get(1));
                    mEditTextThird.setText(pullFromSharedPreference(mCountEat + mCountDay).get(2));


                }
            });

            mRightBotArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mTextFromEditTextFirst = mEditTextFirst.getText().toString();
                    mTextFromEditTextSecond = mEditTextSecond.getText().toString();
                    mTextFromEditTextThird = mEditTextThird.getText().toString();
                    pushToSharedPreference(mTextFromEditTextFirst, mTextFromEditTextSecond,
                            mTextFromEditTextThird, mCountEat + mCountDay);
                    mCountDay++;
                    if (mCountDay >= 7) {
                        mCountDay = 0;
                    }
                    mTextViewWeekDay.setText("" + mDayList.get(mCountDay));
                    mEditTextFirst.setText(pullFromSharedPreference(mCountEat + mCountDay).get(0));
                    mEditTextSecond.setText(pullFromSharedPreference(mCountEat + mCountDay).get(1));
                    mEditTextThird.setText(pullFromSharedPreference(mCountEat + mCountDay).get(2));
                }
            });

            mLeftBotArrow.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    mTextFromEditTextFirst = mEditTextFirst.getText().toString();
                    mTextFromEditTextSecond = mEditTextSecond.getText().toString();
                    mTextFromEditTextThird = mEditTextThird.getText().toString();
                    pushToSharedPreference(mTextFromEditTextFirst, mTextFromEditTextSecond,
                            mTextFromEditTextThird, mCountEat + mCountDay);
                    mCountDay--;
                    if (mCountDay < 0) {
                        mCountDay = 6;
                    }

                    mTextViewWeekDay.setText("" + mDayList.get(mCountDay));
                    mEditTextFirst.setText(pullFromSharedPreference(mCountEat + mCountDay).get(0));
                    mEditTextSecond.setText(pullFromSharedPreference(mCountEat + mCountDay).get(1));
                    mEditTextThird.setText(pullFromSharedPreference(mCountEat + mCountDay).get(2));
                }
            });
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        fragmentInteractionListener.updateActionBarTitle("NUTRITION");
        super.onDestroyView();
    }

    @Override
    public void onPause() {
        pushToSharedPreference(mEditTextFirst.getText().toString(), mEditTextSecond.getText().toString(),
                mEditTextThird.getText().toString(), mCountEat + mCountDay);
        super.onPause();
    }

    public void pushToSharedPreference(String fromFirstET, String fromSecondET, String fromThirdED, int key) {
        ArrayList<String> toSharedPrefArray = new ArrayList<>();
        toSharedPrefArray.add(0, fromFirstET);
        toSharedPrefArray.add(1, fromSecondET);
        toSharedPrefArray.add(2, fromThirdED);
        SharedPreferencesUtil.pushStringList(mSharedPref, toSharedPrefArray, "" + key);
        mEditTextFirst.clearFocus();
        mEditTextSecond.clearFocus();
        mEditTextThird.clearFocus();
        if (view != null && getActivity() != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    public ArrayList<String> pullFromSharedPreference(int key) {
        ArrayList<String> fromSharedPrefArray;
        fromSharedPrefArray = (ArrayList<String>) SharedPreferencesUtil.pullStringList(mSharedPref,
                "" + key);
        if (fromSharedPrefArray.size() == 0) {
            fromSharedPrefArray.add("");
            fromSharedPrefArray.add("");
            fromSharedPrefArray.add("");
            return fromSharedPrefArray;
        } else {
            return fromSharedPrefArray;
        }
    }
}
