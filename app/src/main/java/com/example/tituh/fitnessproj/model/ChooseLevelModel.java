package com.example.tituh.fitnessproj.model;


public class ChooseLevelModel {

    int imageInt;
    String title;


    public ChooseLevelModel(int imageInt, String title) {
        this.imageInt = imageInt;
        this.title = title;
    }

    public int getImageInt() {
        return imageInt;
    }

    public void setImageInt(int imageInt) {
        this.imageInt = imageInt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
