package com.example.tituh.fitnessproj.networking.responses;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.tituh.fitnessproj.networking.responses.recipes.ResultsItem;

import java.util.List;

public interface OnGetRecipesResponseListener {

    void onGetRecipesResponse(@Nullable String message, boolean success, @NonNull List<ResultsItem> resultsItems);

}