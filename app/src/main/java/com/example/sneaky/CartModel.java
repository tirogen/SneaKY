package com.example.sneaky;

import java.sql.Timestamp;

public class CartModel {

    private String name;
    private int price;
    private String image;
    private String size;
    private Timestamp timestamp;
    private String progress;
    private String note;

    public CartModel(){ }

    public CartModel(String name, int price, String image, String size, Timestamp timestamp, String progress, String note) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.size = size;
        this.timestamp = timestamp;
        this.progress = progress;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
