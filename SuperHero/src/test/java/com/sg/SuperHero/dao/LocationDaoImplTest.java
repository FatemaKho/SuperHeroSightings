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
        Location location1 = new Location();
        location1.setLocationName("Toronto");
        location1.setLocationDesc("Big City");
        location1.setLocationAddress("Toronto Ontario");
        location1.setLocationLatitude("43.6532° N");
        location1.setLocationLongitude(" 79.3832° W");
        location1 = locationDao.addLocation(location1);

        Location location2 = new Location();
        location2.setLocationName("New York");
        location2.setLocationDesc("Big Apple");
        location2.setLocationAddress("New York State");
        location2.setLocationLatitude("40.7128° N");
        location2.setLocationLongitude("74.0060° W");
        location2 = locationDao.addLocation(location2);

        List<Location> locations = locationDao.getAllLocations();
        assertEquals(locations.size(), 2);

        assertTrue(locations.contains(location1));
        assertTrue(locations.contains(location2));

    }

    @Test
    void getAddAndLocationById() {
        Location location1 = new Location();
        location1.setLocationName("Toronto");
        location1.setLocationDesc("Big City");
        location1.setLocationAddress("Toronto Ontario");
        location1.setLocationLatitude("43.6532° N");
        location1.setLocationLongitude(" 79.3832° W");

        Location location2 = new Location();
        location2.setLocationName("New York");
        location2.setLocationDesc("Big Apple");
        location2.setLocationAddress("New York State");
        location2.setLocationLatitude("40.7128° N");
        location2.setLocationLongitude("74.0060° W");


        location1 = locationDao.addLocation(location1);
        location2 = locationDao.addLocation(location2);
        Location fromDao = locationDao.getLocationById(location1.getLocationId());
        Location fromDao2 = locationDao.getLocationById(location2.getLocationId());

        assertEquals(location1, fromDao);
        assertEquals(location2, fromDao2);

    }



    @Test
    void updateLocation() {
        Location location1 = new Location();
        location1.setLocationName("Toronto");
        location1.setLocationDesc("Big City");
        location1.setLocationAddress("Toronto Ontario");
        location1.setLocationLatitude("43.6532° N");
        location1.setLocationLongitude("79.3832° W");
        location1 = locationDao.addLocation(location1);

        Location location2 = new Location();
        location2.setLocationName("New York");
        location2.setLocationDesc("Big Apple");
        location2.setLocationAddress("New York State");
        location2.setLocationLatitude("40.7128° N");
        location2.setLocationLongitude("74.0060° W");
        location2 = locationDao.addLocation(location2);

        location1.setLocationName("London");
        locationDao.updateLocation(location1);

        location2.setLocationAddress("America");
        locationDao.updateLocation(location2);

        Location fromDao = locationDao.getLocationById(location1.getLocationId());
        Location fromDao1 = locationDao.getLocationById(location2.getLocationId());


        assertEquals(fromDao, location1);
        assertNotEquals(fromDao.getLocationName(), "Toronto");

        assertEquals(fromDao1, location2);
        assertNotEquals(fromDao.getLocationName(), "New York State");


    }

    @Test
    void deleteLocationById() {
        Location location1 = new Location();
        location1.setLocationName("Toronto");
        location1.setLocationDesc("Big City");
        location1.setLocationAddress("Toronto Ontario");
        location1.setLocationLatitude("43.6532° N");
        location1.setLocationLongitude(" 79.3832° W");
        location1 = locationDao.addLocation(location1);

        Location location2 = new Location();
        location2.setLocationName("New York");
        location2.setLocationDesc("Big Apple");
        location2.setLocationAddress("New York State");
        location2.setLocationLatitude("40.7128° N");
        location2.setLocationLongitude("74.0060° W");
        location2 = locationDao.addLocation(location2);

        locationDao.deleteLocationById(location1.getLocationId());

        List<Location> locations = locationDao.getAllLocations();
        assertEquals(1, locations.size());
        assertTrue(locations.contains(location2));

    }
}