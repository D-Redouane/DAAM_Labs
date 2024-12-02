package com.example.tp3;

public class Client {
    private String name;
    private String image; // Can use a URL or a drawable resource ID
    private String category;
    private double latitude;
    private double longitude;

    public Client(String name, String image, String category, double latitude, double longitude) {
        this.name = name;
        this.image = image;
        this.category = category;
        this.latitude = latitude;
        this.longitude = longitude;
    }


}