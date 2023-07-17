package com.sg.SuperHero.dao;

import com.sg.SuperHero.SuperHeroApplication;
import com.sg.SuperHero.dto.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SuperHeroApplication.class)
class LocationDaoImplTest {

    @Autowired
    private LocationDao locationDao;


    public LocationDaoImplTest() {

    }

    @BeforeEach
    void setUp() {
        List<Location> locations = locationDao.getAllLocations();
        for(Location location : locations) {
            locationDao.deleteLocationById(location.getLocationId());
        }
    }

    @Test
    void getAllLocations() {

    }

    @Test
    void getLocationById() {
    }

    @Test
    void addLocation() {
    }

    @Test
    void updateLocation() {
    }

    @Test
    void deleteLocationById() {
    }
}