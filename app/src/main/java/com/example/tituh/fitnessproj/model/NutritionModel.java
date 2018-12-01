package com.example.tituh.fitnessproj.model;

public class NutritionModel {

    public static final int ONE_TYPE = 1;
    public static final int TWO_TYPE = 2;
    private String mTitleText;
    private String mButtonText;
    private int mType;
    private int mDrawable;


    public NutritionModel(String mTitleText, String mButtonText, int type) {
        this.mTitleText = mTitleText;
        this.mButtonText = mButtonText;
        this.mType = type;
    }

    public NutritionModel(String mTitleText, int type, int drawable) {
        this.mDrawable = drawable;
        this.mTitleText = mTitleText;
        this.mType = type;

    }

    public static int getOneType() {
        return ONE_TYPE;
    }

    public static int getTwoType() {
        return TWO_TYPE;
    }

    public String getmTitleText() {
        return mTitleText;
    }

    public void setmTitleText(String mTitleText) {
        this.mTitleText = mTitleText;
    }

    public String getmButtonText() {
        return mButtonText;
    }

    public void setmButtonText(String mButtonText) {
        this.mButtonText = mButtonText;
    }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        this.mType = type;
    }

    public int getDrawable() {
        return mDrawable;
    }

    public void setDrawable(int drawable) {
        this.mDrawable = drawable;
    }
}
