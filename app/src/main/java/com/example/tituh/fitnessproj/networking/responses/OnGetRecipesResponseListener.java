package com.example.tituh.fitnessproj.networking.responses;

import android.support.annotation.Nullable;

import com.example.tituh.fitnessproj.networking.responses.recipes.RecipesResponse;

public interface OnGetRecipesResponseListener {

    void onGetRecipesResponse(@Nullable String message, boolean success, @Nullable RecipesResponse recipesResponse);

}
