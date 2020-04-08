package edu.pam.tugas_rancang.entity;

import androidx.annotation.Nullable;

public class Trip {
    private int id;
    private Tour tour; // from class Tour
    private String name;
    private String description = "";

    public Trip(int id, Tour tour, String name) {
        this.id = id;
        this.tour = tour;
        this.name = name;
    }

    public Trip(int id, Tour tour, String name, @Nullable String description) {
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
        return name;
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
