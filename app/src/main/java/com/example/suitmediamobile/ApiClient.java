package com.example.suitmediamobile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BaseUrl = "http://www.mocky.io/v2";

    private static Retrofit retrofit;

    //static Gson gson = new GsonBuilder().setLenient().create();

    public static Retrofit getRetrofit() {
        if(retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
