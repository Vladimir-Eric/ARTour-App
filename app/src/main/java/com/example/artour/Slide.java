package com.example.artour;

public class Slide {
    private int image;
    private String text;

    public Slide(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }
}