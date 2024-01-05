package com.example.artour;

public class Destination {

    private int id;
    private String title;
    private int imageResource;
    private String description;

    public Destination(int id, String title, int imageResource, String description) {
        this.id = id;
        this.title = title;
        this.imageResource = imageResource;
        this.description = description;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
