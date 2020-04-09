package edu.pam.tugas_rancang.entity;

import androidx.annotation.Nullable;

public class Trip {
    private int id = 0;
    private Tour tour = new Tour(0, "", "", 0); // from class Tour
    private String name = "";
    private String description = "";

    public Trip(int id, Tour tour, String name, String description) {
        this.id = id;
        this.tour = tour;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
