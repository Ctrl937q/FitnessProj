package com.example.tituh.fitnessproj.networking;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.tituh.fitnessproj.networking.responses.OnGetRecipesResponseListener;
import com.example.tituh.fitnessproj.networking.responses.OnGetTrainingResponseListener;
import com.example.tituh.fitnessproj.networking.responses.recipes.ResultsItem;
import com.example.tituh.fitnessproj.networking.responses.training.TrainingResponse;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient implements ApiModelInterface {

    private static final String BASE_URL = "http://18.215.141.14:8000/";
    private static Retrofit retrofit;
    private ApiRestInterface mApi;
    private int page = 1;
    private boolean nextPageNull = false;
    private Call<TrainingResponse> callCalcel;

    public ApiClient() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).readTimeout(3, TimeUnit.SECONDS)
                    .connectTimeout(3, TimeUnit.SECONDS)
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        this.mApi = retrofit.create(ApiRestInterface.class);
    }

    @Override
    public void getTrainings(@Nullable final OnGetTrainingResponseListener listener) {
        mApi.getTrainigs().enqueue(new Callback<TrainingResponse>() {
            @Override
            public void onResponse(@NonNull final Call<TrainingResponse> call, @NonNull Response<TrainingResponse> response) {
                callCalcel = call;
                if (HttpURLConnection.HTTP_OK == response.code()) {
                    if (null != listener)
                        listener.onGetTrainingsResponse(null, true, response.body());


                }
            }



            @Override
            public void onFailure(@NonNull Call<TrainingResponse> call, @NonNull Throwable t) {
                if (null != listener) listener.onGetTrainingsResponse(t.getMessage(), false, null);
            }
        });


    }


    @Override
    public void getRecipes(@NonNull final OnGetRecipesResponseListener listener) {
        mApi.getRecipes().enqueue(new Callback<List<ResultsItem>>() {
            @Override
            public void onResponse(Call<List<ResultsItem>> call, Response<List<ResultsItem>> response) {
                if (HttpURLConnection.HTTP_OK == response.code()) {
                    if (null != listener)
                        listener.onGetRecipesResponse(null, true, response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ResultsItem>> call, Throwable t) {

            }
        });
    }
}
