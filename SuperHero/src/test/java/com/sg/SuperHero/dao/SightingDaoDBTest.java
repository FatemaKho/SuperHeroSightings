package com.sg.SuperHero.dao;

import com.sg.SuperHero.SuperHeroApplication;
import com.sg.SuperHero.dto.Sighting;
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
class SightingDaoDBTest{

    @Autowired
    private SightingDao sightingDao;


    public SightingDaoDBTest(){
    }

    @BeforeEach
    void setUp() {
//        List<Sighting> sightings = SightingDao.getAllSightings();
//        for(Sighting sighting : sightings) {
//            sightingDao.deleteSighting(sighting.getSightingId());
//        }
    }

    @Test
    void getAllSightings() {

    }
}