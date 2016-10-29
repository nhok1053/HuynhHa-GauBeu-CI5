package com.example.hasan.lab_16.models;

/**
 * Created by Ha San~ on 10/29/2016.
 */

public class Note {
    private int id;
    private String title;
    private String content;
    private String date;

    public Note(int id, String title, String content, String date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Note(String title, String content, String date) {
        this(-1, title, content, date);
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}
