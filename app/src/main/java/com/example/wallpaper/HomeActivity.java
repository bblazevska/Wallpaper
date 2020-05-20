package com.example.wallpaper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wallpaper.Adapters.RVAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements RVAdapter.favoriteClicked {

public ArrayList<WallpaperClass> images;
public Fragment selectedFragment;
public ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        FragmentHome fragmentHome = new FragmentHome();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragmentHome).commit();

//        selectedFragment = new FragmentHome();
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()== R.id.home) {
                    selectedFragment = new FragmentHome();

                }
                 if (item.getItemId() == R.id.favorite)
                {
                    selectedFragment = new FragmentFavorites();

                }
                else if (item.getItemId() == R.id.settings){
                    selectedFragment = new FragmentSettings();

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                return true;
            }
        });




    }


    @Override
    public void onFavoriteClicked(int index) {

        img.setImageResource(images.get(index).getImage());

        FragmentFavorites favorites = new FragmentFavorites();
        favorites.getTag();
        favorites.displayImage(img);

    }



}




