package com.example.tituh.fitnessproj.helpers.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "http://18.215.141.14:8000/";
    //public static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static Retrofit retrofit;

    public static ApiInterface getClient() {

        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        ApiInterface apiService = retrofit.create(ApiInterface.class);
        return apiService;
    }

}