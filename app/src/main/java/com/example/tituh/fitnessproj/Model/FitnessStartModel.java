package com.example.tituh.fitnessproj.Model;

public class FitnessStartModel {

    public static final int ONE_TYPE = 1;
    public static final int TWO_TYPE = 2;
    private String headline1;
    private String headline2;
    int type;

    public FitnessStartModel(String headline_1, String headline_2, int type) {
        this.headline1 = headline_1;
        this.headline2 = headline_2;
        this.type = type;
    }

    public FitnessStartModel(String headline_1, int type) {
        this.headline1 = headline_1;
        this.type = type;
    }

    public String getHeadline_1() {
        return headline1;
    }

    public void setHeadline_1(String headline_1) {
        this.headline1 = headline_1;
    }

    public String getHeadline_2() {
        return headline2;
    }

    public void setHeadline_2(String headline_2) {
        this.headline2 = headline_2;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
