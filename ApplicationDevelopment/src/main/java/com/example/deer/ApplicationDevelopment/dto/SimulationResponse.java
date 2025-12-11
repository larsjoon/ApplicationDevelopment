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

    // Getters
    public List<Integer> getYears() { return years; }
    public List<Integer> getPopulationHistory() { return populationHistory; }
    public List<Integer> getCarryingCapacityHistory() { return carryingCapacityHistory; }
}