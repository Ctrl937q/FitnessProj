package com.example.tituh.fitnessproj.networking;

import com.example.tituh.fitnessproj.networking.responses.TrainingResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRestInterface {


    @GET("/api/v1/trainings/")
    Call<TrainingResponse> getTrainigs();
}
