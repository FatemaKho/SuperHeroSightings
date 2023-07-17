package com.sg.SuperHero.dao;
import com.sg.SuperHero.dto.Sighting;

import java.util.Date;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lupitaperalta
 */
public interface SightingDao {
    List<Sighting> getAllSightings();
    List<Sighting> getAllSightingForALocation(int locationId);
    List<Sighting> getAllSightingForADate(Date dateSeen);
    Sighting addSighting(Sighting sighting);
    void deleteSighting(int sightingId);
    
}
