package com.sg.SuperHero.dao;

import com.sg.SuperHero.dto.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LocationDaoImpl implements LocationDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LocationDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Location> getAllLocations() {
        final String SELECT_ALL_LOCATIONS = "SELECT * FROM location";
        return jdbcTemplate.query(SELECT_ALL_LOCATIONS, new LocationMapper());
    }

    @Override
    public Location getLocationById(int id) {
        try {
            final String SELECT_LOCATION_BY_ID = "SELECT * FROM location WHERE locationId = ?";
            return jdbcTemplate.queryForObject(SELECT_LOCATION_BY_ID, new Object[]{id}, new LocationMapper());
        } catch(DataAccessException ex) {
            return null;
        }

    }

    @Override
    public Location addLocation(Location location) {

        final String INSERT_LOCATION = "INSERT INTO location(locationName, locationDesc, locationAddress, locationLatitude, locationLongitude) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(INSERT_LOCATION,
                location.getLocationName(),
                location.getLocationDesc(),
                location.getLocationAddress(),
                location.getLocationLatitude(),
                location.getLocationLongitude());

        // Retrieve the last inserted ID

        String selectLastIdQuery = "SELECT LAST_INSERT_ID()";
        int locationId = jdbcTemplate.queryForObject(selectLastIdQuery, Integer.class);

        // Set the game ID
        location.setLocationId(locationId);
        return location;

    }

    @Override
    public void updateLocation(Location location) {
        final String UPDATE_LOCATION = "UPDATE location SET locationName = ?, locationDesc = ?, locationAddress = ?, locationLatitude = ?, locationLongitude = ?  WHERE locationId = ?";
        jdbcTemplate.update(UPDATE_LOCATION,
                location.getLocationName(),
                location.getLocationDesc(),
                location.getLocationAddress(),
                location.getLocationLatitude(),
                location.getLocationLongitude(),
                location.getLocationId());
    }

    @Override
    public void deleteLocationById(int id) {

        final String DELETE_LOCATION_BY_SIGHTING = "DELETE FROM sighting WHERE locationId = ?";
        jdbcTemplate.update(DELETE_LOCATION_BY_SIGHTING, id);

        final String DELETE_LOCATION = "DELETE FROM location WHERE locationId=?";
        jdbcTemplate.update(DELETE_LOCATION, id);

    }

    public static final class LocationMapper implements RowMapper<Location> {

        @Override
        public Location mapRow(ResultSet rs, int index) throws SQLException {
            Location location = new Location();
            location.setLocationId(rs.getInt("locationId"));
            location.setLocationName(rs.getString("locationName"));
            location.setLocationDesc(rs.getString("locationDesc"));
            location.setLocationAddress(rs.getString("locationAddress"));
            location.setLocationLatitude(rs.getString("locationLatitude"));
            location.setLocationLongitude(rs.getString("locationLongitude"));
            return location;
        }
    }

}