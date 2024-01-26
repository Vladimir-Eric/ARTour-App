package com.example.artour;

public class Destination {

    private int id;
    private final String title;
    private final int imageResource;
    private final String description;
    private final String extraText;

    public Destination(int id, String title, int imageResource, String description, String extraText) {
        this.id = id;
        this.title = title;
        this.imageResource = imageResource;
        this.description = description;
        this.extraText = extraText;
    }

    public String getExtraText() {
        return extraText;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }

    public int getImageResource() {
        return imageResource;
    }

    public String getDescription() {
        return description;
    }
}