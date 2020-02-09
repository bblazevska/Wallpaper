package com.example.wallpaper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter <RVAdapter.ViewHolder>{

    Context mContext;
    ArrayList<WallpaperClass> wallpapers;

    public RVAdapter(Context mContext, ArrayList<WallpaperClass> wallpapers) {
        this.mContext = mContext;
        this.wallpapers = wallpapers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.card_layout,parent,false);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String wallpaperImg= wallpapers.get(position).getImageURL();
        Picasso.with(mContext)
                .load(wallpaperImg)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return wallpapers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.img);
        }
    }
}
