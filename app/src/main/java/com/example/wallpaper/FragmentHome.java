package com.example.wallpaper;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentHome extends Fragment {

    interface sendFavorite {
        void sendImage(int imageUrl);
        void onClick( int i);
    }

    View v;
    int i;
    sendFavorite sendFavorite;

    private RecyclerView recyclerView;
    private ArrayList<WallpaperClass> wallpapers;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;


    public FragmentHome() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.home_fragment, container, false);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = v.findViewById(R.id.rv_home);
        wallpapers = new ArrayList<>();
        wallpapers.add(new WallpaperClass("0",R.drawable.bestfriends,"Best Friends"));
        wallpapers.add(new WallpaperClass("1",R.drawable.butterfly,"Butterfly"));
        wallpapers.add(new WallpaperClass("2",R.drawable.cute_wallpaper,"Moon cute"));
        wallpapers.add(new WallpaperClass("3",R.drawable.lake_view,"Lake view"));
        wallpapers.add(new WallpaperClass("4",R.drawable.light_bulbs,"Light bulbs"));
        wallpapers.add(new WallpaperClass("5",R.drawable.cool_cat,"Cool cat"));
        wallpapers.add(new WallpaperClass("6",R.drawable.forest_trees,"Forest trees"));
        wallpapers.add(new WallpaperClass("7",R.drawable.flower,"Flower"));
       wallpapers.add(new WallpaperClass("8",R.drawable.grey_cat,"Grey cat"));
        wallpapers.add(new WallpaperClass("9",R.drawable.leaf,"Leaf"));
        wallpapers.add(new WallpaperClass("10",R.drawable.meow,"M E O W"));
        wallpapers.add(new WallpaperClass("11",R.drawable.minnie,"Minnie mouse"));
        wallpapers.add(new WallpaperClass("12",R.drawable.music_dog,"Music dog"));
        wallpapers.add(new WallpaperClass("13",R.drawable.nature,"Nature"));
        wallpapers.add(new WallpaperClass("14",R.drawable.railway,"Railway"));
        wallpapers.add(new WallpaperClass("15",R.drawable.black_dog,"Black dog"));
        wallpapers.add(new WallpaperClass("16",R.drawable.color_burst,"Color burst"));
        wallpapers.add(new WallpaperClass("17",R.drawable.road_illusion,"Road illusion"));
        wallpapers.add(new WallpaperClass("18",R.drawable.sky,"Sky"));
        wallpapers.add(new WallpaperClass("19",R.drawable.smiley_dog,"Smiley dog"));
        wallpapers.add(new WallpaperClass("20",R.drawable.spungebob,"Sponge Bob"));
        wallpapers.add(new WallpaperClass("21",R.drawable.sunflowers,"Sunflowers"));
        wallpapers.add(new WallpaperClass("22",R.drawable.weird,"Weird wallpaper"));



        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new RVAdapter(this.getActivity(), wallpapers);
       recyclerView.setAdapter(myAdapter);

        ImageButton fave = view.findViewById(R.id.fav_icon);
        ImageButton save = view.findViewById(R.id.download);
        ImageView image = view.findViewById(R.id.img);



        //getWallpapersResponse();


    }

//    private void getWallpapersResponse() {
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://5e3ff28069618d001411f71a.mockapi.io/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        WallpaperInterface apiInterface = retrofit.create(WallpaperInterface.class);
//        Call<ArrayList<WallpaperClass>> call = apiInterface.getWallpapersJson();
//        call.enqueue(new Callback<ArrayList<WallpaperClass>>() {
//            @Override
//           public void onResponse(Call<ArrayList<WallpaperClass>> call, Response<ArrayList<WallpaperClass>> response) {
//                wallpapers = response.body();
//                myAdapter = new RVAdapter(getActivity(), wallpapers);
//                recyclerView.setAdapter(myAdapter);
//
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<WallpaperClass>> call, Throwable t) {
//
//            }
//
//        });
//   }
}
