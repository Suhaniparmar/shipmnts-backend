package org.example.shipmntsbackend.service;

import org.example.shipmntsbackend.entity.Location;
import org.example.shipmntsbackend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {


    private final LocationRepository locationRepo;

    @Autowired
    public LocationService(LocationRepository locationRepo) {
        this.locationRepo = locationRepo;
    }

    public String createLocation(Location location) {
        if(locationRepo.existsByLocationCode(location.getLocationCode())){
            return "child location already exists";
        }
        if(location.getParentLocationCode()==null) {
            if (location.getType() != Location.LocationType.warehouse) {
                return "parent must be warehouse";
            }
        } else {
                if(location.getType()!=Location.LocationType.storage){
                    return "child must be storage";
                }
                if(locationRepo.existsByLocationCode(location.getParentLocationCode())){
                    return "parent location already exists";
                }

            }
        locationRepo.save(location);
        return "Location created sucessfully";
    }



}
