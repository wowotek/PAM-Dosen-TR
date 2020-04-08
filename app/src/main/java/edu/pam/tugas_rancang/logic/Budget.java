package edu.pam.tugas_rancang.logic;

import androidx.annotation.Nullable;

public class Budget {
    private int id;
    private int trip_id; // from Trip class
    private String name = "Unnamed Budget";
    private String description = "";
    private double budget;
    private int budget_type_id = 0; // from item_type_id;

    public Budget(int id, int trip_id, double budget) {
        this.id = id;
        this.trip_id = trip_id;
        this.budget = budget;
    }

    public Budget(int id, int trip_id, @Nullable String name, double budget) {
        this.id = id;
        this.trip_id = trip_id;
        this.name = name;
        this.budget = budget;
    }

    public Budget(int id, int trip_id, @Nullable String name, @Nullable String description, double budget) {
        this.id = id;
        this.trip_id = trip_id;
        this.name = name;
        this.description = description;
        this.budget = budget;
    }

    public Budget(int id, int trip_id, @Nullable String name, @Nullable String description, double budget, @Nullable int budget_type_id) {
        this.id = id;
        this.trip_id = trip_id;
        this.name = name;
        this.description = description;
        this.budget = budget;
        this.budget_type_id = budget_type_id;
    }

    // Trip Object Enabled and Item Type Disabled Constructor
    public Budget(int id, Trip trip, double budget) {
        this.id = id;
        this.trip_id = trip.getId();
        this.budget = budget;
    }

    public Budget(int id, Trip trip, @Nullable String name, double budget) {
        this.id = id;
        this.trip_id = trip.getId();
        this.name = name;
        this.budget = budget;
    }

    public Budget(int id, Trip trip, @Nullable String name, @Nullable String description, double budget) {
        this.id = id;
        this.trip_id = trip.getId();
        this.name = name;
        this.description = description;
        this.budget = budget;
    }

    public Budget(int id, Trip trip, @Nullable String name, @Nullable String description, double budget, @Nullable int budget_type_id) {
        this.id = id;
        this.trip_id = trip.getId();
        this.name = name;
        this.description = description;
        this.budget = budget;
        this.budget_type_id = budget_type_id;
    }

    // Trip Object Enabled and Item Type Enabled Constructor
    public Budget(int id, Trip trip, @Nullable String name, @Nullable String description, double budget, @Nullable BudgetType budgetType) {
        this.id = id;
        this.trip_id = trip.getId();
        this.name = name;
        this.description = description;
        this.budget = budget;

        if(budgetType != null) {
            this.budget_type_id = budgetType.getId();
        } else {
            this.budget_type_id = 0;
        }
    }

    public Budget(int id, int trip_id, @Nullable String name, @Nullable String description, double budget, @Nullable BudgetType budgetType) {
        this.id = id;
        this.trip_id = trip_id;
        this.name = name;
        this.description = description;
        this.budget = budget;

        if(budgetType != null) {
            this.budget_type_id = budgetType.getId();
        } else {
            this.budget_type_id = 0;
        }
    }

    // Getter Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
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

    public int getBudget_type_id() {
        return budget_type_id;
    }

    public void setBudget_type_id(int budget_type_id) {
        this.budget_type_id = budget_type_id;
    }
}
