package com.example.deer.ApplicationDevelopment.dto;

public class SimulationRequest {
    // --- Timeline ---
    private int startYear; 
    private int endYear;   

    // --- Inputs ---
    private int startPopulation;
    private int carryingCapacity;
    private double discreteGrowthFactor;
    private int timeLag;
    private double stochasticity;
    private int harvestAmount;
    
    // --- Toggles ---
    private boolean managementMode;
    private boolean wolvesEnabled;

    // --- Getters and Setters ---
    public int getStartYear() { return startYear; }
    public void setStartYear(int startYear) { this.startYear = startYear; }

    public int getEndYear() { return endYear; }
    public void setEndYear(int endYear) { this.endYear = endYear; }

    public int getStartPopulation() { return startPopulation; }
    public void setStartPopulation(int startPopulation) { this.startPopulation = startPopulation; }

    public int getCarryingCapacity() { return carryingCapacity; }
    public void setCarryingCapacity(int carryingCapacity) { this.carryingCapacity = carryingCapacity; }

    public double getDiscreteGrowthFactor() { return discreteGrowthFactor; }
    public void setDiscreteGrowthFactor(double discreteGrowthFactor) { this.discreteGrowthFactor = discreteGrowthFactor; }

    public int getTimeLag() { return timeLag; }
    public void setTimeLag(int timeLag) { this.timeLag = timeLag; }

    public double getStochasticity() { return stochasticity; }
    public void setStochasticity(double stochasticity) { this.stochasticity = stochasticity; }

    public int getHarvestAmount() { return harvestAmount; }
    public void setHarvestAmount(int harvestAmount) { this.harvestAmount = harvestAmount; }

    public boolean isManagementMode() { return managementMode; }
    public void setManagementMode(boolean managementMode) { this.managementMode = managementMode; }

    public boolean isWolvesEnabled() { return wolvesEnabled; }
    public void setWolvesEnabled(boolean wolvesEnabled) { this.wolvesEnabled = wolvesEnabled; }
}