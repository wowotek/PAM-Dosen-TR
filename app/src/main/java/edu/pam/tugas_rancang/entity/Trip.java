package edu.pam.tugas_rancang.entity;

import androidx.annotation.Nullable;

public class Trip {
    private int id;
    private int tour_id; // from class Tour
    private String name;
    private String description = "";

    public Trip(int id, int tour_id, String name) {
        this.id = id;
        this.tour_id = tour_id;
        this.name = name;
    }

    public Trip(int id, int tour_id, String name, @Nullable String description) {
        this.id = id;
        this.tour_id = tour_id;
        this.name = name;
        this.description = description;
    }

    public Trip(int id, Tour tour, String name) {
        this.id = id;
        this.tour_id = tour.getId();
        this.name = name;
    }

    public Trip(int id, Tour tour, String name, @Nullable String description) {
        this.id = id;
        this.tour_id = tour.getId();
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTour_id() {
        return tour_id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
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
