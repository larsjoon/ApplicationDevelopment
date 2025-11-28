package com.example.deer.ApplicationDevelopment;

import com.example.deer.ApplicationDevelopment.dto.SimulationRequest;
import com.example.deer.ApplicationDevelopment.dto.SimulationResponse;
// Updated the import statement to reflect the correct package structure
import com.example.deer.ApplicationDevelopment.service.DeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
// @CrossOrigin allows the HTML file to connect to Java even if running on a different port/method
@CrossOrigin(origins = "*") 
public class SimulationController {

    private final DeerService deerService;

    @Autowired
    public SimulationController(DeerService deerService) {
        this.deerService = deerService;
    }

    @PostMapping("/simulate")
    public SimulationResponse simulate(@RequestBody SimulationRequest request) {
        // Delegate the calculation to the Service layer
        return deerService.calculatePopulation(request);
    }
}
