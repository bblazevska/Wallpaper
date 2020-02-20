package com.example.wallpaper.API;

import com.example.wallpaper.WallpaperClass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WallpaperInterface {


    @GET("/wallpapers")
    Call<ArrayList<WallpaperClass>> getWallpapersJson();
}
