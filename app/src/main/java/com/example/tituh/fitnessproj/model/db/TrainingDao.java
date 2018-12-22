package com.example.tituh.fitnessproj.model.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import java.util.List;

@Dao
public interface TrainingDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addTraining(TrainingEntity trainingEntity);

    @Query("DELETE FROM TrainingEntity WHERE week =:week AND complexity =:complexity")
    void resetByWeek(String week, String complexity);

    @Query("DELETE FROM TrainingEntity WHERE complexity =:complexity")
    void resetByComplexity(String complexity);

    @Query("SELECT * FROM TrainingEntity WHERE week =:week AND complexity =:complexity")
    List<TrainingEntity> getTrainingsByWeek(String week, String complexity);

    @Query("SELECT * FROM TrainingEntity WHERE complexity =:complexity")
    List<TrainingEntity> getTrainingsByComplexity(String complexity);
}
