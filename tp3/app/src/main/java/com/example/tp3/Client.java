package com.example.tp3;

public class Client {
    private String name;
    private String image; // Can use a URL or drawable resource ID
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

    // Getters and Setters
    public String getName() { return name; }
    public String getImage() { return image; }
    public String getCategory() { return category; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
}
