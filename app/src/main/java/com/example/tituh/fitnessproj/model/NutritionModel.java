package com.example.tituh.fitnessproj.model;

public class NutritionModel {

    public static final int ONE_TYPE = 1;
    public static final int TWO_TYPE = 2;
    private String mTitleText;
    private String mButtonText;
    private int type;
    private int drawable;


    public NutritionModel(String mTitleText, String mButtonText, int type) {
        this.mTitleText = mTitleText;
        this.mButtonText = mButtonText;
        this.type = type;
    }

    public NutritionModel(String mTitleText, int type, int drawable) {
        this.drawable = drawable;
        this.mTitleText = mTitleText;
        this.type = type;

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
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}
