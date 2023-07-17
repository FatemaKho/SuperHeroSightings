package com.sg.SuperHero.dao;

import com.sg.SuperHero.dto.Sighting;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lupitaperalta
 */

@Repository
public class SightingDaoDB implements SightingDao{
    private final JdbcTemplate jdbc;
    @Autowired
    public SightingDaoDB(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    @Override
    public List<Sighting> getAllSightings(){
        final String SELECT_ALL_SIGHTINGS = "SELECT * FROM sighting";
        return jdbc.query(SELECT_ALL_SIGHTINGS, new SightingMapper());
    }

    @Override
    public List<Sighting> getAllSightingForALocation(int locationId){
        final String SELECT_ALL_SIGHTINGS = "SELECT * FROM sighting WHERE locationId = ?";
        return jdbc.query(SELECT_ALL_SIGHTINGS, new SightingMapper(), locationId);
    }
    @Override
    public List<Sighting> getAllSightingForADate(Date dateSeen){
        final String SELECT_ALL_SIGHTINGS = "SELECT * FROM sighting WHERE dateSeen = ?";
        return jdbc.query(SELECT_ALL_SIGHTINGS, new SightingMapper(), dateSeen);
    }
    @Override
    public Sighting addSighting(Sighting sighting){
        final String INSERT_SIGHTING = "INSERT INTO sighting(superhumanId, locationId, dateSeen) VALUES(?,?,?)";
        jdbc.update(INSERT_SIGHTING,
                sighting.getSuperhumanId(),
                sighting.getLocationId(),
                sighting.getDateSeen());

        String selectLastIdQuery = "SELECT LAST_INSERT_ID()";
        int sightingId = jdbc.queryForObject(selectLastIdQuery, Integer.class);

        // Set the game ID
        sighting.setSightingId(sightingId);
        return sighting;

    }
    @Override
    public void deleteSighting(int sightingId){
        final String sql = "DELETE FROM sighting WHERE sightingId = ?";
        jdbc.update(sql, sightingId);
    }
}
