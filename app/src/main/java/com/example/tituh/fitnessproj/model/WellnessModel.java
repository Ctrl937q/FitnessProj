package com.example.tituh.fitnessproj.model;

public class WellnessModel {

    public static final int ONE_TYPE = 1;
    public static final int TWO_TYPE = 2;
    private String mTitleText;
    private String mButtonText;
    private int type;
    private int drawable;

    public WellnessModel(String mTitleText, String mButtonText, int type) {
        this.mTitleText = mTitleText;
        this.mButtonText = mButtonText;
        this.type = type;
    }

    public WellnessModel(String mTitleText, int type, int drawable) {
        this.drawable = drawable;
        this.mTitleText = mTitleText;
        this.type = type;

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

    public int getDrawableMassive() {
        return drawable;
    }

    public void setDrawableMassive(int drawableMassive) {
        this.drawable = drawable;
    }
}
