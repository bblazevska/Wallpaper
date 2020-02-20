package com.example.wallpaper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallpaper.Adapters.RVAdapter;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    interface sendFavorite {
        void sendImage(Integer image);

    }

   private  View v;

    sendFavorite sendImage;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private RVAdapter myAdapter;
    private ArrayList<WallpaperClass> wallpapers;
    private ImageButton save ;
    private ImageButton fave ;
    private ImageView image ;
    private TextView name ;



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
        layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        wallpapers = new ArrayList<>();




        fave = view.findViewById(R.id.fav_icon);
        save = view.findViewById(R.id.download);
        image = view.findViewById(R.id.img);
        name = view.findViewById(R.id.wallpaperName);


        wallpapers.add(new WallpaperClass("0",R.drawable.cute_wallpaper,"Moon cute"));
        wallpapers.add(new WallpaperClass("1",R.drawable.lake_view,"Lake view"));
        wallpapers.add(new WallpaperClass("2",R.drawable.light_bulbs,"Light bulbs"));
        wallpapers.add(new WallpaperClass("3",R.drawable.cool_cat,"Cool cat"));
        wallpapers.add(new WallpaperClass("4",R.drawable.forest_trees,"ForestTrees"));
        wallpapers.add(new WallpaperClass("5",R.drawable.flower,"Flower"));
        wallpapers.add(new WallpaperClass("6",R.drawable.grey_cat,"Grey cat"));
        wallpapers.add(new WallpaperClass("7",R.drawable.leaf,"Leaf"));
        wallpapers.add(new WallpaperClass("8",R.drawable.meow,"M E O W"));
        wallpapers.add(new WallpaperClass("9",R.drawable.minnie,"Minnie"));
        wallpapers.add(new WallpaperClass("10",R.drawable.music_dog,"Music dog"));
        wallpapers.add(new WallpaperClass("11",R.drawable.bestfriends,"Besties"));
        wallpapers.add(new WallpaperClass("12",R.drawable.butterfly,"Butterfly"));
        wallpapers.add(new WallpaperClass("13",R.drawable.nature,"Nature"));
        wallpapers.add(new WallpaperClass("14",R.drawable.railway,"Railway"));
        wallpapers.add(new WallpaperClass("15",R.drawable.black_dog,"Black dog"));
        wallpapers.add(new WallpaperClass("16",R.drawable.color_burst,"Color burst"));
        wallpapers.add(new WallpaperClass("17",R.drawable.road_illusion,"Illusion"));
        wallpapers.add(new WallpaperClass("18",R.drawable.sky,"Sky"));
        wallpapers.add(new WallpaperClass("19",R.drawable.smiley_dog,"Smiley dog"));
        wallpapers.add(new WallpaperClass("20",R.drawable.spungebob,"SpongeBob"));
        wallpapers.add(new WallpaperClass("21",R.drawable.sunflowers,"Sunflowers"));
        wallpapers.add(new WallpaperClass("22",R.drawable.weird,"Weird"));

        myAdapter = new RVAdapter(getActivity(),wallpapers);
        recyclerView.setAdapter(myAdapter);


        //getWallpapersResponse();
    }

//    private void getWallpapersResponse() {
//
//        WallpaperService.initializeRetrofit();
//
//        Call<ArrayList<WallpaperClass>> call = WallpaperService.service.getWallpapersJson();
//        call.enqueue(new Callback<ArrayList<WallpaperClass>>() {
//            @Override
//           public void onResponse(Call<ArrayList<WallpaperClass>> call, Response<ArrayList<WallpaperClass>> response) {
//                wallpapers = response.body();
//                myAdapter = new RVAdapter(getActivity(), wallpapers);
//                recyclerView.setAdapter(myAdapter);
//
//                Toast.makeText(getActivity(),"Success",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<WallpaperClass>> call, Throwable t) {
//                Toast.makeText(getActivity(),"Failed",Toast.LENGTH_SHORT).show();
//                Log.d("failure", t.getMessage());
//
//            }
//
//        });
//   }


}
