package com.example.tituh.fitnessproj.model;


public class ChooseLevelModel {

    private int mImageInt;
    private String mTitle;
    private int progress;

    public ChooseLevelModel(int imageInt, String title,int progress) {
        this.mImageInt = imageInt;
        this.mTitle = title;
        this.progress = progress;
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

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
