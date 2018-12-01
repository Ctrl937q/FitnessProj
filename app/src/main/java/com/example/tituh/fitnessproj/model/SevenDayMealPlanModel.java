package com.example.tituh.fitnessproj.model;

import java.util.ArrayList;

public class SevenDayMealPlanModel {

    private ArrayList<String> mMondayBreakfast = new ArrayList<>();
    private ArrayList<String> mTuesdaySnack = new ArrayList<>();

    public ArrayList<String> getMondayBreakfast() {
        return mMondayBreakfast;
    }

    public void setMondayBreakfast(ArrayList<String> mondayBreakfast) {
        this.mMondayBreakfast = mondayBreakfast;
    }

    public ArrayList<String> getTuesdaySnack() {
        return mTuesdaySnack;
    }

    public void setTuesdaySnack(ArrayList<String> tuesdaySnack) {
        this.mTuesdaySnack = tuesdaySnack;
    }
}
