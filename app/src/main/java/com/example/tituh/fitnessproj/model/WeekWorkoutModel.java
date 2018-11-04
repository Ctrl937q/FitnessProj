package com.example.tituh.fitnessproj.model;

public class WeekWorkoutModel {

    private String mHeader1;
    private String mHeader2;

    public WeekWorkoutModel(String header1, String header2) {
        this.mHeader1 = header1;
        this.mHeader2 = header2;
    }

    public WeekWorkoutModel(String header1) {
        this.mHeader1 = header1;
    }

    public String getHeader1() {
        return mHeader1;
    }

    public void setHeader1(String header1) {
        this.mHeader1 = header1;
    }

    public String getHeader2() {
        return mHeader2;
    }

    public void setHeader2(String header2) {
        this.mHeader2 = header2;
    }
}
