package com.example.tituh.fitnessproj.model;

public class WellnessModel {

    public static final int ONE_TYPE = 1;
    public static final int TWO_TYPE = 2;
    private String mTitleText;
    private String mButtonText;
    private int mType;
    private int mDrawable;

    public WellnessModel(String mTitleText, String mButtonText, int type) {
        this.mTitleText = mTitleText;
        this.mButtonText = mButtonText;
        this.mType = type;
    }

    public WellnessModel(String mTitleText, int type, int drawable) {
        this.mDrawable = drawable;
        this.mTitleText = mTitleText;
        this.mType = type;

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

    public int getDrawableMassive() {
        return mDrawable;
    }

    public void setDrawableMassive(int drawableMassive) {
        this.mDrawable = mDrawable;
    }
}
