package com.example.tituh.fitnessproj.model.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {TrainingEntity.class}, version = 2, exportSchema = false)
public abstract class TrainingDatabase extends RoomDatabase {

    public abstract TrainingDao trainingDao();
}
