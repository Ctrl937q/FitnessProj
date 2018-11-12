package com.example.tituh.fitnessproj.model;

public class FitnessStartModel {

    public static final int ONE_TYPE = 1;
    public static final int TWO_TYPE = 2;
    private String mHeadline1;
    private String mTextButton;
    private int[]drawableassive;

    private int type;

    public FitnessStartModel(String headline_1,String mTextButton, int type, int[]drawableassive) {
        this.drawableassive = drawableassive;
        this.mHeadline1 = headline_1;
        this.mTextButton = mTextButton;
        this.type = type;
    }

    public FitnessStartModel(String mHeadline1, int type) {
        this.mHeadline1 = mHeadline1;
        this.type = type;
    }

    public String getmTextButton() {
        return mTextButton;
    }

    public void setmTextButton(String mTextButton) {
        this.mTextButton = mTextButton;
    }

    public String getHeadline_1() {
        return mHeadline1;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int[] getDrawableassive() {
        return drawableassive;
    }

    public void setDrawableassive(int[] drawableassive) {
        this.drawableassive = drawableassive;
    }
}
