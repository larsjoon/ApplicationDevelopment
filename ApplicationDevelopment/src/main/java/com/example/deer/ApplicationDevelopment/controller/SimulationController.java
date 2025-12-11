package com.example.deer.ApplicationDevelopment.controller;

import com.example.deer.ApplicationDevelopment.dto.SimulationRequest;
import com.example.deer.ApplicationDevelopment.dto.SimulationResponse;
import com.example.deer.ApplicationDevelopment.service.DeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SimulationController {

    private final DeerService deerService;

    @Autowired
    public SimulationController(DeerService deerService) {
        this.deerService = deerService;
    }

    @PostMapping("/simulate")
    public SimulationResponse simulate(@RequestBody SimulationRequest request) {
        System.out.println("Received request for years: " + request.getStartYear() + " to " + request.getEndYear());
        return deerService.calculatePopulation(request);
    }
}