package com.example.wallpaper;

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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter <RVAdapter.ViewHolder>{

    Context mContext;
    ArrayList<WallpaperClass> wallpapers;

    public RVAdapter(Context mContext, ArrayList<WallpaperClass> list) {
        this.mContext = mContext;
        this.wallpapers = list;
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


        holder.name.setText(wallpapers.get(position).getImageName());

//        String wallpaperImg= wallpapers.get(position).getImageURL();
//
//        Picasso.with(mContext)
//                .load(wallpaperImg)
//                .placeholder(android.R.drawable.sym_def_app_icon)
//                .error(android.R.drawable.sym_def_app_icon)
//                .into(holder.image);

    }



    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        ImageButton save ;
        ImageButton fave;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.img);
            name= itemView.findViewById(R.id.wallpaperName);
            save = itemView.findViewById(R.id.download);
            fave = itemView.findViewById(R.id.fav_icon);

           save.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

               }
           });
        }
    }
    @Override
    public int getItemCount() {
        return wallpapers.size();
    }
}
