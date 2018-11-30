package com.example.tituh.fitnessproj.model.retrofitmodel.training;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("workouts")
    @Expose
    private List<Workout> workouts = null;
    @SerializedName("equipment")
    @Expose
    private List<Equipment> equipment = null;
    @SerializedName("days")
    @Expose
    private List<String> days = null;
    @SerializedName("weeks")
    @Expose
    private List<String> weeks = null;
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("date_edited")
    @Expose
    private String dateEdited;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("complexity")
    @Expose
    private int complexity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public List<String> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<String> weeks) {
        this.weeks = weeks;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateEdited() {
        return dateEdited;
    }

    public void setDateEdited(String dateEdited) {
        this.dateEdited = dateEdited;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

}