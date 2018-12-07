package com.example.tituh.fitnessproj.networking.responses;

import android.support.annotation.Nullable;

public interface OnGetTrainingResponseListener {

    void onGetTrainingsResponse(@Nullable String message, boolean success,@Nullable TrainingResponse trainingResponse);

}
