package com.example.tp3;

import java.util.Date;

public class Client {
    private String name;
    private int image;
    private String category;
    private String adresse;
    private String coordinates;

    // Constructeur
    public Client(String name, int image, String category, String adresse, String coordinates) {
        this.name = name;
        this.image = image;
        this.category = category;
        this.adresse = adresse;
        this.coordinates = coordinates;

    }

    // Getters et Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}
