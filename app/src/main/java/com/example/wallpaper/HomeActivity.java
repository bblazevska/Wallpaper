package com.example.wallpaper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.annotation.Target;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<WallpaperClass> wallpapers ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.rv_home);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        getWallpapersResponse();
    }

    private void getWallpapersResponse(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://5e3ff28069618d001411f71a.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WallpaperInterface apiInterface = retrofit.create(WallpaperInterface.class);
        Call<ArrayList<WallpaperClass>> call = apiInterface.getWallpapersJson();
        call.enqueue(new Callback<ArrayList<WallpaperClass>>() {
            @Override
            public void onResponse(Call<ArrayList<WallpaperClass>> call, Response<ArrayList<WallpaperClass>> response) {
                wallpapers = response.body();
                myAdapter= new HomeRecyclerViewAdapter(wallpapers,HomeActivity.this);
                recyclerView.setAdapter(myAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<WallpaperClass>> call, Throwable t) {
                Toast.makeText(HomeActivity.this,"Failed",Toast.LENGTH_SHORT).show();
            }
        });

    }

}


