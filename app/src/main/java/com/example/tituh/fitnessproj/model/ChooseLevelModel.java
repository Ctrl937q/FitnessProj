package com.example.tituh.fitnessproj.model;


public class ChooseLevelModel {

    private int mImageInt;
    private String mTitle;

    public ChooseLevelModel(int imageInt, String title) {
        this.mImageInt = imageInt;
        this.mTitle = title;
    }

    public int getImageInt() {
        return mImageInt;
    }

    public void setImageInt(int imageInt) {
        this.mImageInt = imageInt;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }
}
