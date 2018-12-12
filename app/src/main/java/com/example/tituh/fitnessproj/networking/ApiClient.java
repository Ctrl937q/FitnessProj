package com.example.tituh.fitnessproj.networking;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.tituh.fitnessproj.networking.responses.OnGetRecipesResponseListener;
import com.example.tituh.fitnessproj.networking.responses.OnGetTrainingResponseListener;
import com.example.tituh.fitnessproj.networking.responses.recipes.RecipesResponse;
import com.example.tituh.fitnessproj.networking.responses.training.TrainingResponse;

import java.net.HttpURLConnection;

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

    public ApiClient() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
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
            public void onResponse(@NonNull Call<TrainingResponse> call, @NonNull Response<TrainingResponse> response) {
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
        mApi.getRecipes(page).enqueue(new Callback<RecipesResponse>() {
            @Override
            public void onResponse(Call<RecipesResponse> call, Response<RecipesResponse> response) {
                if (HttpURLConnection.HTTP_OK == response.code()) {
                    listener.onGetRecipesResponse(null, true, response.body());
                    if (response.body().getNext() == null) {
                        nextPageNull = true;
                    }else nextPageNull = false;
                }
            }

            @Override
            public void onFailure(Call<RecipesResponse> call, Throwable t) {
                if (null != listener)
                    listener.onGetRecipesResponse(t.getMessage(), false, null);

            }
        });
    }

    public void nextPage() {
        page++;
    }

    public int getPage() {
        return page;
    }

    public boolean isNextPageNull() {
        return nextPageNull;
    }
}
