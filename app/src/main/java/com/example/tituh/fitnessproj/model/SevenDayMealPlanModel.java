package com.example.tituh.fitnessproj.model;

import java.util.ArrayList;

public class SevenDayMealPlanModel {

    ArrayList<String> mondayBreakfast = new ArrayList<>();
    ArrayList<String> tuesdaySnack = new ArrayList<>();

    public ArrayList<String> getMondayBreakfast() {
        return mondayBreakfast;
    }

    public void setMondayBreakfast(ArrayList<String> mondayBreakfast) {
        this.mondayBreakfast = mondayBreakfast;
    }

    public ArrayList<String> getTuesdaySnack() {
        return tuesdaySnack;
    }

    public void setTuesdaySnack(ArrayList<String> tuesdaySnack) {
        this.tuesdaySnack = tuesdaySnack;
    }
}
