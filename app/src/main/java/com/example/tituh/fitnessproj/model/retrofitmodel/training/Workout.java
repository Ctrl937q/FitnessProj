package com.example.tituh.fitnessproj.model.retrofitmodel.training;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Workout {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("duration")
    @Expose
    private double duration;
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
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("repetitions")
    @Expose
    private Repetitions repetitions;
    @SerializedName("position")
    @Expose
    private int position;
    @SerializedName("type")
    @Expose
    private int type;
    @SerializedName("circuit")
    @Expose
    private int circuit;
    @SerializedName("number")
    @Expose
    private int number;
    @SerializedName("training")
    @Expose
    private int training;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Repetitions getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Repetitions repetitions) {
        this.repetitions = repetitions;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCircuit() {
        return circuit;
    }

    public void setCircuit(int circuit) {
        this.circuit = circuit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTraining() {
        return training;
    }

    public void setTraining(int training) {
        this.training = training;
    }

}