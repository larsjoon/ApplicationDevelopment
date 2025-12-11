package com.example.deer.ApplicationDevelopment.service;

import com.example.deer.ApplicationDevelopment.dto.SimulationRequest;
import com.example.deer.ApplicationDevelopment.dto.SimulationResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DeerService {

    // 1983-2025 Trend Logic
    private static final double BASE_GRASS_HEIGHT_1983 = 32.8; 
    private static final double GRASS_DECLINE_RATE = 0.57;   
    private static final double MIN_GRASS_HEIGHT = 5.0; 

    private final Random random = new Random();

    public SimulationResponse calculatePopulation(SimulationRequest request) {
        List<Integer> years = new ArrayList<>();
        List<Integer> populationHistory = new ArrayList<>();
        List<Integer> carryingCapacityHistory = new ArrayList<>();

        double currentPopulation = request.getStartPopulation();
        double maxK = request.getCarryingCapacity();
        double baseRd = request.getDiscreteGrowthFactor();
        int lag = request.getTimeLag();
        double sigma = request.getStochasticity();
        int harvest = request.getHarvestAmount();
        
        // Init Arrays (Start at 1983, not 0)
        // We do NOT add the initial state here because the loop handles the timeline
        // Instead, we seed the loop with the initial population.
        
        // Loop from StartYear to EndYear
        for (int year = request.getStartYear(); year <= request.getEndYear(); year++) {
            
            // 1. CALCULATE DYNAMIC K (Trend)
            int yearsSinceStart = year - 1983; 
            double currentGrassHeight = BASE_GRASS_HEIGHT_1983 - (GRASS_DECLINE_RATE * yearsSinceStart);
            if (currentGrassHeight < MIN_GRASS_HEIGHT) currentGrassHeight = MIN_GRASS_HEIGHT;

            double habitatHealth = currentGrassHeight / BASE_GRASS_HEIGHT_1983;
            double currentK = maxK * habitatHealth;

            // Save data for THIS year (Snapshot at beginning of year)
            years.add(year);
            populationHistory.add((int) currentPopulation);
            carryingCapacityHistory.add((int) currentK);

            // --- CALCULATE CHANGE FOR NEXT YEAR ---

            // 2. TIME LAG LOOKUP
            // We need population from 'lag' years ago.
            // The list 'populationHistory' holds data we just added.
            // Index of current year is (size - 1). Index of lag year is (size - 1 - lag).
            int currentIndex = populationHistory.size() - 1;
            int lookBackIndex = currentIndex - lag;

            double populationForResistance;
            if (lookBackIndex < 0) {
                populationForResistance = request.getStartPopulation();
            } else {
                populationForResistance = populationHistory.get(lookBackIndex);
            }

            // 3. STOCHASTICITY
            double effectiveRd = baseRd * (1.0 + (random.nextGaussian() * sigma));
            if(effectiveRd < 0) effectiveRd = 0;

            // 4. WOLF PRESSURE
            if (request.isWolvesEnabled()) {
                double predationRate = 0.20; 
                effectiveRd = effectiveRd - predationRate;
                if (effectiveRd < 0.05) effectiveRd = 0.05;
            }

            // 5. LOGISTIC EQUATION
            double resistance = 1.0 - (populationForResistance / currentK);
            double change = effectiveRd * currentPopulation * resistance;
            double nextPopulation = currentPopulation + change;

            // 6. HARVEST
            nextPopulation = nextPopulation - harvest;

            // 7. ACTIVE MANAGEMENT
            if (request.isManagementMode()) {
                double managementTarget = currentK * 0.9; 
                if (nextPopulation > managementTarget) {
                    nextPopulation = managementTarget; 
                }
            }

            if (nextPopulation < 0) nextPopulation = 0;
            
            // Set value for NEXT loop iteration
            currentPopulation = nextPopulation;
        }

        return new SimulationResponse(years, populationHistory, carryingCapacityHistory);
    }
}