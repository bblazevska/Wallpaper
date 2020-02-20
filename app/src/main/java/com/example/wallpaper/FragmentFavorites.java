package com.example.wallpaper;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.wallpaper.Adapters.ImageAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFavorites extends Fragment {

    public int i;
    private ImageView image;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ImageAdapter imageAdapter;
    public FragmentFavorites() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.favorites_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.favorites_rv);

        layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        image=view.findViewById(R.id.fav_image);

    }

   protected void displayImage(ImageView image){

        ArrayList<WallpaperClass> favImages = new ArrayList<>();
        favImages.add(new WallpaperClass("",image,""));

        imageAdapter = new ImageAdapter(getContext(),favImages);




   }
}
