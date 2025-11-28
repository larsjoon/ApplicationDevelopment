package com.example.deer.ApplicationDevelopment.dto;

import java.util.List;

public class SimulationResponse {
    private List<Integer> years;
    private List<Integer> populationHistory;
    private List<Integer> carryingCapacityHistory;

    public SimulationResponse(List<Integer> years, List<Integer> populationHistory, List<Integer> carryingCapacityHistory) {
        this.years = years;
        this.populationHistory = populationHistory;
        this.carryingCapacityHistory = carryingCapacityHistory;
    }

    // Getters and Setters
    public List<Integer> getYears() { return years; }
    public void setYears(List<Integer> years) { this.years = years; }

    public List<Integer> getPopulationHistory() { return populationHistory; }
    public void setPopulationHistory(List<Integer> populationHistory) { this.populationHistory = populationHistory; }

    public List<Integer> getCarryingCapacityHistory() { return carryingCapacityHistory; }
    public void setCarryingCapacityHistory(List<Integer> carryingCapacityHistory) { this.carryingCapacityHistory = carryingCapacityHistory; }
}