package com.example.deer.ApplicationDevelopment.service;

import com.example.deer.ApplicationDevelopment.dto.SimulationRequest;
import com.example.deer.ApplicationDevelopment.dto.SimulationResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeerService {

    public SimulationResponse calculatePopulation(SimulationRequest request) {
        List<Integer> years = new ArrayList<>();
        List<Integer> populationHistory = new ArrayList<>();
        List<Integer> carryingCapacityHistory = new ArrayList<>();

        double currentPopulation = request.getStartPopulation();
        double K = request.getCarryingCapacity();
        double rd = request.getDiscreteGrowthFactor();

        years.add(0);
        populationHistory.add((int) currentPopulation);
        carryingCapacityHistory.add((int) K);

        for (int t = 1; t <= request.getYearsToSimulate(); t++) {
            // Logic: Nt+1 = Nt + rd * Nt * (1 - Nt/K)
            double resistance = 1.0 - (currentPopulation / K);
            double change = rd * currentPopulation * resistance;
            double nextPopulation = currentPopulation + change;

            if (nextPopulation < 0) nextPopulation = 0;

            currentPopulation = nextPopulation;

            years.add(t);
            populationHistory.add((int) currentPopulation);
            carryingCapacityHistory.add((int) K);
        }

        return new SimulationResponse(years, populationHistory, carryingCapacityHistory);
    }
}