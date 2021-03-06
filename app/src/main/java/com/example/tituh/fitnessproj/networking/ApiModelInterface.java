package com.example.tituh.fitnessproj.networking;

import android.support.annotation.NonNull;

import com.example.tituh.fitnessproj.networking.responses.OnGetRecipesResponseListener;
import com.example.tituh.fitnessproj.networking.responses.OnGetTrainingResponseListener;

public interface ApiModelInterface {

    void getTrainings(@NonNull OnGetTrainingResponseListener onGetTrainingResponseListener);

    void getRecipes(@NonNull OnGetRecipesResponseListener onGetRecipesResponseListener);
}
