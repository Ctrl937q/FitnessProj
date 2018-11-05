package com.example.tituh.fitnessproj.model;

public class DayWorkoutModel {

    private String mHeader1;
    private String mHeader2;


    public DayWorkoutModel(String mHeader1, String mHeader2) {
        this.mHeader1 = mHeader1;
        this.mHeader2 = mHeader2;
    }

    public String getmHeader1() {
        return mHeader1;
    }

    public void setmHeader1(String mHeader1) {
        this.mHeader1 = mHeader1;
    }

    public String getmHeader2() {
        return mHeader2;
    }

    public void setmHeader2(String mHeader2) {
        this.mHeader2 = mHeader2;
    }
}
