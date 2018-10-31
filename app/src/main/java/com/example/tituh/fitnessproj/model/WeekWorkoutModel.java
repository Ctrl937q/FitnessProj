package com.example.tituh.fitnessproj.model;

public class WeekWorkoutModel {

    String header_1;
    String header_2;

    public WeekWorkoutModel(String header_1, String header_2) {
        this.header_1 = header_1;
        this.header_2 = header_2;
    }

    public WeekWorkoutModel(String header_1) {
        this.header_1 = header_1;
    }

    public String getHeader_1() {
        return header_1;
    }

    public void setHeader_1(String header_1) {
        this.header_1 = header_1;
    }

    public String getHeader_2() {
        return header_2;
    }

    public void setHeader_2(String header_2) {
        this.header_2 = header_2;
    }
}
