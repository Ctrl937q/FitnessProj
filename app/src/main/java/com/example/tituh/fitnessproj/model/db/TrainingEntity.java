package com.example.tituh.fitnessproj.model.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class TrainingEntity {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "complexity")
    private String complexity;

    @ColumnInfo(name = "repetition_count")
    private int repetitionCount;

    @ColumnInfo(name = "week")
    private String week;

    public TrainingEntity(String complexity, int repetitionCount, String week, int id) {
        this.complexity = complexity;
        this.repetitionCount = repetitionCount;
        this.week = week;
        this.id = id;
    }

    public String getComplexity() {
        return complexity;
    }

    public int getRepetitionCount() {
        return repetitionCount;
    }

    public String getWeek() {
        return week;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    public void setRepetitionCount(int repetitionCount) {
        this.repetitionCount = repetitionCount;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "TrainingEntity{" +
                "id=" + id +
                ", complexity='" + complexity + '\'' +
                ", repetitionCount=" + repetitionCount +
                ", week='" + week + '\'' +
                '}';
    }
}
