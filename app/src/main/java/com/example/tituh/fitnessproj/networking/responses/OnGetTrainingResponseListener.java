package com.example.tituh.fitnessproj.networking.responses;

import android.support.annotation.Nullable;

import com.example.tituh.fitnessproj.networking.responses.training.TrainingResponse;

public interface OnGetTrainingResponseListener {

    void onGetTrainingsResponse(@Nullable String message, boolean success,@Nullable TrainingResponse trainingResponse);

}
