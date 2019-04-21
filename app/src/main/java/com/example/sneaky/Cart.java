package com.example.sneaky;

import java.sql.Timestamp;

public class Cart {
    private String image;
    private String name;
    private String note;
    private int price;
    private String progress;
    private String size;
    private String timestamp;

    public Cart(){ }

    public Cart(String image, String name, String note, int price, String progress, String size, String timestamp) {
        this.image = image;
        this.name = name;
        this.note = note;
        this.price = price;
        this.progress = progress;
        this.size = size;
        this.timestamp = timestamp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
