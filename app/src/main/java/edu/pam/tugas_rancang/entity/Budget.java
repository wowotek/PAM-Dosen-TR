package edu.pam.tugas_rancang.entity;

import androidx.annotation.Nullable;

public class Budget {
    private int id;
    private Trip trip;
    private String name = "Unnamed Budget";
    private String description = "";
    private double budget;
    private BudgetType budgetType;

    // Trip Object Enabled and Item Type Disabled Constructor
    public Budget(int id, Trip trip, double budget) {
        this.id = id;
        this.trip = trip;
        this.budget = budget;
    }

    public Budget(int id, Trip trip, @Nullable String name, double budget) {
        this.id = id;
        this.trip= trip;
        this.name = name;
        this.budget = budget;
    }

    public Budget(int id, Trip trip, @Nullable String name, @Nullable String description, double budget) {
        this.id = id;
        this.trip= trip;
        this.name = name;
        this.description = description;
        this.budget = budget;
    }

    // Trip Object Enabled and Item Type Enabled Constructor
    public Budget(int id, Trip trip, @Nullable String name, @Nullable String description, double budget, @Nullable BudgetType budgetType) {
        this.id = id;
        this.trip= trip;
        this.name = name;
        this.description = description;
        this.budget = budget;
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
