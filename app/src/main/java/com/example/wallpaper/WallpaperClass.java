package com.example.wallpaper;

public class WallpaperClass {

    private String id;
    private int image;
    private String imageName;

    static final String IMAGE_KEY = "Image";
    static final String CARD_KEY = "Card";

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

    public int getImageURL() {
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
