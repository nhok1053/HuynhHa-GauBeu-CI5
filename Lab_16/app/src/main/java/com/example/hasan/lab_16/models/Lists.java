package com.example.hasan.lab_16.models;

import java.util.ArrayList;

/**
 * Created by Ha San~ on 10/29/2016.
 */

public class Lists {
    private String title;

    public Lists(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public static final java.util.List<Lists> LISTS = new ArrayList<>();

}
