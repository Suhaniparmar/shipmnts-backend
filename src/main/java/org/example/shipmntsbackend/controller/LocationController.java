package org.example.shipmntsbackend.controller;

import org.example.shipmntsbackend.entity.Location;
import org.example.shipmntsbackend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LocationController {



    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/create_location")
    public ResponseEntity<String> addLocation(@RequestBody Location location) {
        String response = locationService.createLocation(location);
        return response.equals("Location created sucessfully")? ResponseEntity.ok(response) : ResponseEntity.badRequest().body(response);
    }

//    @GetMapping("")
}
