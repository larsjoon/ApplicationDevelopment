package com.example.deer.ApplicationDevelopment.dto;

public class SimulationRequest {
    private int startPopulation;
    private int carryingCapacity;
    private double discreteGrowthFactor;
    private int yearsToSimulate;

    // Getters and Setters
    public int getStartPopulation() { return startPopulation; }
    public void setStartPopulation(int startPopulation) { this.startPopulation = startPopulation; }

    public int getCarryingCapacity() { return carryingCapacity; }
    public void setCarryingCapacity(int carryingCapacity) { this.carryingCapacity = carryingCapacity; }

    public double getDiscreteGrowthFactor() { return discreteGrowthFactor; }
    public void setDiscreteGrowthFactor(double discreteGrowthFactor) { this.discreteGrowthFactor = discreteGrowthFactor; }

    public int getYearsToSimulate() { return yearsToSimulate; }
        public void setYearsToSimulate(int yearsToSimulate) { this.yearsToSimulate = yearsToSimulate; }
    }