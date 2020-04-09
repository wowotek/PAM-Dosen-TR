package edu.pam.tugas_rancang.entity;

import androidx.annotation.Nullable;

public class Budget {
    private int id;
    private Trip trip = new Trip(0, new Tour(0, "", "", 0), "", "");
    private String name = "Unnamed Budget";
    private String description = "";
    private double budget = 0.0;
    private BudgetType budgetType = new BudgetType(0, "");

    // Trip Object Enabled and Item Type Enabled Constructor
    public Budget(int id, Trip trip, String name, String description, double budget, BudgetType budgetType) {
        this.id = id;
        this.trip= trip;
        this.name = name;
        this.description = description;
        this.budget = budget;
        this.budgetType = budgetType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
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

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public BudgetType getBudgetType() {
        return budgetType;
    }

    public String getTag(){
        return this.budgetType.getName();
    }

    public void setBudgetType(BudgetType budgetType) {
        this.budgetType = budgetType;
    }
}
