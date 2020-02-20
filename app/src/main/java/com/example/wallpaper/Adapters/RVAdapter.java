package com.example.wallpaper.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallpaper.R;
import com.example.wallpaper.WallpaperClass;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter <RVAdapter.ViewHolder> {

    Context mContext;
    ArrayList<WallpaperClass> wallpapers;
    public  favoriteClicked favClicked;

    public interface favoriteClicked{
        void onFavoriteClicked(int index);

    }

    public RVAdapter(Context context, ArrayList<WallpaperClass> list) {
        this.mContext = context;
        favClicked= (favoriteClicked) context;
        this.wallpapers = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {


        return new ViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.card_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.name.setText(wallpapers.get(position).getImageName());
        holder.image.setImageResource(wallpapers.get(position).getImage());

//        String wallpaperImg= wallpapers.get(position).getImageURL();
//
//        Picasso.with(mContext)
//                .load(wallpaperImg)
//                .placeholder(android.R.drawable.sym_def_app_icon)
//                .error(android.R.drawable.sym_def_app_icon)
//                .into(holder.image);

    }



    public  class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView name;
        private ImageButton save ;
        private ImageButton fave;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.img);
            name= itemView.findViewById(R.id.wallpaperName);
            save = itemView.findViewById(R.id.download);
            fave = itemView.findViewById(R.id.fav_icon);

            fave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    favClicked.onFavoriteClicked(wallpapers.indexOf(itemView.getTag()));
                }
            });

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"Wallpaper successfully downloaded!",Toast.LENGTH_SHORT).show();
                }
            });



        }


    }
    @Override
    public int getItemCount() {
        return wallpapers.size();
    }
}
