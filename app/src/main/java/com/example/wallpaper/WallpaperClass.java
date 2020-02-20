package com.example.wallpaper;

import com.google.gson.annotations.SerializedName;

public class WallpaperClass {
    @SerializedName("id")
    private String id;
    @SerializedName("imageUrl")
    private int image;
    @SerializedName("name")
    private String imageName;


    public WallpaperClass(String id, int image, String imageName) {
        this.id=id;
        this.image = image;
        this.imageName = imageName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
