package com.sg.SuperHero.dao;

import com.sg.SuperHero.dto.Sighting;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lupitaperalta
 */
public class SightingMapper implements RowMapper<Sighting>{
    
    @Override
    public Sighting mapRow(ResultSet rs, int index) throws SQLException {
        Sighting sighting = new Sighting();
        sighting.setSightingId(rs.getInt("sightingId"));
        sighting.setSuperhumanId(rs.getInt("superhumanId"));
        sighting.setDateSeen(rs.getDate("sightingDate"));
        return sighting;
    }
    
    
}
