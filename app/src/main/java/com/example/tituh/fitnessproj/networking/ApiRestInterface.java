package com.example.tituh.fitnessproj.networking;

import com.example.tituh.fitnessproj.networking.responses.recipes.ResultsItem;
import com.example.tituh.fitnessproj.networking.responses.training.TrainingResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRestInterface {


    @GET("/api/v1/trainings/")
    Call<TrainingResponse> getTrainigs();

    @GET("/api/v1/recipes/")
    Call<List<ResultsItem>> getRecipes();
}
