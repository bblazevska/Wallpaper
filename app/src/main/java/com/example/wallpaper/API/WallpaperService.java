package com.example.wallpaper.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WallpaperService  {

    public static Retrofit retrofitClient;
    public static WallpaperInterface service;

    public static void initializeRetrofit(){

        retrofitClient = new Retrofit.Builder()
                .baseUrl("http://5e3ff28069618d001411f71a.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofitClient.create(WallpaperInterface.class);
    }

}
