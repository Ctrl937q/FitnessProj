package com.example.tituh.fitnessproj.model.db;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import com.example.tituh.fitnessproj.networking.threads.ExecutorsPool;

import java.util.List;

public class TrainingRepository {
    public static final String [] COMPLEXITY_ARR = {"beginner", "middle", "advanced"};

    private String DB_NAME = "db_training";

    private TrainingDatabase noteDatabase;

    public TrainingRepository(Context context) {
        noteDatabase = Room.databaseBuilder(context, TrainingDatabase.class, DB_NAME).build();
    }

    public void addTraining(String week, String complexity, int repsCount) {
        Log.v("Add Training", week + " " + complexity + " "+ repsCount);
        noteDatabase.trainingDao().addTraining(new TrainingEntity(complexity,repsCount, week));
    }

    private int getWeekProgress(String week, String complexity) {
        List<TrainingEntity> doneTrainings = noteDatabase.trainingDao().getTrainingsByWeek(week, complexity);
        if (doneTrainings.isEmpty()) return 0;
        return doneTrainings.size() * 100 / 3;
    }

    public void getWeekProgress(final String week, final String complexity, final GetWeekProgressListener listener) {
        ExecutorsPool.runCommonBgTask(new Runnable() {
            @Override
            public void run() {
                int complexityRes = getWeekProgress(week, complexity);
                listener.onGetWeekProgress(complexityRes);
            }
        });
    }

    private int getComplexityProgress(String complexity) {
        List<TrainingEntity> doneTrainings = noteDatabase.trainingDao().getTrainingsByComplexity(complexity);
        if (doneTrainings.isEmpty()) return 0;
        int repsCount = doneTrainings.get(0).getRepetitionCount();
        return doneTrainings.size() * 100 / repsCount;
    }

    public void getComplexityProgress(final GetComplexityProgressListener listener) {
        ExecutorsPool.runCommonBgTask(new Runnable() {
            @Override
            public void run() {

                int beginnerProgress = getComplexityProgress(TrainingRepository.COMPLEXITY_ARR[0]);
                int intermediateProgress = getComplexityProgress(TrainingRepository.COMPLEXITY_ARR[1]);
                int advancedProgress = getComplexityProgress(TrainingRepository.COMPLEXITY_ARR[2]);

                int [] complexities = {beginnerProgress, intermediateProgress, advancedProgress};
                listener.onGetComplexityProgress(complexities);
            }
        });
    }

    public void resetByWeek(String week, String complexity) {
        noteDatabase.trainingDao().resetByWeek(week, complexity);
    }

    public void resetByComplexity(String complexity){
        noteDatabase.trainingDao().resetByComplexity(complexity);
    };
}
