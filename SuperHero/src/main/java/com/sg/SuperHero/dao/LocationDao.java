package com.sg.SuperHero.dao;

import com.sg.SuperHero.dto.Location;

import java.util.List;

public interface LocationDao {

    List<Location> getAllLocations();
    Location getLocationById(int id);
    Location addLocation(Location location);
    void updateLocation(Location location);
    void deleteLocationById(int id);
}
