package com.example.wallpaper;

public class WallpaperClass {

    private String image;
    private String imageName;

    public WallpaperClass(String image, String imageName) {
        this.image = image;
        this.imageName = imageName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
