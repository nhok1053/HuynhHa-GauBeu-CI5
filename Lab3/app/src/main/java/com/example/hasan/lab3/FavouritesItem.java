package com.example.hasan.lab3;

/**
 * Created by Ha San~ on 10/2/2016.
 */

public class FavouritesItem {
    private String title;
    private String minutes;
    private int imagesResID;

    public FavouritesItem(String title, String minutes, int imagesResID) {
        this.title = title;
        this.minutes = minutes;
        this.imagesResID = imagesResID;
    }

    public int getImagesResID() {
        return imagesResID;
    }

    public void setImagesResID(int imagesResID) {
        this.imagesResID = imagesResID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public static final FavouritesItem[] Array = new FavouritesItem[]{
            new FavouritesItem("He may act like he wants a secretaly but most of the time they're lookig for", "10min",R.drawable.item1),
            new FavouritesItem("Peggy, just think about it Deeply. Then forget it . And an idea will jump up in your face", "13min",R.drawable.item2),
            new FavouritesItem("Go Home, take a paper ba and cut some eyeholes out of it. Put it over your head", "16min",R.drawable.item3),
            new FavouritesItem("Get out of here and move forward. This never happened . It will shock you now much...", "19min",R.drawable.item4),
            new FavouritesItem("That pool girl. She doesn't know that loving you is the worst way to get to you", "22min",R.drawable.item5)
    };
}
