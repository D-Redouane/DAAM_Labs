package com.example.tp3;

public class Client {
    private final String name; // Client's name
    private final String description; // Brief description of the location
    private final int imageResId; // Resource ID for the client's image
    private final double latitude; // Latitude of the client's location
    private final double longitude; // Longitude of the client's location

    // Constructor to initialize the Client object
    public Client(String name, String description, int imageResId, double latitude, double longitude) {
        this.name = name;
        this.description = description;
        this.imageResId = imageResId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters for accessing the properties
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
