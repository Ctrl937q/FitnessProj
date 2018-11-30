package com.example.tituh.fitnessproj.model.retrofitmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repetitions {

    @SerializedName("advanced")
    @Expose
    private int advanced;
    @SerializedName("beginner")
    @Expose
    private int beginner;
    @SerializedName("intermediate")
    @Expose
    private int intermediate;

    public int getAdvanced() {
        return advanced;
    }

    public void setAdvanced(int advanced) {
        this.advanced = advanced;
    }

    public int getBeginner() {
        return beginner;
    }

    public void setBeginner(int beginner) {
        this.beginner = beginner;
    }

    public int getIntermediate() {
        return intermediate;
    }

    public void setIntermediate(int intermediate) {
        this.intermediate = intermediate;
    }

}
